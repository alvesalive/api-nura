package alves.digital.api.entity;

import io.micrometer.core.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
//for the class Person get recognized like entities of the database, need two annotations
@Entity
@Data //getter and setter lombok
@Builder //pattern for construct object
@AllArgsConstructor //insert constructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true) //other constraint - value uniques - consult more performative
    private String cpf;

    private LocalDate birthDate;

    // observe: List - create a relationship of peoples with many phones
    //annotation of relationship - many to many, one2many ...
    //table intermediary person_phone - strategy to obtain data fetch - lazy is for performance
    //cascade: to do insertion phone only create people
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones;

}
