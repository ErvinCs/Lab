package ro.blooddonation.web.Controller;

import ro.blooddonation.core.Domain.DCPMember;
import ro.blooddonation.core.Repo.Handmade.UserRepo;

import java.util.*;

/**
 * 
 */
public class DCPMemberController //implements IController<DCPMember>
{

    /**
     * Default constructor
     */
    public DCPMemberController() {
    }

    /**
     * 
     */
    private UserRepo<DCPMember> repo;

    /**
     * @param dcpMember 
     * @return
     */
    public boolean add(DCPMember dcpMember) {
        // TODO implement here
        return false;
    }

    /**
     * @param id 
     * @return
     */
    public boolean update(Long id, DCPMember newDCP) {
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
    public Optional<DCPMember> getOne(Long id) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public List<DCPMember> getAll() {
        // TODO implement here
        return null;
    }


}