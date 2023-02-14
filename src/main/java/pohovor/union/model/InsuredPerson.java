package pohovor.union.model;


import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pohovor.union.model.contracts.Contract;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "InsuredPerson")
@NoArgsConstructor
@Getter
@Setter
public class InsuredPerson implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String firstName;

    @Getter
    @Setter
    @Column(nullable = false)
    private String lastName;

    @Getter
    @Setter
    @Column(nullable = false)
    private String birthNumber;

    @Getter
    @Setter
    @Column(nullable = false)
    private String email;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address permanentAddress;


    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address correspodenceAddress;

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY)
    private List<Contract> contracts = new ArrayList<>();

    public InsuredPerson(String firstName, String lastName, String birthNumber, String email, Address permanentAddress, Address correspodenceAddress , List<Contract> contracts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthNumber = birthNumber;
        this.email = email;
        this.permanentAddress = permanentAddress;
        this.correspodenceAddress = correspodenceAddress;
        this.contracts = contracts;
    }
}
