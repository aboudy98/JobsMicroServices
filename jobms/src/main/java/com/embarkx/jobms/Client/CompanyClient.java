package com.embarkx.jobms.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.embarkx.jobms.JobFolder.External.Company;

@FeignClient(name ="company-service")
public interface CompanyClient {


    @GetMapping("/companies/{id}")
    Company getCompanyById(@PathVariable("id") Long id);

    
} 
