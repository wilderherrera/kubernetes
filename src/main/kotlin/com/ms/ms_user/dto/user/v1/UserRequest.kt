package com.ms.ms_user.dto.user.v1

import com.tul.logistic.logistic_packing.dto.request.OnCreate
import java.time.LocalDateTime
import javax.validation.constraints.NotNull

class UserRequest {
    @NotNull(groups = [OnCreate::class])
    var email: String? = null
    @NotNull(groups = [OnCreate::class])
    var nombre: String? = null
    @NotNull(groups = [OnCreate::class])
    var apellido: String? = null
    var fecha: LocalDateTime? = null
}
