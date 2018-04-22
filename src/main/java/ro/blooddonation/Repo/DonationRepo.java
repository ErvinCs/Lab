package ro.blooddonation.Repo;

import ro.blooddonation.Domain.Donation;
import ro.blooddonation.Domain.Validators.DonationValidator;
import ro.blooddonation.Domain.Validators.Validator;
import ro.blooddonation.Exceptions.ValidatorException;

import java.util.*;

/**
 * 
 */
public class DonationRepo implements IRepo<Donation> {

    private List<Donation> repo;
    private Validator<Donation> validator;


    public DonationRepo() {
        validator = new DonationValidator();
        repo = new ArrayList<>();
    }


    /**
     * @param elem
     */
    public Long add(Donation elem) throws ValidatorException {
        if(elem == null)
            throw new IllegalArgumentException("Null item!");

        try{
            validator.validate(elem);
        }
        catch (ValidatorException e)
        {
            throw new ValidatorException(e);
        }
        repo.add(elem);
        return elem.getId();
    }

    /**
     * @param id
     */
    public void remove(Long id) {
        if(id == null)
            throw new IllegalArgumentException("ID must not be null!");
        if(find(id) == null)
            throw new IllegalArgumentException("ID does not exist!");

        for(Donation d: repo)
            if(d.getId() == id)
                repo.remove(d);
    }

    /**
     * @param id
     */
    public void update(Long id, Donation newItem) {
        if(newItem == null)
            throw new IllegalArgumentException("Null item!");

        Donation d = find(id);

        try{
            validator.validate(newItem);
        }
        catch (ValidatorException e)
        {
            throw new ValidatorException(e);
        }

        repo.toArray()[repo.indexOf(d)] = newItem;
    }

    /**
     * @return
     */
    public List<Donation> getAll() {
        return repo;
    }

    /**
     * @param id 
     * @return
     */
    public Donation find(Long id) {
        if(id == null)
            throw new IllegalArgumentException("Id must not be null!");

        for(Donation d: repo)
            if(d.getId() == id)
                return d;

        return null;
    }


}