package backend.harjoitustyo.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RetkiRepositorio extends CrudRepository<Retki, Long> {
    List<Retki> findByNimi(String nimi);
}
