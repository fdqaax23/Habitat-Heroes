// FILE: HabitatHeroes.kt 

// Imports necessary for the program
import java.util.* 
import java.io.* 

// Class definition 
public class HabitatHeroes {

/*
* Function to Validate the user input
* @param entry : String 
* @return true if entry is integer
*/ 
public fun validateInput(entry: String) : Boolean {
    return entry.matches("-?\\d+".toRegex())
}

/*
* Function to get the user input
* @return number
*/
public fun getInput() : Int {
	while(true){
        println("Please enter the number: ")
        val entry = readLine()
        if(validateInput(entry.toString())){ 
            return Integer.parseInt(entry)
        }
        else
            println("Please enter an integer")
    }
    return 0
}

/*
* Function to calculate the result
* @param number : Integer
* @return result 
*/
public fun calculateResult(number : Int) : Int {
    var result = 0

    if (number % 2 == 0)
        result = number / 2
    else
        result = number + 3

    return result
}

/*
* Function to print the result
* @param result : Integer
*/
public fun showResult (result : Int) {
    println("Result is $result")
}

/*
* Function to start the program
*/
public fun start() {
    val number = getInput()
    val result = calculateResult(number)
    showResult(result)
}

/* 
* Main function 
*/
public static fun main(args: Array<String>) {
    val habitatHeroes : HabitatHeroes = HabitatHeroes()
    habitatHeroes.start()
}

}