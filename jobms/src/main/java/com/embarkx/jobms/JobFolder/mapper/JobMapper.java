package com.embarkx.jobms.JobFolder.mapper;

import com.embarkx.jobms.JobFolder.Job;
import com.embarkx.jobms.JobFolder.External.Company;
import com.embarkx.jobms.dto.JonWithCompanyDTO;

public class JobMapper {

    public static JonWithCompanyDTO mapToJobWithCompanyDTO(Job job, Company company){
        JonWithCompanyDTO jobWithCompanyDTO = new JonWithCompanyDTO();
        jobWithCompanyDTO.setId(job.getId());
        jobWithCompanyDTO.setTitle(job.getTitle());
        jobWithCompanyDTO.setDescription(job.getDescription());
        jobWithCompanyDTO.setMinSalary(job.getMinSalary());
        jobWithCompanyDTO.setMaxSalary(job.getMaxSalary());
        jobWithCompanyDTO.setLocation(job.getLocation());
        jobWithCompanyDTO.setCompanyId(job.getCompanyId());
        jobWithCompanyDTO.setCompany(company);
        
        return jobWithCompanyDTO;

    }
    
}
