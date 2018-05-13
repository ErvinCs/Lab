package ro.blooddonation.web.Controller.WillProbablyNotNeed;

import java.util.*;

/**
 * 
 */
public interface IController<T>
{
    /**
     * @param item 
     * @return
     */
    public boolean add(T item);

    /**
     * @param id 
     * @return
     */
    public boolean remove(Long id);

    /**
     * @param id 
     * @param newItem 
     * @return
     */
    public boolean update(Long id, T newItem);

    /**
     * @param id 
     * @return
     */
    public Optional<T> getOne(Long id);

    /**
     * @return
     */
    public List<T> getAll();

}