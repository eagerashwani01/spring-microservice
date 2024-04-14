package com.ashwani.jobms.job;

import java.util.List;

public interface JobService {
    List<Job> allJobs();

    Job oneJob(Long id);

    void createJob(Job job);

    boolean removeJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
