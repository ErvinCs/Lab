package ro.blooddonation.Repo;

import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ro.blooddonation.Domain.Hospital;
import ro.blooddonation.Domain.Validators.HospitalValidator;
import ro.blooddonation.Domain.Validators.Validator;
import ro.blooddonation.Exceptions.ValidatorException;
import ro.blooddonation.Util.HibernateUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;

/**
 * 
 */
public class HospitalRepo implements IRepo<Hospital> {

    private List<Hospital> repo;
    private Validator<Hospital> validator;
    private SessionFactory factory;
    /**
     * Constructor
     */
    public HospitalRepo() {
        repo = new ArrayList<>();
        validator = new HospitalValidator();
        try {
            factory = HibernateUtil.getSessionAnnotationFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError("SessionFactory: " + ex);
        }
    }

    /**
     * @param elem
     */
    public Long add(Hospital elem) {
        try {
            validator.validate(elem);
        }
        catch(ValidatorException e){
            throw new ValidatorException(e);
        }

        Session session = factory.openSession();
        Transaction tx = null;
        Long id = null;
        Hospital h = null;

        try{
            tx = session.beginTransaction();

            h = new Hospital();
            h.setAddress(elem.getAddress());

            id = (Long)session.save(h);
            h.setId(id);

            session.flush();
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    /**
     * @param id
     */
    public void remove(Long id) {
        Hospital h = find(id);
        if (h == null)
            throw new ValidatorException("Hospital with this ID does not exist!");

        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();

            h = (Hospital)session.get(Hospital.class, id);
            session.delete(h);

            tx.commit();
        } catch (HibernateException ex) {
            if (tx!=null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    /**
     * @param id
     */
    public void update(Long id, Hospital newItem) {
        Hospital h = find(id);
        if (h == null)
            throw new ValidatorException("Hospital with this ID does not exist!");
        try{
            validator.validate(newItem);
        }
        catch (ValidatorException e){
            throw new ValidatorException(e);
        }

        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();

            h = (Hospital)session.get(Hospital.class, id);
            h.setAddress(newItem.getAddress());
            session.update(h);

            session.flush();
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * @return
     */
    public List<Hospital> getAll()
    {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Hospital> hospitalList = new ArrayList<Hospital>();

        try{
            tx = session.beginTransaction();

            Query q = session.createQuery("from Hospital");
            hospitalList = (List<Hospital>) q.list();

            session.flush();
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return hospitalList;
    }

    /**
     * @param id 
     * @return
     */
    public Hospital find(Long id) {
        for (Hospital h: this.getAll())
        {
            if(h.getId().equals(id))
                return h;
        }
        return null;
    }

}