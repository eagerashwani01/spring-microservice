package com.ashwani.jobms.job.mapper;

import java.util.List;

import com.ashwani.jobms.job.Job;
import com.ashwani.jobms.job.dto.JobDTO;
import com.ashwani.jobms.job.external.Company;
import com.ashwani.jobms.job.external.Review;

public class JobMapper {
    public static JobDTO settingJobAndCompany(Job job, Company company,
     List<Review> reviews
     ){
        JobDTO jobWithCompanyDto = new JobDTO();
        jobWithCompanyDto.setId(job.getId());
        jobWithCompanyDto.setTitle(job.getTitle());
        jobWithCompanyDto.setDescription(job.getDescription());
        jobWithCompanyDto.setMaxSalary(job.getMaxSalary());
        jobWithCompanyDto.setMinSalary(job.getMinSalary());
        jobWithCompanyDto.setLocation(job.getLocation());
        jobWithCompanyDto.setCompany(company);
        jobWithCompanyDto.setReviews(reviews);

        return jobWithCompanyDto;
    }
}
