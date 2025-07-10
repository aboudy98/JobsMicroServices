package com.embarkx.jobms.JobFolder.mapper;

import java.util.List;

import com.embarkx.jobms.JobFolder.Job;
import com.embarkx.jobms.JobFolder.External.Company;
import com.embarkx.jobms.JobFolder.External.Review;
import com.embarkx.jobms.dto.JobDTO;

public class JobMapper {

    public static JobDTO mapToJobWithCompanyDTO(Job job, Company company,List<Review> reviews){
        JobDTO jobWithCompanyDTO = new JobDTO();
        jobWithCompanyDTO.setId(job.getId());
        jobWithCompanyDTO.setTitle(job.getTitle());
        jobWithCompanyDTO.setDescription(job.getDescription());
        jobWithCompanyDTO.setMinSalary(job.getMinSalary());
        jobWithCompanyDTO.setMaxSalary(job.getMaxSalary());
        jobWithCompanyDTO.setLocation(job.getLocation());
        jobWithCompanyDTO.setCompanyId(job.getCompanyId());
        jobWithCompanyDTO.setCompany(company);
        jobWithCompanyDTO.setReviews(reviews);
        
        return jobWithCompanyDTO;

    }
    
}
