package ua.com.hav.boot.bootjsp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.boot.bootjsp.model.Kind;

/**
 * Created by sunny on 13.12.17
 */
public interface KindRepo extends JpaRepository<Kind, Integer> {
}
