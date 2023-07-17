% This script will create a game of 'Habitat Heroes' using Matlab.

% Clear the workspace
clc, clear

% Define game constants
WIDTH = 20;
HEIGHT = 20;
NUM_PLAYERS =4;

% Define game variables
gameBoard = zeros(HEIGHT,WIDTH); % Create a zero matrix

% Create a figure window
fig = figure;

% Create axes
ax = axes('Parent', fig);

% Set figure parameters
title('Habitat Heroes');
xlim([-1 WIDTH+1]);
ylim([-1 HEIGHT+1]);
axis ('square');
hold on

%***** PLAYER SETUP *****

% Create a player structure array
player(NUM_PLAYERS) = struct('x', 0, 'y', 0, 'xVel', 0, 'yVel', 0, 'marker', '', 'score', 0);

% Set each player's initial position and velocity
player(1).x = 1;
player(1).y = 1;
player(1).xVel = 1;
player(1).yVel = 0;
player(1).marker = 'b';

player(2).x = 1;
player(2).y = HEIGHT;
player(2).xVel = 1;
player(2).yVel = 0;
player(2).marker = 'r';

player(3).x = WIDTH - 1;
player(3).y = 1;
player(3).xVel = -1;
player(3).yVel = 0;
player(3).marker = 'y';

player(4).x = WIDTH - 1;
player(4).y = HEIGHT;
player(4).xVel = -1;
player(4).yVel = 0;
player(4).marker = 'g';

%***** IN-GAME OBJECT SETUP *****

% Define the number of objects
num_trees = 10;
num_rocks = 20;
num_fences = 5;

% Create object structures
tree(num_trees) = struct('x',0,'y',0,'marker','v');
rock(num_rocks) = struct('x',0,'y',0,'marker','o');
fence(num_fences) = struct('x',0,'y',0,'marker','k');

% Set each object's position
for i = 1:num_trees
   tree(i).x = randi([2 WIDTH-1]);
   tree(i).y = randi([2 HEIGHT-1]);
   tree(i).marker = 'v';
end

for i = 1:num_rocks
   rock(i).x = randi([2 WIDTH-1]);
   rock(i).y = randi([2 HEIGHT-1]);
   rock(i).marker = 'o';
end

for i = 1:num_fences
   fence(i).x = randi([2 WIDTH-1]);
   fence(i).y = randi([2 HEIGHT-1]);
   fence(i).marker = 'k';
end

%***** GAME LOOP *****

% Define game loop parameters
gameOver = 0;
winner = 0;

while ~gameOver
    
    % Update game board
    gameBoard = zeros(HEIGHT,WIDTH);
    
    % Update player positions
    for i = 1:NUM_PLAYERS
        player(i).x = player(i).x + player(i).xVel;
        player(i).y = player(i).y + player(i).yVel;
        
        % Check for wall collisions
        if player(i).x < 1 || player(i).x > WIDTH || player(i).y < 1 || player(i).y > HEIGHT
            % End game if a player hits a wall
            gameOver = 1;
            winner = 0;
            break;
        end
        
        % Check for object collisions
        for j = 1:num_trees
            if player(i).x == tree(j).x && player(i).y == tree(j).y
                % Increase score and reset position if player hits a tree
                player(i).score = player(i).score + 1;
                player(i).x = 1;
                player(i).y = 1;
                player(i).xVel = 1;
                player(i).yVel = 0;
                break;
            end
        end
        
        for j = 1:num_rocks
            if player(i).x == rock(j).x && player(i).y == rock(j).y
                % Reset position if player hits a rock
                player(i).x = 1;
                player(i).y = 1;
                player(i).xVel = 1;
                player(i).yVel = 0;
                break;
            end
        end
        
        for j = 1:num_fences
            if player(i).x == fence(j).x && player(i).y == fence(j).y
                % Reset position if player hits a fence
                player(i).x = 1;
                player(i).y = 1;
                player(i).xVel = 1;
                player(i).yVel = 0;
                break;
            end
        end
        
        % Update game board with new player position
        gameBoard(player(i).y,player(i).x) = 1;
    end
    
    % Update object positions
    for i = 1:num_trees
        gameBoard(tree(i).y,tree(i).x) = 2;
    end
    
    for i = 1:num_rocks
        gameBoard(rock(i).y,rock(i).x) = 2;
    end
    
    for i = 1:num_fences
        gameBoard(fence(i).y,fence(i).x) = 3;
    end
    
    % Plot the game board
    imagesc(gameBoard);
    caxis([0 3])
    colormap([0.3 0.3 0.3;0 0 1;0 0 0]);
    
    % Update figure
    drawnow
    
    % Check for a winner
    if ~gameOver
        for i = 1:NUM_PLAYERS
            if player(i).score == 5
                % End game if a player has 5 points
                gameOver = 1;
                winner = i;
                break;
            end
        end
    end
    
end

% Display winner
if winner == 0
    disp('No one wins.')
else
    disp(['Player ' num2str(winner) ' wins!'])
end