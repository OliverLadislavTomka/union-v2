package pohovor.union.model.contracts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
public final class LifeContract extends Contract implements Serializable {


    public static final String DISCRIMINATOR = "contract.life";

    @Getter
    @Setter
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Getter
    @Setter
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Getter
    @Setter
    @Column(nullable = false)
    private Boolean responsibility;

    @Getter
    @Setter
    @Column(nullable = false)
    private Boolean injury;

    public LifeContract(Date creationDate, Date startDate, Date endDate, Boolean responsibility, Boolean injury) {
        super(creationDate);
        this.startDate = startDate;
        this.endDate = endDate;
        this.responsibility = responsibility;
        this.injury = injury;
    }
}
