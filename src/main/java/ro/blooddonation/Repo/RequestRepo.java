package ro.blooddonation.Repo;

import ro.blooddonation.Domain.Donation;
import ro.blooddonation.Domain.Request;
import ro.blooddonation.Domain.Validators.RequestValidator;
import ro.blooddonation.Domain.Validators.Validator;
import ro.blooddonation.Exceptions.ValidatorException;

import java.util.*;

/**
 * 
 */
public class RequestRepo implements IRepo<Request> {

    private List<Request> repo;
    private Validator<Request> validator;

    /**
     * Constructor
     */
    public RequestRepo()
    {
        validator = new RequestValidator();
        repo = new ArrayList<>();
    }

    /**
     * @param request
     */
    public void add(Request request) {
        if(request == null)
            throw new IllegalArgumentException("Null item!");

        try{
            validator.validate(request);
        }
        catch (ValidatorException e)
        {
            throw new ValidatorException(e);
        }
        repo.add(request);

    }

    /**
     * @param id
     */
    public void remove(Long id) {
        if(id == null)
            throw new IllegalArgumentException("ID must not be null!");
        if(find(id) == null)
            throw new IllegalArgumentException("ID does not exist!");

        for(Request r: repo)
            if(r.getId() == id)
                repo.remove(r);
    }

    /**
     * @param id
     */
    public void update(Long id, Request newItem) {
        if(newItem == null)
            throw new IllegalArgumentException("Null item!");

        Request r = find(id);

        try{
            validator.validate(newItem);
        }
        catch (ValidatorException e)
        {
            throw new ValidatorException(e);
        }

        repo.toArray()[repo.indexOf(r)] = newItem;
    }

    /**
     * @return
     */
    public List<Request> getAll() {
        return repo;
    }

    /**
     * @param id 
     * @return
     */
    public Request find(Long id) {
        if(id == null)
            throw new IllegalArgumentException("Id must not be null!");

        for(Request r: repo)
            if(r.getId() == id)
                return r;
        return null;
    }

}