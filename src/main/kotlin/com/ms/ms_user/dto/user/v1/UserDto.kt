package com.ms.ms_user.dto.user.v1

import java.time.LocalDateTime

class UserDto {
    var id: Long? = null
    var email: String? = null
    var nombre: String? = null
    var apellido: String? = null
    var fecha: LocalDateTime? = null
}
