package com.ms.ms_user.service.user.v1.impl

import com.fasterxml.jackson.databind.ObjectMapper
import com.ms.ms_user.dto.user.v1.UserDto
import com.ms.ms_user.dto.user.v1.UserMapper
import com.ms.ms_user.dto.user.v1.UserRequest
import com.ms.ms_user.model.User
import com.ms.ms_user.repository.userRepository.UserRepository
import com.ms.ms_user.service.user.v1.UserService
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper,
) : UserService {
    val log = LoggerFactory.getLogger(javaClass)

    override fun index(pageable: Pageable, specification: Specification<User>?): Page<UserDto> {
        log.debug("Consulta de todos los usuarios en la lista")
        return userRepository.findAll(specification, pageable).map(userMapper::modelToDto)
    }

    @Transactional
    override fun save(userRequest: UserRequest): UserDto {
        log.debug("Nuevo usuario creado " + ObjectMapper().writeValueAsString(userRequest))
        return userRepository.save(userMapper.requestToModel(userRequest)).let(userMapper::modelToDto)
    }

    @Transactional
    override fun update(userUuid: Long, userRequest: UserRequest): UserDto {
        val user = userRepository.findById(userUuid).orElseThrow {
            log.error("Usuario con id $userUuid no se encuentra en la base de datos")
            ResponseStatusException(HttpStatus.NOT_FOUND)
        }
        userMapper.updateModel(userRequest, user)
        userRepository.save(user)
        log.debug("Usuario actualizado " + ObjectMapper().writeValueAsString(userRequest))
        return user.let(userMapper::modelToDto)
    }

    override fun show(userUuid: Long): UserDto = userRepository.findById(userUuid).orElseThrow {
        log.error("Usuario con id $userUuid no se encuentra en la base de datos")
        ResponseStatusException(HttpStatus.NOT_FOUND)
    }.let(userMapper::modelToDto)

    @Transactional
    override fun delete(userUuid: Long) {
        log.debug("Usuario borrado")
        userRepository.findById(userUuid).orElseThrow {
            log.error("Usuario con id $userUuid no se encuentra en la base de datos")
            ResponseStatusException(HttpStatus.NOT_FOUND)
        }
        userRepository.deleteById(userUuid)
    }
}
