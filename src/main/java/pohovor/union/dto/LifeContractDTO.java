package pohovor.union.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pohovor.union.model.contracts.LifeContract;

import java.util.Date;

@NoArgsConstructor
public class LifeContractDTO extends ContractDTO{
    @Getter
    @Setter
    private Date startDate;

    @Getter
    @Setter
    private Date endDate;

    @Getter
    @Setter
    private Boolean responsibility;

    @Getter
    @Setter
    private Boolean injury;

    public LifeContractDTO(LifeContract lifeContract) {
        this.setId(lifeContract.getId());
        this.setCreationDate(lifeContract.getCreationDate());
        this.startDate = lifeContract.getStartDate();
        this.endDate = lifeContract.getEndDate();
        this.responsibility = lifeContract.getResponsibility();
        this.injury = lifeContract.getInjury();
    }
}
