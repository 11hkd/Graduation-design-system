package org.example.jdbcexamples.repository;

import org.springframework.data.repository.CrudRepository;
import org.example.jdbcexamples.dox.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, String>{

}