package com.ashwani.jobms.job.mapper;

import com.ashwani.jobms.job.Job;
import com.ashwani.jobms.job.dto.JobWithCompanyDto;
import com.ashwani.jobms.job.external.Company;

public class JobMapper {
    public static JobWithCompanyDto settingJobAndCompany(Job job, Company company){
        JobWithCompanyDto jobWithCompanyDto = new JobWithCompanyDto();
        jobWithCompanyDto.setId(job.getId());
        jobWithCompanyDto.setTitle(job.getTitle());
        jobWithCompanyDto.setDescription(job.getDescription());
        jobWithCompanyDto.setMaxSalary(job.getMaxSalary());
        jobWithCompanyDto.setMinSalary(job.getMinSalary());
        jobWithCompanyDto.setLocation(job.getLocation());
        jobWithCompanyDto.setCompany(company);

        return jobWithCompanyDto;
    }
}
