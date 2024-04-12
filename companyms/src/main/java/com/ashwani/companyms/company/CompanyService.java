package com.ashwani.companyms.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAll();

    Company getOne(Long id);

    void createCompany(Company company);

    boolean updateCompany(Long id, Company updatedCompany);

    boolean removeCompany(Long id);
}
