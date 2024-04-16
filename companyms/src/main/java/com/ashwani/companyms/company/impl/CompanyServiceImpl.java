package com.ashwani.companyms.company.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ashwani.companyms.company.Company;
import com.ashwani.companyms.company.CompanyRepository;
import com.ashwani.companyms.company.CompanyService;
import com.ashwani.companyms.company.dto.CompanyWithJobDto;
import com.ashwani.companyms.company.external.Job;

@Service
public class CompanyServiceImpl implements CompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company getOne(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    public CompanyWithJobDto getCompanyAllJobs(Long id){
        Job[] jobs = restTemplate.getForObject("http://JOBMS:8081/jobs/" + id + "/company", Job[].class);
        Company company = getOne(id);
        
        CompanyWithJobDto companyWithJobDto = new CompanyWithJobDto();
        companyWithJobDto.setJobs(jobs);
        companyWithJobDto.setId(id);
        companyWithJobDto.setLocation(company.getLocation());
        companyWithJobDto.setName(company.getName());
       
        return companyWithJobDto;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean updateCompany(Long id, Company updatedCompany) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(optionalCompany.isPresent()){
            Company company = optionalCompany.get();
            company.setName(updatedCompany.getName());
            company.setLocation(updatedCompany.getLocation());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeCompany(Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
