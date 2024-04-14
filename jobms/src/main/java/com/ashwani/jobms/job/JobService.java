package com.ashwani.jobms.job;

import java.util.List;

import com.ashwani.jobms.job.dto.JobWithCompanyDto;

public interface JobService {
    List<JobWithCompanyDto> allJobs();

    Job oneJob(Long id);

    void createJob(Job job);

    boolean removeJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
