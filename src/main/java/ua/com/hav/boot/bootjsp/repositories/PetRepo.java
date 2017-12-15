package ua.com.hav.boot.bootjsp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.com.hav.boot.bootjsp.model.Pet;

import java.util.List;

/**
 * Created by sunny on 13.12.17
 */
public interface PetRepo extends JpaRepository<Pet, Integer> {

    @Query(name = "manless")
    List<Pet> findManless();

}
