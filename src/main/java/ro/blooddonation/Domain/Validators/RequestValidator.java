package ro.blooddonation.Domain.Validators;

import ro.blooddonation.Domain.Request;
import ro.blooddonation.Exceptions.ValidatorException;

public class RequestValidator implements Validator<Request>
{
    @Override
    public void validate(Request entity) throws ValidatorException {
        String errors = "";
        if(entity.getId() == null)
            errors+="Invalid ID!\n";
        if(errors.length() > 0)
            throw new ValidatorException(errors);
    }
}
