package com.ashwani.jobms.job;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long>{
    List<Job> findAllByCompanyId(Long id);
}
