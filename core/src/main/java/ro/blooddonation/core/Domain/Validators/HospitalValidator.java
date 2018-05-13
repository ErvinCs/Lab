package ro.blooddonation.core.Domain.Validators;

import ro.blooddonation.core.Domain.Hospital;
import ro.blooddonation.core.Exceptions.ValidatorException;

public class HospitalValidator implements Validator<Hospital> {
    @Override
    public void validate(Hospital entity) throws ValidatorException {
        String errors="";
//        if(entity.getId()==null)
//            errors+="Invalid ID!\n";
        if (!errors.equals(""))
            throw new ValidatorException(errors);
    }
}
