package home.proj.bookmarks.services

import home.proj.bookmarks.repositories.UserRepo
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepo: UserRepo) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        return userRepo.findByUsername(username)!!
    }
}