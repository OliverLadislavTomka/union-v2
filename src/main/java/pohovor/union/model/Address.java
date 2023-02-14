package pohovor.union.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Address implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private Integer postcode;

    @Getter
    @Setter
    @Column(nullable = false)
    private String city;

    @Getter
    @Setter
    @Column(nullable = false)
    private String street;

    @Getter
    @Setter
    @Column(nullable = false)
    private Long streetNumber;

    public Address(Long id, Integer postcode, String city, String street, Long streetNumber) {
        this.id = id;
        this.postcode = postcode;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
    }
}
