package ro.blooddonation.Repo;

import ro.blooddonation.Domain.Users.User;

import java.util.*;

/**
 * 
 */
public class UserRepo<T extends User> implements IRepo<T> {

    /**
     * Default constructor
     */
    public UserRepo() {
    }

    /**
     * 
     */
    private List<T> repo;

    /**
     * @param elem
     */
    public void add(T elem) {
        // TODO implement here
    }

    /**
     * @param id
     */
    public void remove(Long id) {
        // TODO implement here
    }

    /**
     * @param id
     */
    public void update(Long id, T newItem) {
        // TODO implement here
    }

    /**
     * @return
     */
    public List<T> getAll() {
        // TODO implement here
        return null;
    }

    /**
     * @param id 
     * @return
     */
    public Optional<T> find(Long id) {
        // TODO implement here
        return null;
    }

}