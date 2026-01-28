package tehtavat1.tehtavat2.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MyController {


    @GetMapping("/hello")
    public String sayGreeting(@RequestParam String name, @RequestParam String age, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "hello";

    }


}
