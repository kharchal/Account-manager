package ua.com.hav.boot.bootjsp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunny on 12.12.17
 */
@Data
@Entity
@Table(name = "men")
@NamedNativeQueries({
        @NamedNativeQuery(name = "prev", query = "SELECT id FROM men WHERE id < ? ORDER BY id DESC LIMIT 1"),
        @NamedNativeQuery(name = "next", query = "SELECT id FROM men WHERE id > ? ORDER BY id ASC LIMIT 1")
})
public class Man {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 3, max = 15)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "man_id", foreignKey = @ForeignKey(name = "pets_man_id_fk"))
    private List<Pet> petList;

    @ManyToMany
    @JoinTable(name = "men_roles",
            joinColumns = @JoinColumn(name = "man_id", foreignKey = @ForeignKey(name = "men_roles_man_id_fk")),
            inverseJoinColumns = @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "men_roles_role_id_fk"))
    )
    private List<Role> roleList = new ArrayList<>();

    public void removeFromList(Integer petId) {
        getPetList().removeIf(p -> p.getId() == petId);
    }

    public void addPet(Pet pet) {
        getPetList().add(pet);
    }
}
