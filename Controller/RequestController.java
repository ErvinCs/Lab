package ro.blooddonation.Controller;

import ro.blooddonation.Domain.Request;
import ro.blooddonation.Repo.RequestRepo;

import java.util.*;

/**
 * 
 */
public class RequestController implements IController<Request> {

    /**
     * Default constructor
     */
    public RequestController() {
    }

    /**
     * 
     */
    private RequestRepo repo;

    /**
     * @param request 
     * @return
     */
    public boolean add(Request request) {
        // TODO implement here
        return false;
    }

    /**
     * @param id 
     * @return
     */
    public boolean remove(Long id) {
        // TODO implement here
        return false;
    }

    /**
     * @param id 
     * @return
     */
    public boolean update(Long id, Request newRequest) {
        // TODO implement here
        return false;
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
    public Optional<Request> getOne(Long id) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public RequestRepo filterByUrgency() {
        // TODO implement here
        return null;
    }


}