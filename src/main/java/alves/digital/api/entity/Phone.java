package alves.digital.api.entity;

import alves.digital.api.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
    //primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY ) //strategy of insertion on id - delegate to database
    private Long id;

    @Enumerated(EnumType.STRING) //to insert values of enum class
    @Column(nullable = false) //for create rule, a constraint of database - create like mandatory/required
    private PhoneType type;

    @Column(nullable = false)
    private String number;
}
