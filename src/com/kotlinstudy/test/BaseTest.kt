package com.kotlinstudy.test

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String,arg2: String){
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    if(x == null){
        println("Wrong number format in arg1: '${arg1}'")
        return
    }

    if(y == null){
        println("Wrong number format in arg2: '${arg2}'")
        return
    }

    println(x * y)
}


val lazyValue: String by lazy {
    println("computer！")
    "hello"
}
fun main(args: Array<String>){
    println("hello, world")

    printProduct("6","7")
    printProduct("a","7")
    printProduct("9","b")

    var items = listOf<String>("apple", "banana", "kiwi")

    for(item in items){
        println(item)
    }

    var x= 10
    var y = 9
    if(x in 1..y+1){
        println("fits in range")
    }

    for(x in 1..5){
        print(x)
    }

    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }

    println(lazyValue)
//    println(lazyValue)
}