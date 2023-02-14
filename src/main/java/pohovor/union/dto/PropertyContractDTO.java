package pohovor.union.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pohovor.union.model.contracts.PropertyContract;
import pohovor.union.model.contracts.PropertyType;

@NoArgsConstructor
public class PropertyContractDTO extends ContractDTO{

    @Getter
    @Setter
    private PropertyType propertyType;

    @Getter
    @Setter
    private AddressDTO address;

    @Getter
    @Setter
    private Integer value;

    public PropertyContractDTO(PropertyContract propertyContract) {
        this.setId(propertyContract.getId());
        this.setCreationDate(propertyContract.getCreationDate());
        this.propertyType = propertyContract.getPropertyType();
        this.address = new AddressDTO(propertyContract.getAddress());
        this.value = propertyContract.getValue();
    }
}
