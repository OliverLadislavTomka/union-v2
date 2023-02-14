package pohovor.union.model.contracts;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pohovor.union.model.InsuredPerson;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(
                name = "contract.property",
                value = PropertyContract.class
        ),
        @JsonSubTypes.Type(
                name = "contract.life",
                value = LifeContract.class
        ),
})
@JsonIgnoreProperties(value = { "type" })
public abstract class Contract implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private InsuredPerson insuredPerson;

    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date creationDate;

    public Contract(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return id.equals(contract.id) && Objects.equals(creationDate, contract.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate);
    }
}
