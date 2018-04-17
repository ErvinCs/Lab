package ro.blooddonation.Domain.Validators;

import ro.blooddonation.Exceptions.ValidatorException;

public interface Validator<T> {
    void validate(T entity) throws ValidatorException;
}