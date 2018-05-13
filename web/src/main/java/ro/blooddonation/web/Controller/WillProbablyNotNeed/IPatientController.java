package ro.blooddonation.web.Controller.WillProbablyNotNeed;

import ro.blooddonation.core.Domain.Users.Patient;
import ro.blooddonation.core.Repo.Handmade.UserRepo;

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
