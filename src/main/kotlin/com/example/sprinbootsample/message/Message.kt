package com.example.sprinbootsample.message

import javax.persistence.*

@Entity
@Table(name = "Message")
data class Message(
        @Id @Column(name = "message_id")
        @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0,
        @Column val message: String = ""
)
