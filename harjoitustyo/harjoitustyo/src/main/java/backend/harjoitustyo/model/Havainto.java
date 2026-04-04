package backend.harjoitustyo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Havainto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nimi;

    private String paikka;

    @JsonIgnoreProperties("retket")
    @ManyToOne
    @JoinColumn(name = "retki_id")
    private Retki retki;

    public Havainto() {
    }

    public Havainto(String nimi, String paikka, Retki retki) {
        this.nimi = nimi;
        this.paikka = paikka;
        this.retki = retki;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getPaikka() {
        return paikka;
    }

    public void setPaikka(String paikka) {
        this.paikka = paikka;
    }

    public Retki getRetki() {
        return retki;
    }

    public void setRetki(Retki retki) {
        this.retki = retki;
    }

    @Override
    public String toString() {
        return "Havainto [id=" + id + ", nimi=" + nimi + ", paikka=" + paikka + ", retki=" + retki + "]";
    }

}
