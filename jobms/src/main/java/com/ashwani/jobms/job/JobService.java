package com.ashwani.jobms.job;

import java.util.List;

import org.springframework.stereotype.Service;

public interface JobService {
    List<Job> allJobs();

    Job oneJob(Long id);

    void createJob(Job job);

    boolean removeJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
