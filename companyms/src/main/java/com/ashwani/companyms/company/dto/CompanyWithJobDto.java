package com.ashwani.companyms.company.dto;


import com.ashwani.companyms.company.external.Job;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyWithJobDto {
    private Long id;
    private String name;
    private String location;
    private Job[] jobs;
}
