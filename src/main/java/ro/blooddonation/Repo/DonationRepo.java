package ro.blooddonation.Repo;

import org.hibernate.*;
import ro.blooddonation.Domain.Donation;
import ro.blooddonation.Domain.Validators.DonationValidator;
import ro.blooddonation.Domain.Validators.Validator;
import ro.blooddonation.Exceptions.ValidatorException;
import ro.blooddonation.Util.HibernateUtil;

import java.util.*;

/**
 * 
 */
public class DonationRepo implements IRepo<Donation> {

    private List<Donation> repo;
    private Validator<Donation> validator;
    private SessionFactory factory;


    public DonationRepo() {
        validator = new DonationValidator();
        repo = new ArrayList<>();
        try{
            factory = HibernateUtil.getSessionAnnotationFactory();
        }catch (Throwable ex)
        {
            throw new ExceptionInInitializerError("SessionFactory: " + ex);
        }
    }


    /**
     * @param elem
     */
    public Long add(Donation elem) throws ValidatorException {
        if(elem == null)
            throw new IllegalArgumentException("Null item!");

        try{
            validator.validate(elem);
        }
        catch (ValidatorException e)
        {
            throw new ValidatorException(e);
        }

        Session session = factory.openSession();
        Transaction tx = null;
        Long id = null;
        Donation d = null;
        try{
            tx = session.beginTransaction();

            d = new Donation();
            d.setBlood(elem.getBlood());
            d.setPlasmaQuantity(elem.getPlasmaQuantity());
            d.setRedCellsQuantity(elem.getRedCellsQuantity());
            d.setThrombocytesQuantity(elem.getThrombocytesQuantity());
            d.setBloodQuantity(elem.getBloodQuantity());

            id = (Long)session.save(d);
            d.setId(id);

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
            throw new IllegalArgumentException("Donation with this ID does not exist!");

        Donation d = find(id);

        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();

            d = (Donation)session.get(Donation.class, id);
            session.delete(d);

            tx.commit();
        }catch (HibernateException ex)
        {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        }finally {
            session.flush();
            session.close();
        }

    }

    /**
     * @param id
     */
    public void update(Long id, Donation newItem) {
        if(newItem == null)
            throw new IllegalArgumentException("Null item!");

        Donation d = find(id);
        if(d == null)
            throw new ValidatorException("Donation with this ID does not exist!");

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

            d = (Donation)session.get(Donation.class, id);
            d.setBloodQuantity(newItem.getBloodQuantity());
            d.setBlood(newItem.getBlood());
            d.setThrombocytesQuantity(newItem.getThrombocytesQuantity());
            d.setRedCellsQuantity(newItem.getRedCellsQuantity());
            d.setPlasmaQuantity(newItem.getPlasmaQuantity());
            session.update(d);

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
    public List<Donation> getAll() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Donation> donationList = new ArrayList<Donation>();

        try{
            tx = session.beginTransaction();

            Query q = session.createQuery("from Donation");
            donationList = (List<Donation>) q.list();

            session.flush();
            tx.commit();
        }catch (HibernateException ex)
        {
            if(tx != null) tx.rollback();
            ex.printStackTrace();
        }finally {
            session.close();
        }

        return donationList;
    }

    /**
     * @param id 
     * @return
     */
    public Donation find(Long id) {
        if(id == null)
            throw new IllegalArgumentException("Id must not be null!");

        for(Donation d: this.getAll())
            if(d.getId().equals(id))
                return d;

        return null;
    }


}