package backend.harjoitustyo.web;

import org.springframework.web.bind.annotation.RestController;

import backend.harjoitustyo.model.RetkiRepositorio;
import backend.harjoitustyo.model.Havainto;
import backend.harjoitustyo.model.Retki;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class RestRetkiController {

    private final RetkiRepositorio rRepositorio;

    

    public RestRetkiController(RetkiRepositorio rRepositorio){
        this.rRepositorio = rRepositorio;
    }

    @GetMapping("/retket")
    public Iterable<Retki> etsiKaikkiRetket(){
        return rRepositorio.findAll();
    }

    @GetMapping("/retket/{id}")
    public Optional<Retki> etsiYksiRetki(@PathVariable("id") Long retkiId){
        return rRepositorio.findById(retkiId);
    }
    
    @PostMapping("/retket")
    public Retki tallennaRetki(@RequestBody Retki retki) {
         if (retki.getHavainnot() != null) {
            for (Havainto h : retki.getHavainnot()) {
                h.setRetki(retki);
            }
        }
        return rRepositorio.save(retki);
    }
    
    @PutMapping("/retket/{retkiId}")
    public Retki tallennaMuokattuRetki(@RequestBody Retki muokattuRetki, @PathVariable Long retkiId){
        muokattuRetki.setRetkiId(retkiId);
        return rRepositorio.save(muokattuRetki);
    }

    @DeleteMapping("/retket/{retkiId}")
    public Iterable<Retki> poistaRetki(@PathVariable Long retkiId){
        rRepositorio.deleteById(retkiId);
        return rRepositorio.findAll();
    }


    
}
