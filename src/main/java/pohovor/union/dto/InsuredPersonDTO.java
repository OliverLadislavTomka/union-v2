package pohovor.union.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pohovor.union.model.InsuredPerson;
import pohovor.union.model.contracts.Contract;
import pohovor.union.model.contracts.LifeContract;
import pohovor.union.model.contracts.PropertyContract;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class InsuredPersonDTO {
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String birthNumber;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private AddressDTO permanentAddress;


    @Getter
    @Setter
    private AddressDTO correspodenceAddress;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Getter
    @Setter
    private List<ContractDTO> contracts;

    public InsuredPersonDTO(InsuredPerson insuredPerson, boolean transformContracts) {
        this.id = insuredPerson.getId();
        this.firstName = insuredPerson.getFirstName();
        this.lastName = insuredPerson.getLastName();
        this.birthNumber = insuredPerson.getBirthNumber();
        this.email = insuredPerson.getEmail();
        this.permanentAddress = new AddressDTO(insuredPerson.getPermanentAddress());
        this.correspodenceAddress =
                insuredPerson.getCorrespodenceAddress() == null ?
                this.permanentAddress
                        : new AddressDTO(insuredPerson.getCorrespodenceAddress());
        this.contracts =
                transformContracts ?
                insuredPerson
                        .getContracts()
                        .stream()
                        .map(this::constructDTOmake)
                        .collect(Collectors.toList())
                : null;
    }

    private ContractDTO constructDTOmake(Contract contract) {
        return contract instanceof LifeContract ? new LifeContractDTO((LifeContract) contract) : new PropertyContractDTO((PropertyContract) contract);
    }
}
