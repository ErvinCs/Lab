package ro.blooddonation.Repo;

import ro.blooddonation.Domain.Hospital;
import ro.blooddonation.Domain.Validators.HospitalValidator;
import ro.blooddonation.Domain.Validators.Validator;
import ro.blooddonation.Exceptions.ValidatorException;

import javax.xml.bind.ValidationException;
import java.util.*;

/**
 * 
 */
public class HospitalRepo implements IRepo<Hospital> {

    private List<Hospital> repo;
    private Validator<Hospital> validator;
    /**
     * Constructor
     */
    public HospitalRepo() {
        repo = new ArrayList<>();
        validator = new HospitalValidator();
    }


    /**
     * @param elem
     */
    public void add(Hospital elem) {
        try {
            validator.validate(elem);
        }
        catch(ValidatorException e){
            throw new ValidatorException(e);
        }
        repo.add(elem);
    }

    /**
     * @param id
     */
    public void remove(Long id) {
        Hospital h=find(id);
        if (h==null)
            throw new ValidatorException("Hospital with this ID does not exist!");
        else
            repo.remove(h);

    }

    /**
     * @param id
     */
    public void update(Long id, Hospital newItem) {
        Hospital h=find(id);
        if (h==null)
            throw new ValidatorException("Hospital with this ID does not exist!");
        else
            try{
            validator.validate(newItem);
            }
            catch (ValidatorException e){
                throw new ValidatorException(e);
            }
            repo.toArray()[repo.indexOf(h)]=newItem;

    }

    /**
     * @return
     */
    public List<Hospital> getAll() {
        return repo;
    }

    /**
     * @param id 
     * @return
     */
    public Hospital find(Long id) {
        for (Hospital i: repo)
            if(i.getId()==id)
                return i;
        return null;
    }

}