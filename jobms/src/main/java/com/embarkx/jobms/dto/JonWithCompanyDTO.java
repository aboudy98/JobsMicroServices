package com.embarkx.jobms.dto;

import com.embarkx.jobms.JobFolder.Job;
import com.embarkx.jobms.JobFolder.External.Company;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JonWithCompanyDTO {
    private Job job;
    private Company company;
    
}
