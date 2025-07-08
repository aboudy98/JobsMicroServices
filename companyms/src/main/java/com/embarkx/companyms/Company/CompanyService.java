package com.embarkx.companyms.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Company updateCompany(Long id, Company company) throws Exception;
    Company findCompanyById(Long id) throws Exception;
    Company createCompany(Company company);
    void deleteCompany(Long id);
    
}
