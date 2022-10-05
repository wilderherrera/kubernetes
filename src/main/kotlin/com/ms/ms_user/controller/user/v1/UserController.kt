package com.ms.ms_user.controller.user.v1

import com.ms.ms_user.dto.user.v1.UserDto
import com.ms.ms_user.dto.user.v1.UserRequest
import com.ms.ms_user.model.User
import com.ms.ms_user.service.user.v1.UserService
import com.sipios.springsearch.anotation.SearchSpec
import com.tul.logistic.logistic_packing.dto.request.OnCreate
import com.tul.logistic.logistic_packing.dto.request.OnUpdate
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping
    fun index(pageable: Pageable, @SearchSpec specs: Specification<User>?): ResponseEntity<Page<UserDto>> {
        return ResponseEntity(userService.index(pageable, specs), HttpStatus.OK)
    }

    @PostMapping
    fun create(@Validated(OnCreate::class) @RequestBody request: UserRequest): ResponseEntity<UserDto> =
        ResponseEntity(userService.save(request), HttpStatus.CREATED)

    @PutMapping("/{userId}")
    fun update(@Validated(OnUpdate::class)@RequestBody request: UserRequest, @PathVariable userId: Long): ResponseEntity<UserDto> =
        ResponseEntity(userService.update(userId, request), HttpStatus.OK)

    @GetMapping("/{userId}")
    fun showUser(@PathVariable userId: Long): ResponseEntity<UserDto> =
        ResponseEntity(userService.show(userId), HttpStatus.OK)

    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable userId: Long): ResponseEntity<Unit> =
        ResponseEntity(userService.delete(userId), HttpStatus.OK)
}
