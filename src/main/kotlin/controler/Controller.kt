package controler

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class Controller {

    //todo: use CalendarChecker
    @GetMapping("/")
    fun blog(model: String): String {

        return "blog"
    }

}