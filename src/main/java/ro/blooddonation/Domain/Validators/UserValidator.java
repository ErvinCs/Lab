package ro.blooddonation.Domain.Validators;

import ro.blooddonation.Domain.Users.User;
import ro.blooddonation.Exceptions.ValidatorException;

public class UserValidator implements Validator<User> {

    @Override
    public void validate(User entity) throws ValidatorException {
        String errors="";
        if(entity.getCNP()==null)
            errors+="Invalid CNP!\n";
        if(entity.getFirstName()=="")
            errors+="Invalid First Name!\n";
        if(entity.getLastName()=="")
            errors+="Invalid Last Name!\n";
        throw new ValidatorException(errors);

    }
}
