package com.thbs.ijp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thbs.ijp.model.ApplyJob;
import com.thbs.ijp.model.User;

public interface ApplyJobRepository extends JpaRepository<ApplyJob,Long> {

	List<ApplyJob> findByJobid(Optional<Long> id);

	List<ApplyJob> findByEmpid(String empid);
}
