package com.kotlinstudy.test

import kotlin.coroutines.experimental.SequenceBuilder
import kotlin.coroutines.experimental.buildSequence

fun main(args: Array<String>){
    var sum = 0
    var ints:IntArray = intArrayOf(1, 2, 3)
    ints.filter{it > 0}.forEach{
        sum += it
    }

    println()

    println(sum)

    var fibonacciSep = buildSequence {
        var a = 0
        var b = 1

        yield(1)

        while(true){
            yield(a + b)
            val tmp = a + b
            a = b
            b = tmp
        }

    }

    println(fibonacciSep.take(8).toList())

    var lazySeq = buildSequence {
        print("START")
        for(i in 1..5){
            yield(i)
            print("STEP")
        }
        println("END")
    }

    lazySeq.take(6).forEach{
        print("$it")
    }

    val lazySeq1 = buildSequence {
        yield(0)
        yieldAll(1..10)

    }
    lazySeq1.forEach{ print("$it")}

    println("-----------------")
    lazySeq.take(6).forEach { print("$it ") }

}

suspend fun SequenceBuilder<Int>.yieldIfOdd(x: Int){
    if (x %2 != 0) yield(x)
}

val lazySeq = buildSequence{
    if(6 in 1..10){
        yieldIfOdd(6)
    }
}