package com.example.sprinbootsample

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(DemoApplication::class.java, *args)
}

@Controller
class HelloController {

    @RequestMapping("/")
    @ResponseBody
    fun home(): String = "Hello World"

    @RequestMapping("/api")
    @ResponseBody
    fun welcome(): CommonResponse = CommonResponse(true, "Welcome to Spring boot playground")

    @RequestMapping(method = arrayOf(RequestMethod.POST), name = "/test")
    fun post(@RequestBody req: CommonRequest) = ResponseEntity(req.message, HttpStatus.OK)

}

class Initializer : CommandLineRunner {
    override fun run(vararg args: String?) {

    }
}

data class CommonRequest(val message: String)
data class CommonResponse(val success: Boolean, val message: String)