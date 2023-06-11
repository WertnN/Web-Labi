package com.wertnExamlpe.foodApplication

import com.wertnExamlpe.foodApplication.dto.LoginDto
import com.wertnExamlpe.foodApplication.dto.RegisterDto
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
@Controller
class WebController {

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("registerDTO", RegisterDto())
        model.addAttribute("loginDTO", LoginDto())
        return "index"
    }
}