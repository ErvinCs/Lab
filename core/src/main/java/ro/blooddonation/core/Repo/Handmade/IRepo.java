package ro.blooddonation.core.Repo.Handmade;

import java.util.*;

/**
 * 
 */
public interface IRepo<T> {

    /**
     * @param elem
     */
    public Long add(T elem);

    /**
     * @param id
     */
    public void remove(Long id);

    /**
     * @param id
     */
    public void update(Long id, T newItem);

    /**
     * @return
     */
    public List<T> getAll();

    /**
     * @param id
     * @return
     */
    public T find(Long id);

}