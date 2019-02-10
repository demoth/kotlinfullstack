package sampleprogram

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class SampleProgram

fun main(args: Array<String>) {
    SpringApplication.run(SampleProgram::class.java, *args)
}