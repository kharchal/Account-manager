package ua.com.hav.boot.bootjsp.model;

import lombok.Data;

import javax.persistence.*;
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

    private String role;

//    @ManyToMany(mappedBy = "roleList")
//    List<Man> manList;
}
