package ro.blooddonation.Controller;

import ro.blooddonation.Domain.Request;
import ro.blooddonation.Repo.RequestRepo;

public interface IRequestController extends IController<Request>
{
    /**
     *
     * @return
     */
    RequestRepo filterByUrgency();
}
