package ua.com.hav.boot.bootjsp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.boot.bootjsp.model.Role;

/**
 * Created by sunny on 14.12.17
 */
public interface RoleRepo extends JpaRepository<Role, Integer> {
}
