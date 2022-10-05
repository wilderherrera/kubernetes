package com.ms.ms_user.repository.userRepository

import com.ms.ms_user.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository :
    JpaRepository<User, Long>,
    JpaSpecificationExecutor<User> {
    override fun findById(uuid: Long): Optional<User>
}
