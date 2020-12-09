package home.proj.bookmarks.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    @GetMapping("/")
    fun getHomePage(model: Model): String {
        model.addAttribute("user", "John Doe")
        return "redirect:home"
    }
}