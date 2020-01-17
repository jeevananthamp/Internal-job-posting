package com.thbs.ijp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thbs.ijp.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   User findByEmpid(String empid);

   User findByEmail(String email);
}
