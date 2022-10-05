package com.ms.ms_user.service.user.v1.impl

import com.ms.ms_user.dto.user.v1.UserDto
import com.ms.ms_user.dto.user.v1.UserMapper
import com.ms.ms_user.dto.user.v1.UserRequest
import com.ms.ms_user.model.User
import com.ms.ms_user.repository.userRepository.UserRepository
import com.ms.ms_user.service.user.v1.UserService
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
    override fun index(pageable: Pageable, specification: Specification<User>?): Page<UserDto> {
        return userRepository.findAll(specification, pageable).map(userMapper::modelToDto)
    }

    @Transactional
    override fun save(userRequest: UserRequest): UserDto {
        return userRepository.save(userMapper.requestToModel(userRequest)).let(userMapper::modelToDto)
    }

    @Transactional
    override fun update(userUuid: Long, userRequest: UserRequest): UserDto {
        val user = userRepository.findById(userUuid).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
        userMapper.updateModel(userRequest, user)
        userRepository.save(user)
        return user.let(userMapper::modelToDto)
    }

    override fun show(userUuid: Long): UserDto = userRepository.findById(userUuid).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }.let(userMapper::modelToDto)

    @Transactional
    override fun delete(userUuid: Long) {
        userRepository.findById(userUuid).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
        userRepository.deleteById(userUuid)
    }
}
