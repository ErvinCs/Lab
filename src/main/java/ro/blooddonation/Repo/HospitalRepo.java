package ro.blooddonation.Repo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
//        repo.add(elem);
//        return elem.getId();

        Session session = factory.openSession();
        Transaction tx = null;
        Long id = null;

        try{
            tx = session.beginTransaction();

            Hospital hospital = new Hospital();
            hospital.setAddress(elem.getAddress());
            id = (Long)session.save(hospital);

            tx.commit();
        } catch (HibernateException ex) {
            if (tx!=null) tx.rollback();
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
//        repo.remove(h);

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
//        repo.toArray()[repo.indexOf(h)]=newItem;

        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();

            h = (Hospital)session.get(Hospital.class, id);
            h.setAddress(newItem.getAddress());
            session.update(h);

            tx.commit();
        } catch (HibernateException ex) {
            if (tx!=null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * @return
     */
    public List<Hospital> getAll() {
        return repo;
    }

    /**
     * @param id 
     * @return
     */
    public Hospital find(Long id) {
        for (Hospital i: repo)
            if(i.getId().equals(id))
                return i;
        return null;
    }

}