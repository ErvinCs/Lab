package ro.blooddonation.Repo;

import ro.blooddonation.Domain.Users.User;
import ro.blooddonation.Domain.Validators.UserValidator;
import ro.blooddonation.Domain.Validators.Validator;
import ro.blooddonation.Exceptions.ValidatorException;

import java.util.*;

/**
 * 
 */
public class UserRepo<T extends User> implements IRepo<T> {

    private List<T> repo;
    private Validator<User> validator;
    /**
     * Default constructor
     */
    public UserRepo() {
        repo = new ArrayList<>();
        validator = new UserValidator();
    }

     /**
     * @param elem
     */
    public Long add(T elem) {
        try {
            validator.validate(elem);
        }
        catch(ValidatorException e){
            throw new ValidatorException(e);
        }
        repo.add(elem);
        return elem.getCNP();
    }

    /**
     * @param id
     */
    public void remove(Long id) {
        User u=find(id);
        if (u==null)
            throw new ValidatorException("User with this ID does not exist!");
        else
            repo.remove(u);
    }

    /**
     * @param id
     */
    public void update(Long id, T newItem) {
        User u=find(id);
        if (u==null)
            throw new ValidatorException("User with this ID does not exist!");
        else
            try{
                validator.validate(newItem);
            }
            catch (ValidatorException e){
                throw new ValidatorException(e);
            }
        repo.toArray()[repo.indexOf(u)]=newItem;
    }

    /**
     * @return
     */
    public List<T> getAll() {
        return repo;
    }

    /**
     * @param id 
     * @return
     */
    public T find(Long id) {
        for (T i: repo)
            if(i.getCNP()==id)
                return i;
        return null;
    }

}