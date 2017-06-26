package com.example.sprinbootsample.user

import org.springframework.data.annotation.PersistenceConstructor
import javax.persistence.*

@Entity
@Table(name = "User")
class User @PersistenceConstructor constructor(
        @Id @Column(name = "user_id")
        @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = -1,
        @Column val name: String = "",
        @Column val age: Int = 0
)
