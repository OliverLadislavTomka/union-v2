package pohovor.union.model.contracts;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PropertyType {
    FLAT("Byt"),
    WOODEN_FAMILY_HOUSE("Rodinný dom - drevený"),
    BRICKED_FAMILY_HOUSE("Rodinný dom - murovaný");

    public final String label;

    @JsonValue
    public String getLabel() {
        return label;
    }

    private PropertyType(String label) {
        this.label = label;
    }
}
