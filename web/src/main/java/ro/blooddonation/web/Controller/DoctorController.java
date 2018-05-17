package ro.blooddonation.web.Controller;

import ro.blooddonation.core.Domain.Doctor;

import java.util.*;

/**
 * 
 */
//@RestController
public class DoctorController //implements IController<>
{

    /**
     * Default constructor
     */
    public DoctorController() {
    }


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