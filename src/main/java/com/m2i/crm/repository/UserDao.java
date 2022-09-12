package com.m2i.crm.repository;

/**
 *
 * @author elouf
 */
import com.m2i.crm.model.DAOUser;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
  DAOUser findByUsername(String username);
}