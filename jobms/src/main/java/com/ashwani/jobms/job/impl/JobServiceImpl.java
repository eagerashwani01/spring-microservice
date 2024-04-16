package com.ashwani.jobms.job.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ashwani.jobms.job.Job;
import com.ashwani.jobms.job.JobRepository;
import com.ashwani.jobms.job.JobService;
import com.ashwani.jobms.job.dto.JobWithCompanyDto;
import com.ashwani.jobms.job.external.Company;
import com.ashwani.jobms.job.mapper.JobMapper;

@Service
public class JobServiceImpl implements JobService{

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<JobWithCompanyDto> allJobs() {
        List<Job> jobs = jobRepository.findAll();

        return jobs.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private JobWithCompanyDto convertToDto(Job job) {
        
          
            Company company = restTemplate.getForObject("http://COMPANYMS:8082/company/" + job.getCompanyId(), Company.class);
            JobWithCompanyDto jobWithCompanyDto = JobMapper.settingJobAndCompany(job, company);

            return jobWithCompanyDto;
        
    }

    @Override
    public Job oneJob(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public boolean removeJobById(Long id) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if(optionalJob.isPresent()){
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setLocation(updatedJob.getLocation());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setMinSalary(updatedJob.getMinSalary());
            jobRepository.save(job);
            return true;
        }
        return false;
    }

    @Override
    public List<Job> getAllJobsForCompany(Long id) {
        return jobRepository.findAllByCompanyId(id);
    }
}
