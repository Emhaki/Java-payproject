package common;

import javax.xml.validation.Validator;

public class SelfValidating<T> {

    private Validator validator;

    public SelfValidating() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    protected void validateSelf() {
        Set<ConstraintViolation<T>> violations = validator.validate(T) this;
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
