package tehtavat1.tehtavat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
public class MyController {
    @RequestMapping("/index")
    
    public String showMain() {
        return "This is the main page";
    }

    @RequestMapping("/contact")
    
    public String showContact() {
        return "This is the contact page";
    }

    @RequestMapping("/hello")
    public String returnGreeting(@RequestParam(name = "location", required=false, defaultValue = "") String paikka,
                                @RequestParam(name ="name") String nimi){
        return "Welcome to the " + paikka +" " + nimi + "!";

    }


}
