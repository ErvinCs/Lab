package ro.blooddonation.core.Validators;

import ro.blooddonation.core.Exceptions.ValidatorException;

public interface Validator<T> {
    void validate(T entity) throws ValidatorException;
}