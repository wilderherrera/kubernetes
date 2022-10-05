package com.ms.ms_user.dto.user.v1

import com.ms.ms_user.model.User
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget
import org.mapstruct.NullValueCheckStrategy
import org.mapstruct.NullValuePropertyMappingStrategy
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
)
interface UserMapper {
    fun modelToDto(user: User): UserDto
    fun requestToModel(request: UserRequest): User
    fun updateModel(userRequest: UserRequest?, @MappingTarget user: User?)
}
