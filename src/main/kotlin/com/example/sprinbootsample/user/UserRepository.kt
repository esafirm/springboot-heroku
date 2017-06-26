package com.example.sprinbootsample.user

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, String>
