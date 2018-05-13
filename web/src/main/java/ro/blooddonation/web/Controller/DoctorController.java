package ro.blooddonation.web.Controller;

import ro.blooddonation.core.Domain.Users.Doctor;
import ro.blooddonation.core.Repo.Handmade.UserRepo;

import java.util.*;

/**
 * 
 */
public class DoctorController //implements IController<Doctor>
{

    /**
     * Default constructor
     */
    public DoctorController() {
    }

    /**
     * 
     */
    private UserRepo<Doctor> repo;

    /**
     * @param doctor 
     * @return
     */
    public boolean add(Doctor doctor) {
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
    public boolean update(Long id, Doctor newDoctor) {
        // TODO implement here
        return false;
    }

    /**
     * @param id 
     * @return
     */
    public Optional<Doctor> getOne(Long id) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public List<Doctor> getAll() {
        // TODO implement here
        return null;
    }

}