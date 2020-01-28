package com.thbs.ijp.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.thbs.ijp.model.Jobb;
@Repository
public interface JobbRepository extends JpaRepository<Jobb, Long> {

	//List<Jobb> findByLevel(String level);
	List<Jobb> findByBu(String bu);

//	Optional<Jobb> findById(Optional<Long> id);

}
