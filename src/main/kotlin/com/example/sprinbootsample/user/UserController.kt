package com.example.sprinbootsample.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod


@Controller
@RequestMapping("/api/people")
class UserController {

    @Autowired lateinit var userRepo: UserRepository

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun getAllUser(): ResponseEntity<Iterable<User>> {
        return ResponseEntity(userRepo.findAll(), HttpStatus.OK)
    }

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun addPerson(@RequestBody user: User): ResponseEntity<*> {
        return ResponseEntity(userRepo.save(user), HttpStatus.CREATED)
    }
}