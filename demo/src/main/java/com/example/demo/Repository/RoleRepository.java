package com.example.demo.Repository;

import com.example.demo.Entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

//    List<Object> findById(String user);
}
