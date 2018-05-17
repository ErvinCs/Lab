package ro.blooddonation.core.Validators;

import ro.blooddonation.core.Domain.Person;
import ro.blooddonation.core.Exceptions.ValidatorException;

public class UserValidator implements Validator<Person> {

    @Override
    public void validate(Person entity) throws ValidatorException {
        String errors="";
        if(entity.getCNP()==null)
            errors+="Invalid CNP!\n";
        if(entity.getFirstName()=="")
            errors+="Invalid First Name!\n";
        if(entity.getLastName()=="")
            errors+="Invalid Last Name!\n";
        if (!errors.equals(""))
            throw new ValidatorException(errors);

    }
}
