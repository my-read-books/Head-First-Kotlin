typealias DoubleConversion = (Double) -> Double

fun convert(
    x: Double,
    converter: DoubleConversion
): Double {
    val result = converter(x)
    println("$x is converted to $result")
    return result
}

fun getConversionLambda(str: String): DoubleConversion {
    if (str == "CentigradeToFahrenheit")
        return { it * 1.8 + 32 }
    else if (str == "KgsToPounds")
        return { it * 2.204623 }
    else if (str == "{PoundsToUSTons")
        return { it / 2000.0 }
    else
        return { it }
}

fun combine(
    lambda1: DoubleConversion,
    lambda2: DoubleConversion
): DoubleConversion {
    return { x: Double -> lambda2(lambda1(x)) }
}

fun main() {
    println("Convert 2.5kg to Pounds: ${getConversionLambda("KgsToPounds")(2.5)}")

    val kgsToPoundsLambda = getConversionLambda("KgsToPounds")
    val poundsToUSTonsLambda = getConversionLambda("PoundsToUSTons")

    val kgsToUsTonsLambda = combine(kgsToPoundsLambda, poundsToUSTonsLambda)

    val value = 17.4
    println("$value kgs is ${convert(value, kgsToUsTonsLambda)} US tons")
}