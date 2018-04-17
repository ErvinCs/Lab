package ro.blooddonation.Domain.Validators;

import ro.blooddonation.Domain.Hospital;
import ro.blooddonation.Exceptions.ValidatorException;

public class HospitalValidator implements Validator<Hospital> {
    @Override
    public void validate(Hospital entity) throws ValidatorException {
        String errors="";
        if(entity.getId()==null)
            errors+="Invalid ID!\n";
        throw new ValidatorException(errors);
    }
}
