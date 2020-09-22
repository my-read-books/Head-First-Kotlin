import kotlin.random.Random

fun main() {
    val wordArray1 = arrayOf("24/7", "multi-tier", "B-to-B", "dynamic", "pervasive")
    val wordArray2 = arrayOf("empowered", "leveraged", "aligned", "targeted")
    val wordArray3 = arrayOf("process", "paradigm", "solution", "portal", "vision")

    val arraySize1 = wordArray1.size
    val arraySize2 = wordArray2.size
    val arraySize3 = wordArray3.size

    val rand1 = (Math.random() * arraySize1).toInt()
    val rand2 = (Math.random() * arraySize2).toInt()
    val rand3 = (Math.random() * arraySize3).toInt()

    val phrase = "${wordArray1[rand1]} ${wordArray2[rand2]} ${wordArray3[rand3]}"

    println(phrase)

    var myArray = arrayOf(1, 2, 3)
    var result = "myArray is ${if (myArray.size > 10) "large" else "small"}"

    // if version 1.3 or above can use kotlin.random.Random.nextInt()
    println(Random.nextInt(10))

    // update by index
    myArray[0] = 8
    println("Change item in index 0 to value 8 $myArray")

    //explicit define arrays type
    var explicitArray: Array<Byte> = arrayOf(1, 2, 3)

    // var array can refer to another array
    myArray = arrayOf(4, 3, 2, 1)
    // val array can't refer to another array, but you still can change value by index
    val valArray = arrayOf(1, 2, 3)
    // valArray = arrayOf(3, 2, 1)   -  error
    valArray[0] = 10

    //if in string templates single value without other function an operation can use without {}
    val textArray: Array<String> = arrayOf("", "")
    textArray[0] = "Text with single uses $textArray"
    textArray[1] = "Text with non-single uses ${textArray[1]}"
//    textArray[1] = "This is inappropriate sting templates $textArray[1]"
    println("String array $textArray")
}
