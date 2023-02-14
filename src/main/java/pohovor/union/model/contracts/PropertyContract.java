package pohovor.union.model.contracts;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pohovor.union.model.Address;
import pohovor.union.model.InsuredPerson;

import java.io.Serializable;
import java.util.Date;


@Entity
@NoArgsConstructor
@Getter
@Setter
public final class PropertyContract extends Contract implements Serializable {

    public static final String DISCRIMINATOR = "contract.property";

    @Getter
    @Setter
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private PropertyType propertyType;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    @Getter
    @Setter
    @Column(nullable = false)
    private Integer value;

    public PropertyContract(Date creationDate, PropertyType propertyType, Address address, Integer value) {
        super(creationDate);
        this.propertyType = propertyType;
        this.address = address;
        this.value = value;
    }
}
