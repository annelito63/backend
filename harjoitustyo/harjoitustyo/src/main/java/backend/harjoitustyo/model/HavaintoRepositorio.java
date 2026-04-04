package backend.harjoitustyo.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface HavaintoRepositorio extends CrudRepository<Havainto, Long>{
    List<Havainto> findByNimi(String nimi);
    
}
