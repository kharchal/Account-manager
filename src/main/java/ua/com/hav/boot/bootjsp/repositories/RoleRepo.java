package ua.com.hav.boot.bootjsp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.com.hav.boot.bootjsp.model.Role;
import ua.com.hav.boot.bootjsp.model.util.RoleUsage;

import javax.persistence.NamedQuery;
import java.util.List;

/**
 * Created by sunny on 14.12.17
 */
public interface RoleRepo extends JpaRepository<Role, Integer> {

    @Query(name = "unused")
    List<Integer> getUnused();
}
