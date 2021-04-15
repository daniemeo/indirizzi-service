package it.sogei.svildep.indirizziservice.repository;
import it.sogei.svildep.indirizziservice.model.Indirizzo;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface IndirizzoRepository extends JpaRepository<Indirizzo,Long> {


    public List<Indirizzo> findAllIndirizziBySoggettoFisico_id(Long id);

}
