package ro.blooddonation.Repo;

import ro.blooddonation.Domain.Hospital;

import java.util.*;

/**
 * 
 */
public class HospitalRepo implements IRepo<Hospital> {

    /**
     * Default constructor
     */
    public HospitalRepo() {
    }

    /**
     *
     */
    private List<Hospital> repo;

    /**
     * @param elem
     */
    public void add(Hospital elem) {
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
    public void update(Long id, Hospital newItem) {
        // TODO implement here
    }

    /**
     * @return
     */
    public List<Hospital> getAll() {
        // TODO implement here
        return null;
    }

    /**
     * @param id 
     * @return
     */
    public Optional<Hospital> find(Long id) {
        // TODO implement here
        return null;
    }

}