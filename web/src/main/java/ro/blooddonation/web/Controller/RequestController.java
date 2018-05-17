package ro.blooddonation.web.Controller;

import ro.blooddonation.core.Domain.Request;

import java.util.*;

/**
 * 
 */
//@RestController
public class RequestController //implements IController<>
{

    /**
     * Default constructor
     */
    public RequestController() {
    }


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

//    /**
//     * @return
//     */
//    public RequestRepo filterByUrgency() {
//        // TODO implement here
//        return null;
//    }


}