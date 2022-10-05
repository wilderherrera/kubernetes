package com.ms.ms_user.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity

@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var email: String? = null,
    var nombre: String? = null,
    var apellido: String? = null,
    var fecha: LocalDateTime? = LocalDateTime.now()
)
