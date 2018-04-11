package ro.blooddonation.Controller;

import ro.blooddonation.Domain.Donation;
import ro.blooddonation.Domain.DoningCenter;
import ro.blooddonation.Domain.Users.Donor;
import ro.blooddonation.Repo.UserRepo;

import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class DonorController implements IController<Donor> {

    /**
     * Default constructor
     */
    public DonorController() {
    }

    /**
     * 
     */
    private UserRepo<Donor> repo;

    /**
     * @param donor 
     * @return
     */
    public boolean add(Donor donor) {
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
     * @param newDonor 
     * @return
     */
    public boolean update(Long id, Donor newDonor) {
        // TODO implement here
        return false;
    }

    /**
     * @param id 
     * @return
     */
    public Optional<Donor> getOne(Long id) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public List<Donor> getAll() {
        // TODO implement here
        return null;
    }

    /**
     * @retur: number of idles removed
     */
    public Integer removeIdles() {
        // TODO implement here
        return null;
    }

    /**
     * @param dc
     */
    public void sortByDistance(DoningCenter dc) {
        // TODO implement here
    }

    /**
     * @param id 
     * @param appointment
     */
    public void appointDonor(Long id, LocalDate appointment) {
        // TODO implement here
    }

    /**
     * @param id 
     * @param donation
     */
    public void updateDonorHistory(Long id, Donation donation) {
        // TODO implement here
    }


}