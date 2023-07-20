#include <stdio.h> 
#include <string.h> 
  
// Constant declarations 
#define NUM_HEROES 3 
#define MAX_NAME_LENGTH 12 
#define MAX_SPECIES_LENGTH 25 
  
// Struct declarations 
// Superheroes declarations 
struct Superhero 
{ 
    char name[MAX_NAME_LENGTH]; 
    char species[MAX_SPECIES_LENGTH]; 
    int enemies_beaten; 
    int trophies_won; 
}; 
  
// Function declarations 
void initHeroes(struct Superhero *heroes); 
void printHeroes(struct Superhero *heroes); 
  
int main() 
{ 
    // Declare heroes 
    struct Superhero heroes[NUM_HEROES]; 
  
    // Initialize heroes 
    initHeroes(heroes); 
  
    // Print heroes 
    printHeroes(heroes); 
  
    return 0; 
} 
  
// Function definitions 
// Initialize heroes 
void initHeroes(struct Superhero *heroes) 
{ 
    strcpy(heroes[0].name, "Spiderman"); 
    strcpy(heroes[0].species, "human-arachnid hybrid"); 
    heroes[0].enemies_beaten = 8; 
    heroes[0].trophies_won = 15; 
  
    strcpy(heroes[1].name, "Flash"); 
    strcpy(heroes[1].species, "human"); 
    heroes[1].enemies_beaten = 7; 
    heroes[1].trophies_won = 16; 
  
    strcpy(heroes[2].name, "Wonder Woman"); 
    strcpy(heroes[2].species, "Amazonian"); 
    heroes[2].enemies_beaten = 9; 
    heroes[2].trophies_won = 14; 
} 
  
// Print superhero data 
void printHeroes(struct Superhero *heroes) 
{ 
    int i; 
  
    for (i = 0; i < NUM_HEROES; i++) 
    { 
        printf("Name: %s\n", heroes[i].name); 
        printf("Species: %s\n", heroes[i].species); 
        printf("Enemies beaten: %d\n", heroes[i].enemies_beaten); 
        printf("Trophies won: %d\n", heroes[i].trophies_won); 
        printf("\n"); 
    } 
}