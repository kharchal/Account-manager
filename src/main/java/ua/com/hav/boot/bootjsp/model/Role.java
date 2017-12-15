package ua.com.hav.boot.bootjsp.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;


/**
 * Created by sunny on 13.12.17
 */
@Data
@Entity
@Table(name = "roles")
@NamedNativeQueries({
        @NamedNativeQuery(name = "unused",
                query = "SELECT r.id FROM roles r LEFT JOIN men_roles m ON m.role_id = r.id WHERE m.role_id IS NULL"
//                ,resultClass = Integer.class
        )})
@ToString(exclude = "manList")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 4, max = 10)
    @Column(name = "role")
    private String value;

}
