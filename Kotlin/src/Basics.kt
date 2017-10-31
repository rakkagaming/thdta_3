/**
 * Created by robin on 30/10/2017.
 */
fun main(args: Array<String>) {
    numbers()
    println("----------------------------------------")
    strings()
}

fun strings(){
    val s  = "Hello World"
    for (c in s)
        print(c)

    println()

    val quote = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()

    println(quote)

    val price = """${'$'}9.99"""
    println("$price is the 'price' variable, and it has the length of ${price.length}")
}

fun numbers(){
    val a = 10000
    val boxedA: Int? = a
    val anotherA: Int? = a
    println("is a==a? : " + (a==a))
    println("is a===a? : " + (a===a))
    println("is boxedA==anotherA ? : " + (boxedA==anotherA))
    println("is boxedA===anotherA ? : " + (boxedA===anotherA))

    val b = 20f
    println("b = " + b)
    println("Value b is just declared as 'val b = 20f'")
    println("This makes it a float value as it is designated as such by the 'f'")

    println("can we do a+b=c? a is an int while b is a float")
    val c = a+b
    println("result is: " + c)
    println("this is because Kotlin takes the variables and converts it so both work, ie float in this instance")
}