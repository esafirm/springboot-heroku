package com.example.sprinbootsample.message

class MessageFilter {
    fun filter(message: String): String = message.replace("test", "****")
}
