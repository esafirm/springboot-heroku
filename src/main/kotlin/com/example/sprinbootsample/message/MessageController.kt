package com.example.sprinbootsample.message

import com.example.sprinbootsample.StringFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping("/api/message")
class MessageController {

    @Autowired lateinit var messageRepo: MessageRepository
    @Autowired lateinit var messageFilter: StringFilter

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun getMessages() = ResponseEntity(messageRepo.findAll().map {
        it.copy(message = messageFilter.filter(it.message))
    }, HttpStatus.OK)

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun addMessage(@RequestBody message: Message): ResponseEntity<*> {
        return ResponseEntity(messageRepo.save(message), HttpStatus.CREATED)
    }
}