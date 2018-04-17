package ro.blooddonation.Domain.Validators;

import ro.blooddonation.Domain.Donation;
import ro.blooddonation.Exceptions.ValidatorException;

public class DonationValidator implements Validator<Donation> {
    @Override
    public void validate(Donation entity) throws ValidatorException {
        String errors="";
        if(entity.getId()==null)
            errors+="Invalid ID!\n";
        if (entity.getBloodQuantity()<=0)
            errors+="Invalid blood quantity!\n";
        throw new ValidatorException(errors);
    }
}