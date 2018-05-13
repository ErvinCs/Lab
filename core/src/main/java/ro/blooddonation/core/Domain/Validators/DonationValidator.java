package ro.blooddonation.core.Domain.Validators;

import ro.blooddonation.core.Domain.Donation;
import ro.blooddonation.core.Exceptions.ValidatorException;


public class DonationValidator implements Validator<Donation> {
    @Override
    public void validate(Donation entity) throws ValidatorException {
        String errors = "";
        if (entity.getId() == null)
            errors += "Invalid ID!\n";
        if (entity.getBloodQuantity() <= 0)
            errors += "Invalid blood quantity!\n";
        if (!errors.equals(""))
            throw new ValidatorException(errors);
    }
}