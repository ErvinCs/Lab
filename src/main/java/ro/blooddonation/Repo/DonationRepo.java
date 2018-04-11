package ro.blooddonation.Repo;

import ro.blooddonation.Domain.Donation;

import java.util.*;

/**
 * 
 */
public class DonationRepo implements IRepo<Donation> {

    /**
     * Default constructor
     */
    public DonationRepo() {
    }

    /**
     * 
     */
    private List<Donation> repo;

    /**
     * @param elem
     */
    public void add(Donation elem) {
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
    public void update(Long id, Donation newItem) {
        // TODO implement here
    }

    /**
     * @return
     */
    public List<Donation> getAll() {
        // TODO implement here
        return null;
    }

    /**
     * @param id 
     * @return
     */
    public Optional<Donation> find(Long id) {
        // TODO implement here
        return null;
    }

}