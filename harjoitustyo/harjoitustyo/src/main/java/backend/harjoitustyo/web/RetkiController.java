package backend.harjoitustyo.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import backend.harjoitustyo.HarjoitustyoApplication;
import backend.harjoitustyo.model.AppUser;
import backend.harjoitustyo.model.AppUserRepository;
import backend.harjoitustyo.model.Havainto;
import backend.harjoitustyo.model.HavaintoRepositorio;
import backend.harjoitustyo.model.Retki;
import backend.harjoitustyo.model.RetkiRepositorio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.validation.Valid;

@Controller
public class RetkiController {
    private final RetkiRepositorio retkiRepositorio;
    private final HavaintoRepositorio havaintoRepositorio;
    private final AppUserRepository appUserRepository;

    private static final Logger log = LoggerFactory.getLogger(HarjoitustyoApplication.class);

    public RetkiController(RetkiRepositorio retkiRepositorio, HavaintoRepositorio havaintoRepositorio, AppUserRepository appUserRepository) {
        this.retkiRepositorio = retkiRepositorio;
        this.havaintoRepositorio = havaintoRepositorio;
        this.appUserRepository = appUserRepository;
    }

    @GetMapping("/retkilista")
    public String getRetket(Model model) {
        model.addAttribute("retket", retkiRepositorio.findAll());
        return "retkilista";
    }

    @GetMapping("/addretki")
    public String addRetki(Model model) {
        Retki retki = new Retki();
        model.addAttribute("retki", retki);
        return "addretki";
    }

    @PostMapping("/saveadd")
    public String saveAdd(@Valid Retki retki, BindingResult bindingResult, Model model, Authentication authentication) {
        if (bindingResult.hasErrors()) {
            log.info("validation error tapahtui: " + retki.toString());
            model.addAttribute("retki", retki);
            model.addAttribute("retket", retkiRepositorio.findAll());

            return "addretki";
        }

        String username = authentication.getName();
        AppUser user = appUserRepository.findByUsername(username);
        retki.setTekija(user);

        Retki uusi = retkiRepositorio.save(retki);
        return "redirect:/addhavainto/" + uusi.getRetkiId();
    }

    @GetMapping("/addhavainto/{id}")
    public String addHavainto(@PathVariable("id") Long retkiId, Model model) {

        Retki retki = retkiRepositorio.findById(retkiId)
                .orElseThrow(() -> new IllegalArgumentException("Retkeä ei löytynyt id: " + retkiId));

        Havainto uusi = new Havainto();

        uusi.setRetki(retki);

        model.addAttribute("retki", retki);
        model.addAttribute("havainto", uusi);

        return "addhavainto";

    }

    @PostMapping("/saveaddhavainto/{id}")
    public String saveAddHavainto(@PathVariable Long id, @Valid Havainto havainto, BindingResult bindingResult,
            Model model) {
        Retki retki = retkiRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Retkeä ei löytynyt id: " + id));

        if (bindingResult.hasErrors()) {
            log.info("validation error tapahtui: " + havainto.toString());
            model.addAttribute("retki", retki);
            model.addAttribute("havainto", havainto);
            return "addhavainto";
        }

        havainto.setId(null);
        havainto.setRetki(retki);

        havaintoRepositorio.save(havainto);

        return "redirect:/addhavainto/" + id;

    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/editretki/{id}")
    public String editRetki(@PathVariable("id") Long retkiId, Model model) {
        model.addAttribute("retki", retkiRepositorio.findById(retkiId)
                .orElseThrow(() -> new IllegalArgumentException("Retkeä ei löytynyt id: " + retkiId)));

        return "editretki";
    }

    @PostMapping("/saveedit")
    public String saveEdit(@Valid Retki retki, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            log.info("validation error tapahtui: " + retki.toString());
            model.addAttribute("retki", retki);
            model.addAttribute("retket", retkiRepositorio.findAll());

            return "editretki";
        }

        retkiRepositorio.save(retki);
        return "redirect:/edithavainto/" + retki.getRetkiId();
    }

    @GetMapping("/edithavainto/{id}")
    public String editHavainto(@PathVariable("id") Long retkiId, Model model) {

        Retki retki = retkiRepositorio.findById(retkiId)
                .orElseThrow(() -> new IllegalArgumentException("Retkeä ei löytynyt id: " + retkiId));

        model.addAttribute("retki", retki);

        return "edithavainto";

    }

    @PostMapping("/saveedithavainto")
    public String saveEditHavainto(@ModelAttribute Retki retki, @RequestParam String action) {

        for (Havainto h : retki.getHavainnot()) {
            Havainto alkup = havaintoRepositorio.findById(h.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Havaintoa ei löytynyt id: " + h.getId()));
            alkup.setNimi(h.getNimi());
            alkup.setPaikka(h.getPaikka());
            havaintoRepositorio.save(alkup);
        }
        if (action.equals("Tallenna ja lisää havaintoja")) {
            return "redirect:/addhavainto/" + retki.getRetkiId();
        }
        return "redirect:retkilista";

    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/deleteretki/{id}")
    public String deleteRetki(@PathVariable("id") Long retkiId, Model model) {
        retkiRepositorio.deleteById(retkiId);
        return "redirect:../retkilista";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/koti")
    public String koti() {
        return "koti";
    }
}
