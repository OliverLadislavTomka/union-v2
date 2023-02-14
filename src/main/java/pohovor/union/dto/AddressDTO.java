package pohovor.union.dto;

import lombok.Getter;
import lombok.Setter;
import pohovor.union.model.Address;

public class AddressDTO {

    @Getter
    @Setter
    private Integer postcode;
    @Getter
    @Setter
    private String city;

    @Getter
    @Setter
    private String street;

    @Getter
    @Setter
    private Long streetNumber;

    public AddressDTO(Address address) {
        this.city = address.getCity();
        this.street = address.getStreet();
        this.streetNumber = address.getStreetNumber();
        this.postcode = address.getPostcode();
    }
}
