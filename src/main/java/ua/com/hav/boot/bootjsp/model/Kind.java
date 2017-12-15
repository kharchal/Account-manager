package ua.com.hav.boot.bootjsp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by sunny on 11.12.17
 */
@Data
@Entity
@Table(name = "kinds")
public class Kind {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, max = 10)
    private String value;

}
