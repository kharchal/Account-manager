package ua.com.hav.boot.bootjsp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by sunny on 13.12.17
 */
@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 4, max = 10)
    private String role;

}
