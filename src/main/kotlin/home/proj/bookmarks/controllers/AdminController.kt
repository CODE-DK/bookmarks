package home.proj.bookmarks.controllers

import home.proj.bookmarks.domains.User
import org.springframework.security.access.annotation.Secured
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@Secured(value = ["ADMIN"])
@RequestMapping("/admin")
class AdminController {

    @GetMapping("/home")
    fun getHomePage(model: Model, @AuthenticationPrincipal user: User): String {
        model.addAttribute("user", user)
        return "adminHome"
    }
}