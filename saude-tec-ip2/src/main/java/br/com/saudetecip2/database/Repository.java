package br.com.saudetecip2.database;

import java.util.List;

public interface Repository<T>{

    public T findById(String id);

    public void deleteById(String id);
    
    public  void save(T objeto);
    
    public void update(T objeto);

    public List<T> findAll();
}