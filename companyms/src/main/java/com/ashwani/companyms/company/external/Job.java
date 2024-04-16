package com.ashwani.companyms.company.external;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Job {
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    private Long companyId;
}
