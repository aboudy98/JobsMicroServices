package com.embarkx.companyms.Company.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.embarkx.companyms.Company.Company;
import com.embarkx.companyms.Company.CompanyRepository;
import com.embarkx.companyms.Company.CompanyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{
    private final CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company updateCompany(Long id, Company company) throws Exception {
       Company existingCompany = findCompanyById(id);
       if(existingCompany != null) {
            existingCompany.setName(company.getName());
            existingCompany.setDescription(company.getDescription());
        
            
            return companyRepository.save(existingCompany);
        }
        throw new Exception("Company not found with id: " + id);


    }

    @Override
    public Company findCompanyById(Long id) throws Exception {
       return companyRepository.findById(id)
                .orElseThrow(() -> new Exception("Company not found with id: " + id));
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Long id) {
       companyRepository.deleteById(id);
    }


}
