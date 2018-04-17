package ro.blooddonation.Repo;

import ro.blooddonation.Domain.Request;

import java.util.*;

/**
 * 
 */
public class RequestRepo implements IRepo<Request> {

    /**
     * Default constructor
     */
    public RequestRepo() {
    }

    /**
     * 
     */
    private List<Request> repo;

    /**
     * @param request
     */
    public void add(Request request) {
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
    public void update(Long id, Request newItem) {
        // TODO implement here
    }

    /**
     * @return
     */
    public List<Request> getAll() {
        // TODO implement here
        return null;
    }

    /**
     * @param id 
     * @return
     */
    public Request find(Long id) {
        // TODO implement here
        return null;
    }

}