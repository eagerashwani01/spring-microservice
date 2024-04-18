package com.ashwani.jobms.job;

import java.util.List;

import com.ashwani.jobms.job.dto.JobDTO;

public interface JobService {
    List<JobDTO> allJobs();

    Job oneJob(Long id);

    List<Job> getAllJobsForCompany(Long id);

    void createJob(Job job);

    boolean removeJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
