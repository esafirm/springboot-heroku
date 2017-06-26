package com.example.sprinbootsample.message

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MessageConfiguration {

    @Bean fun provideFilter(): MessageFilter = MessageFilter()
}