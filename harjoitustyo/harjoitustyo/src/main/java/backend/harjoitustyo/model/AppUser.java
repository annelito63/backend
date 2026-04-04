package backend.harjoitustyo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "application_user")

public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name = "tekija_id")
    private Long tekijaId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "user_role", nullable = false)
    private String role;

    @JsonIgnoreProperties("tekija")
    @OneToMany(mappedBy = "tekija", cascade = CascadeType.ALL)
    private List<Retki> retket = new ArrayList<>();

    public AppUser() {
    }

    public AppUser(String username, String passwordHash, String role) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
	}

    public Long getId() {
        return tekijaId;
    }

    public void setId(Long tekijaId) {
        this.tekijaId = tekijaId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
