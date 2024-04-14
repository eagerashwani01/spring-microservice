package com.ashwani.jobms.job.dto;

import com.ashwani.jobms.job.external.Company;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobWithCompanyDto {
    
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    private Company company;
}
