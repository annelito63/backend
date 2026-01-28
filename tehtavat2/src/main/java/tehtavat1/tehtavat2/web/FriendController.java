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
public class FriendController {
    public static List<Friend> friends = new ArrayList();
    static {
        friends.add(new Friend("Aku", "Ankka"));
        friends.add(new Friend("Iines", "Ankka"));
        friends.add(new Friend("Hannu", "Hanhi"));

    }

    @GetMapping("/friends")
    public String showFriends(Model model) {
        model.addAttribute("kaverit", friends);
        return "friends";
    }

    @GetMapping("/friends/new")
    public String newFriendForm(Model model) {
        model.addAttribute("friend", new Friend());
        return "form";
    }

    @PostMapping("/friends")
    public String greetingSubmit(@ModelAttribute Friend friend) {
        friends.add(friend);
        return "redirect:/friends";
    }

}
