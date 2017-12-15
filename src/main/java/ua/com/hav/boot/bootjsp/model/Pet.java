package ua.com.hav.boot.bootjsp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by sunny on 11.12.17
 */
@Data
@Entity
@Table(name = "pets")
@NamedNativeQueries({@NamedNativeQuery(name = "manless", query = "SELECT * FROM pets WHERE man_id IS NULL", resultClass = Pet.class)})
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, max = 10)
    private String name;

    @Min(4)
    @Max(27)
    private int age;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "pets_kind_id_fk"))
    private Kind kind;
}
