package it.sogei.svildep.indirizziservice.repository;
import it.sogei.svildep.indirizziservice.model.Indirizzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IndirizzoRepository extends JpaRepository<Indirizzo,Long> {

    @Query("from Indirizzo i join i.soggettoFisico ")
    public List<Indirizzo> findAllEager();

}
