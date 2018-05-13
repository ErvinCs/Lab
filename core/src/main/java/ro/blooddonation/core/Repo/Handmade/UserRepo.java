package ro.blooddonation.core.Repo.Handmade;

import org.hibernate.*;
import ro.blooddonation.core.Domain.Users.Person;
import ro.blooddonation.core.Domain.Validators.UserValidator;
import ro.blooddonation.core.Domain.Validators.Validator;
import ro.blooddonation.core.Exceptions.ValidatorException;
import ro.blooddonation.core.Util.HibernateUtil;

import java.util.*;

/**
 * 
 */
public class UserRepo<T extends Person> implements IRepo<T> {

    private List<T> repo;
    private Validator<Person> validator;
    private SessionFactory factory;
    /**
     * Default constructor
     */
    public UserRepo() {
        repo = new ArrayList<>();
        validator = new UserValidator();
        try {
            factory = HibernateUtil.getSessionAnnotationFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError("SessionFactory: " + ex);
        }
    }

     /**
     * @param elem
     */
    public Long add(T elem) {
        try {
            validator.validate(elem);
        }
        catch(ValidatorException e){
            throw new ValidatorException(e);
        }

        Session session = factory.openSession();
        Transaction tx = null;
        T u = null;

        try{
            tx = session.beginTransaction();

            u.setAccount(elem.getAccount());
            u.setAddress(elem.getAddress());
            u.setFirstName(elem.getFirstName());
            u.setLastName(elem.getLastName());
            u.setResidence(elem.getResidence());
            u.setCNP(elem.getCNP());
            u.setbDay(elem.getbDay());
            session.save(u);

            session.flush();
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return elem.getCNP();
    }

    /**
     * @param id
     */
    public void remove(Long id) {
        T u = find(id);
        if (u == null)
            throw new ValidatorException("Person with this ID does not exist!");

        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();

            u = (T) session.get(Person.class, id);
            session.delete(u);

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
    public void update(Long id, T newItem) {
        T u= find(id);
        if (u == null)
            throw new ValidatorException("Person with this ID does not exist!");
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

            u = (T)session.get(Person.class, id);
            u.setAddress(newItem.getAddress());
            session.update(u);

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
    public List<T> getAll() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<T> userList = new ArrayList<T>();

        try{
            tx = session.beginTransaction();

            Query q = session.createQuery("from Users");
            userList = (List<T>) q.list();

            session.flush();
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return userList;
    }

    /**
     * @param id 
     * @return
     */
    public T find(Long id) {
        for (T i: repo)
            if(i.getCNP()==id)
                return i;
        return null;
    }

}