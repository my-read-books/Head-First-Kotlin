import java.util.Random

fun main() {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(userChoice, gameChoice)
}

fun getGameChoice(options: Array<String>) =
    options[Random().nextInt(options.size)]

fun getUserChoice(optionsParam: Array<String>): String {
    var isValidChoice = false
    var userChoice = ""

    while (!isValidChoice) {

        print("Please enter one of the following: Rock Paper Scissors.")
        for (item in optionsParam) print(" $item")
        println(".")

        val userInput = readLine()
        if (userInput != null && userInput.capitalize() in optionsParam) {
            isValidChoice = true;
            userChoice = userInput.capitalize()
        }
        if (!isValidChoice) println("You must enter a valid choice.")
    }
    return userChoice
}

fun printResult(userChoice: String, gameChoice: String) {
    val result: String
    if (userChoice == gameChoice) result = "tie"
    else if ((userChoice == "Rock" && "Scissors" == gameChoice) ||
        (userChoice == "Scissors" && "Paper" == gameChoice) ||
        (userChoice == "Paper" && "Rock" == gameChoice)
    ) result = "You win!"
    else result = "You lose!"

    println("You chose $userChoice. I chose $gameChoice. $result")
}