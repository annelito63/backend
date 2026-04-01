package backend.harjoitustyo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

@Entity
public class Retki {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="retki_id")
    private Long retkiId;

    @NotEmpty(message = "Retken nimi ei voi olla tyhjä")
    private String nimi;

    @NotEmpty(message = "Lisää retken päivämäärä")
    private String pvm;

    private String kuvaus;

    @JsonIgnoreProperties("retki")
    @OneToMany(mappedBy = "retki", cascade = CascadeType.ALL)
    private List<Havainto> havainnot = new ArrayList<>();

    public Retki() {
    }

    public Retki(String nimi, String pvm, String kuvaus) {
        this.nimi = nimi;
        this.pvm = pvm;
        this.kuvaus = kuvaus;
    }

    public Long getRetkiId() {
        return retkiId;
    }

    public void setRetkiId(Long id) {
        this.retkiId = id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getPvm() {
        return pvm;
    }

    public void setPvm(String pvm) {
        this.pvm = pvm;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public List<Havainto> getHavainnot() {
        return havainnot;
    }

    public void setHavainnot(List<Havainto> havainnot) {
        this.havainnot = havainnot;
    }

    public void addHavainto(Havainto havainto) {
        havainto.setRetki(this);
        this.havainnot.add(havainto);
    }

    @Override
    public String toString() {
        return "Retki [id=" + retkiId + ", nimi=" + nimi + ", pvm=" + pvm + ", kuvaus=" + kuvaus + "]";
    }

}
