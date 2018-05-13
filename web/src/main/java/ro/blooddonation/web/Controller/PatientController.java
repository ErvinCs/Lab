package ro.blooddonation.web.Controller;

import ro.blooddonation.core.Domain.Users.Patient;
import ro.blooddonation.core.Repo.Handmade.UserRepo;
import ro.blooddonation.web.Controller.WillProbablyNotNeed.IController;

import java.util.*;

/**
 * 
 */
public class PatientController implements IController<Patient> {

    /**
     * Default constructor
     */
    public PatientController() {
    }

    /**
     * 
     */
    private UserRepo<Patient> repo;

    /**
     * @param patient 
     * @return
     */
    public boolean add(Patient patient) {
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
    public boolean update(Long id, Patient newPatient) {
        // TODO implement here
        return false;
    }

    /**
     * @param id 
     * @return
     */
    public Optional<Patient> getOne(Long id) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public List<Patient> getAll() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public UserRepo<Patient> filterByUrgency() {
        // TODO implement here
        return null;
    }

    /**
     * @param id 
     * @return
     */
    public Double enoughDonations(Long id) {
        // TODO implement here
        return null;
    }


}