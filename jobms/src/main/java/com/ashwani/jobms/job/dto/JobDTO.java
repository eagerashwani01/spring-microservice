package com.ashwani.jobms.job.dto;

import java.util.List;

import com.ashwani.jobms.job.external.Company;
import com.ashwani.jobms.job.external.Review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobDTO {
    
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    private Company company;
    private List<Review> reviews;
}
