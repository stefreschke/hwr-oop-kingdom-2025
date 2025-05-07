package hwr.oop

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.main

class Hello : CliktCommand("cli") {
  // TODO Change name provided to CliktCommand's constructor to the name of the project cli script!
  override fun run() {
    val response = "Hello World!"
    echo(response)
  }
}

fun main(args: Array<String>) = Hello().main(args)
