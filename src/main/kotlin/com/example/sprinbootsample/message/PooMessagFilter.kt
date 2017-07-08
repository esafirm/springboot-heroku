package com.example.sprinbootsample.message

import com.example.sprinbootsample.StringFilter

class PooMessagFilter : StringFilter {
    override fun filter(text: String): String = text.replace("test", "poo")
}