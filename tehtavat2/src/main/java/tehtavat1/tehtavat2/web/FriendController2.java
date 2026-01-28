package tehtavat1.tehtavat2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import domain.Friend;

@Controller
public class FriendController2 {
    public static List<Friend> friends = new ArrayList();
    static {
        friends.add(new Friend("Aku", "Ankka"));
        friends.add(new Friend("Iines", "Ankka"));
        friends.add(new Friend("Hannu", "Hanhi"));

    }

    @GetMapping("/friends2")
    public String showFriends(Model model) {
        model.addAttribute("kaverit", friends);
        model.addAttribute("friend", new Friend());
        return "friends2";
    }

    @PostMapping("/friends2")
    public String greetingSubmit(@ModelAttribute Friend friend) {
        friends.add(friend);
        return "redirect:/friends2";
    }

}
