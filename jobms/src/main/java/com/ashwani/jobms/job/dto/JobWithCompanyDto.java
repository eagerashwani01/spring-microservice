package com.ashwani.jobms.job.dto;

import com.ashwani.jobms.job.Job;
import com.ashwani.jobms.job.external.Company;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobWithCompanyDto {
    
    private Job job;
    private Company company;
}
