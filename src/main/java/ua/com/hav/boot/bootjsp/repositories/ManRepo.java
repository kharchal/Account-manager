package ua.com.hav.boot.bootjsp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.com.hav.boot.bootjsp.model.Man;

import javax.persistence.NamedQuery;
import java.util.List;

/**
 * Created by sunny on 13.12.17
 */
public interface ManRepo extends JpaRepository<Man, Integer> {

    @Query(name = "next")
    Integer findNextId(int id);

    @Query(name = "prev")
    Integer findPrevId(int id);
}
