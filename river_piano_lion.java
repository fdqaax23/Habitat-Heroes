import java.awt.Image;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HabitatHeroes {
 
    public static void main(String[] args) throws IOException {
 
        // Create a new window
        JFrame window = new JFrame("Habitat Heroes");
        window.setSize(600,400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // Create a panel with a background image
        Image backgroundImage = ImageIO.read(new File("background.png"));
        JPanel panel = new ImagePanel(backgroundImage);
        window.add(panel);
 
        // Create a button to start the game
        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                playGame();
            }
        });
        panel.add(startButton);
 
        // Create a button to view the highscores
        JButton highScoreButton = new JButton("View High Scores");
        highScoreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                viewHighScores();
            }
        });
        panel.add(highScoreButton);
 
        // Create a button to quit the game
        JButton quitButton = new JButton("Quit Game");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        panel.add(quitButton);
 
        // Display the window
        window.setVisible(true);
    }
 
    private static void playGame() {
        // Load the game
        Game game = new Game();
        game.loadGame();
        // Start the game
        game.start();
    }
 
    private static void viewHighScores() {
        // Load the high scores
        HighScores score = new HighScores();
        score.loadHighScores();
        // Display the high scores
        score.displayHighScores();
    }
}