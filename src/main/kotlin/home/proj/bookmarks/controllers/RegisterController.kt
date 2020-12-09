package home.proj.bookmarks.controllers

import home.proj.bookmarks.domains.Role
import home.proj.bookmarks.domains.User
import home.proj.bookmarks.repositories.UserRepo
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import java.util.*

@Controller
class RegisterController(private val userRepo: UserRepo) {

    @GetMapping("/login")
    fun getLoginPage() = "login"

    @GetMapping("/register")
    fun getRegisterPage() = "redirect:register"

    //@PostMapping("/login")
    //fun loginUser(model: Model, user: User): String {
    //    model.addAttribute("user", user)
    //    return "home"
    //}

    @PostMapping("/register")
    fun saveUser(model: Model, user: User): String {

        user.isActive = true
        user.roles = mutableSetOf(Role.USER)
        user.userId = UUID.randomUUID()

        userRepo.findByUsername(user.username)?.let {
            model.addAttribute("error", "This user is currently exist")
            return "register"
        }
        userRepo.save(user)
        model.addAttribute("user", user)
        return "login"
    }
}