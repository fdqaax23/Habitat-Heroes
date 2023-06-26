package main
 
import "fmt"
 
func main() {

	//Introduction Message
	fmt.Println("Welcome to Habitat Heroes!")

	//Declaring Variables
	var score int
	var actionsCompleted int
	var rank string
	var currentLocation string
	var currentTask string

	//Game Loop
	for {
		//Display Current Information
		fmt.Println("\nScore:", score)
		fmt.Println("Actions Completed:", actionsCompleted)
		fmt.Println("Rank:", rank)
		fmt.Println("Current Location:", currentLocation)
		fmt.Println("Current Task:", currentTask)
		
		//Get User Input
		fmt.Println("\nWhat would you like to do?")
		fmt.Println("1. Move to new location")
		fmt.Println("2. Complete a task")
		fmt.Println("3. Check rank")
		fmt.Println("4. Quit")

		//Read user input
		var userInput int
		fmt.Scanf("%d", &userInput)

		//Switch Statement
		switch userInput {
		case 1:
			currentLocation = "New Location"
			fmt.Println("You have moved to", currentLocation)
		case 2:
			//Complete Task
			currentTask = "Complete"
			score += 10
			actionsCompleted++
			fmt.Println("You have completed the task!")
		case 3:
			//Check rank
			if actionsCompleted >= 10 {
				rank = "Hero"
			} else {
				rank = "Beginner"
			}
			fmt.Println("Your rank is", rank)
		case 4:
			//Quit
			fmt.Println("Goodbye!")
			return
		default:
			fmt.Println("Invalid input!")
			continue
		}	
	}
}