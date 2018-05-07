package ro.blooddonation.Repo;

import org.hibernate.*;
import ro.blooddonation.Domain.Donation;
import ro.blooddonation.Domain.Request;
import ro.blooddonation.Domain.Validators.RequestValidator;
import ro.blooddonation.Domain.Validators.Validator;
import ro.blooddonation.Exceptions.ValidatorException;
import ro.blooddonation.Util.HibernateUtil;

import java.util.*;

/**
 * 
 */
public class RequestRepo implements IRepo<Request> {

    private List<Request> repo;
    private Validator<Request> validator;
    private SessionFactory factory;

    /**
     * Constructor
     */
    public RequestRepo()
    {
        validator = new RequestValidator();
        repo = new ArrayList<>();
        try{
            factory = HibernateUtil.getSessionAnnotationFactory();
        }catch (Throwable ex)
        {
            throw new ExceptionInInitializerError("SessionFactory: " + ex);
        }
    }

    /**
     * @param request
     */
    public Long add(Request request) {
        if(request == null)
            throw new IllegalArgumentException("Null item!");

        try{
            validator.validate(request);
        }
        catch (ValidatorException e)
        {
            throw new ValidatorException(e);
        }

        Session session = factory.openSession();
        Transaction tx = null;
        Long id = null;
        Request r = null;

        try{
            tx = session.beginTransaction();

            r = new Request();
            r.setBlood(request.getBlood());
            r.setDoctor(request.getDoctor());
            r.setStatus(request.getStatus());
            r.setUrgency(request.getUrgency());

            id = (Long)session.save(r);
            r.setId(id);

            session.flush();
            tx.commit();
        }catch (HibernateException ex)
        {
            if(tx != null) tx.rollback();
            ex.printStackTrace();
        }finally {
            session.close();
        }

        return id;

    }

    /**
     * @param id
     */
    public void remove(Long id) {
        if(id == null)
            throw new IllegalArgumentException("ID must not be null!");
        if(find(id) == null)
            throw new IllegalArgumentException("ID does not exist!");

        Request r = find(id);

        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();

            r = (Request)session.get(Request.class, id);
            session.delete(r);

            tx.commit();
        }catch (HibernateException ex)
        {
            if(tx != null) tx.rollback();
            ex.printStackTrace();
        }finally {
            session.flush();
            session.close();
        }
    }

    /**
     * @param id
     */
    public void update(Long id, Request newItem) {
        if(newItem == null)
            throw new IllegalArgumentException("Null item!");

        Request r = find(id);
        if(r == null)
            throw new ValidatorException("Request with this ID does not exist");

        try{
            validator.validate(newItem);
        }
        catch (ValidatorException e)
        {
            throw new ValidatorException(e);
        }

        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();

            r = (Request)session.get(Request.class, id);
            r.setBlood(newItem.getBlood());
            r.setUrgency(newItem.getUrgency());
            r.setDoctor(newItem.getDoctor());
            r.setStatus(newItem.getStatus());
            session.update(r);

            session.flush();
            tx.commit();
        }catch (HibernateException ex)
        {
            if(tx != null) tx.rollback();
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }

    /**
     * @return
     */
    public List<Request> getAll() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Request> requestList = new ArrayList<Request>();

        try{
            tx = session.beginTransaction();

            Query q = session.createQuery("from Request");
            requestList = (List<Request>)q.list();

            session.flush();
            tx.commit();
        }catch (HibernateException ex)
        {
            if(tx != null) tx.rollback();
        }finally {
            session.close();
        }

        return requestList;
    }

    /**
     * @param id 
     * @return
     */
    public Request find(Long id) {
        if(id == null)
            throw new IllegalArgumentException("Id must not be null!");

        for(Request r: this.getAll())
            if(r.getId().equals(id))
                return r;
        return null;
    }

}