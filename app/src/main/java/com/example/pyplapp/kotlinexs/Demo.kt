package com.example.pyplapp.kotlinexs

fun main() {
    val waterFilter: (Int) -> Int = {level -> level / 2}
    val id:Int = 20

    val enc1: (String) -> String = { input -> input.toUpperCase() }
    println(encodeMsg("abc", ::convertUpperCase))

}

fun convertUpperCase(ip:String):String{
    return ip.toUpperCase()
}

fun encodeMsg(msg: String,
              encode: (String) -> String): String {
    return encode(msg)
}

fun printHello() {
    println("Hello World")
}

fun double(x: Int): Int {
    return x * 2
}

