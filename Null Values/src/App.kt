class Wolf{
    var hunger = 10
    val food = "meat"

    fun eat(){
        println("The Wolf is eating $food")
    }
}

class MyWolf {
    var wolf: Wolf? = Wolf()

    fun myFunction(){
        wolf?.eat()
    }
}

fun getAlphaWolf(): Wolf? {
    return Wolf()
}

fun main() {
    var w: Wolf? = Wolf()

    if (w != null)
        w.eat()

    var x = w?.hunger
    println("The value of x is $x")

    var y = w?.hunger ?: -1
    println("The value of y is $y")

    var myWolf = MyWolf()
    myWolf?.wolf?.hunger = 8
    println("The value of myWolf?.wolf?.hunger is ${myWolf?.wolf?.hunger}")

    var myArray = arrayOf("Hi", "Hello", null)
    for (item in myArray)
        item?.let { println(it) }

    getAlphaWolf()?.let { it.eat() }

//    w = null          -error
//    var z  = w!!.hunger   -error

    testException("No")
    println()
    testException("Yes")
}

private fun testException(test: String) {
    try {
        println("Start try")
        riskyCode(test)
        println("End try")
    } catch (e: BadException) {
        println("BadException")
    } finally {
        println("Finally")
    }

    println("End of main")
}

class BadException: Exception()

fun riskyCode(test: String){
    println("start risky code")
    if (test == "Yes")
        throw BadException()

    println("End risky code")
}