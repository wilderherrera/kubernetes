package com.ms.ms_user.service.user.v1

import com.ms.ms_user.dto.user.v1.UserDto
import com.ms.ms_user.dto.user.v1.UserRequest
import com.ms.ms_user.model.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification

interface UserService {

    fun index(pageable: Pageable, specification: Specification<User>?): Page<UserDto>
    fun save(userRequest: UserRequest): UserDto
    fun update(userUuid: Long, userRequest: UserRequest): UserDto
    fun show(userUuid: Long): UserDto
    fun delete(userUuid: Long)
}
