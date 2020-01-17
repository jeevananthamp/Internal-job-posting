package com.thbs.ijp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.thbs.ijp.model.Jobb;
@Repository
public interface JobbRepository extends JpaRepository<Jobb, Long> {

}
