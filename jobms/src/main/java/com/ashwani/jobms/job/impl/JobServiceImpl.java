package com.ashwani.jobms.job.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ashwani.jobms.job.Job;
import com.ashwani.jobms.job.JobRepository;
import com.ashwani.jobms.job.JobService;
import com.ashwani.jobms.job.dto.JobWithCompanyDto;
import com.ashwani.jobms.job.external.Company;

@Service
public class JobServiceImpl implements JobService{

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<JobWithCompanyDto> allJobs() {
        List<Job> jobs = jobRepository.findAll();
        List<JobWithCompanyDto> jobWithCompanyDtos = new ArrayList<>(); 
        RestTemplate restTemplate = new RestTemplate();

        for (Job job : jobs) {
            JobWithCompanyDto jobWithCompanyDto = new JobWithCompanyDto();
            jobWithCompanyDto.setJob(job);

            Company company = restTemplate.getForObject("http://localhost:8082/company/" + job.getCompanyId(), Company.class);
            jobWithCompanyDto.setCompany(company);

            jobWithCompanyDtos.add(jobWithCompanyDto);
        }
        return jobWithCompanyDtos;
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
}
