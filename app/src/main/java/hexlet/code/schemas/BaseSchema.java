package hexlet.code.schemas;

import java.util.Map;

public class BaseSchema {
    protected boolean isRequired;

    public BaseSchema() {
        this.isRequired = false;
    }

    public void required() {
        isRequired = true;
    }

    public boolean isValid(Object validatingObject) {
        if (validatingObject == null) {
            return isValidWhenNull(isRequired);
        } else if (validatingObject.getClass() == String.class) {
            return isValidStringSchema(validatingObject.toString());
        } else if (validatingObject.getClass() == Integer.class) {
            return isValidNumberSchema((int) validatingObject);
        } else if (validatingObject instanceof Map) {
            return isValidMapSchema((Map<?, ?>) validatingObject);
        }
        return false;
    }

    private boolean isValidWhenNull(boolean isRequiredNull) {
        return !isRequiredNull;
    }

    public boolean isValidStringSchema(String validatingString) {
        return false;
    }

    public boolean isValidNumberSchema(int validatingNumber) {
        return false;
    }

    public boolean isValidMapSchema(Map<?, ?> validatingMap) {
        return false;
    }
}
