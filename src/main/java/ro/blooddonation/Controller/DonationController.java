package ro.blooddonation.Controller;

import ro.blooddonation.Domain.Donation;
import ro.blooddonation.Repo.DonationRepo;

import java.util.*;

/**
 * 
 */
public class DonationController implements IController<Donation> {

    /**
     * Default constructor
     */
    public DonationController() {
    }

    /**
     * 
     */
    public DonationRepo repo;

    /**
     * @param donation 
     * @return
     */
    public boolean add(Donation donation) {
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
    public boolean update(Long id, Donation newDonation) {
        // TODO implement here
        return false;
    }

    /**
     * @param id 
     * @return
     */
    public Optional<Donation> getOne(Long id) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public List<Donation> getAll() {
        // TODO implement here
        return null;
    }

}