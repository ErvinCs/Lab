package ro.blooddonation.web.Controller.WillProbablyNotNeed;

import ro.blooddonation.core.Domain.Donation;
import ro.blooddonation.core.Domain.DoningCenter;
import ro.blooddonation.core.Domain.Users.Donor;

import java.time.LocalDate;

public interface IDonorController extends IController<Donor>
{
    /**
     *
     * @return
     */
    Integer removeIdles();

    /**
     *
     * @param dc
     */
    void sortByDistance(DoningCenter dc);

    /**
     *
     * @param id
     * @param appointment
     */
    void appointDonor(Long id, LocalDate appointment);

    /**
     *
     * @param id
     * @param donation
     */
    void updateDonorHistory(Long id, Donation donation);
}
