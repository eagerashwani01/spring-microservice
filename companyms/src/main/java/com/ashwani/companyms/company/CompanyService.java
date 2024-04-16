package com.ashwani.companyms.company;

import java.util.List;

import com.ashwani.companyms.company.dto.CompanyWithJobDto;

public interface CompanyService {
    List<Company> getAll();

    Company getOne(Long id);

    CompanyWithJobDto getCompanyAllJobs(Long id);
    
    void createCompany(Company company);

    boolean updateCompany(Long id, Company updatedCompany);

    boolean removeCompany(Long id);
}
