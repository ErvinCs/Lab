package ro.blooddonation.Controller;

import ro.blooddonation.Domain.Users.Patient;
import ro.blooddonation.Repo.UserRepo;

public interface IPatientController extends IController<Patient>
{
    /**
     *
     * @return
     */
    UserRepo<Patient> filterByUrgency();

    /**
     *
     * @param id
     * @return
     */
    Double enoughDonations(Long id);
}
