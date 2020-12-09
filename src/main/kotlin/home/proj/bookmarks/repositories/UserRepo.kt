package home.proj.bookmarks.repositories

import home.proj.bookmarks.domains.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepo : JpaRepository<User, UUID> {
    fun findByUsername(username: String?): User?
}