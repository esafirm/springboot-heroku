package com.example.sprinbootsample.message

import com.example.sprinbootsample.StringFilter

class MessageFilter : StringFilter {
    override fun filter(text: String): String = text.replace("test", "****")
}
