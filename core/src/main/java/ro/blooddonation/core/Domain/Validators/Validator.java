package ro.blooddonation.core.Domain.Validators;

import ro.blooddonation.core.Exceptions.ValidatorException;

public interface Validator<T> {
    void validate(T entity) throws ValidatorException;
}