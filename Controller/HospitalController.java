package ro.blooddonation.Controller;

import ro.blooddonation.Domain.Hospital;
import ro.blooddonation.Repo.HospitalRepo;

import java.util.*;

/**
 * 
 */
public class HospitalController implements IController<Hospital> {

    /**
     * Default constructor
     */
    public HospitalController() {
    }

    /**
     * 
     */
    private HospitalRepo repo;

    /**
     * @param hospital 
     * @return
     */
    public boolean add(Hospital hospital) {
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
    public boolean update(Long id, Hospital newHospital) {
        // TODO implement here
        return false;
    }

    /**
     * @param id 
     * @return
     */
    public Optional<Hospital> getOne(Long id) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public List<Hospital> getAll() {
        // TODO implement here
        return null;
    }

}