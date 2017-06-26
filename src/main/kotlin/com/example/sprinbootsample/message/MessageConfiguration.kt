package com.example.sprinbootsample.message

import com.example.sprinbootsample.StringFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MessageConfiguration {

    @Bean fun provideFilter(): StringFilter = MessageFilter()
}