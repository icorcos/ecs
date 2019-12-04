package com.interfaceb2b.ecs.db;

import java.util.Optional;

public interface DAO<T> {

    Optional<T> find(String id);
    
    /*
    List<T> getAll();
     
    void save(T t);
     
    void update(T t, String[] params);
     
    void delete(T t);*/
	
}
