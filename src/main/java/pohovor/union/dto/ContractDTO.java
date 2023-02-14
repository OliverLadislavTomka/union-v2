package pohovor.union.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public abstract class ContractDTO {
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private Date creationDate;
}
