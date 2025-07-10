package com.embarkx.jobms.dto;


import com.embarkx.jobms.JobFolder.External.Company;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JonWithCompanyDTO {
     private Long id;
    private String title;
    private String description;
    private Long minSalary;
    private Long maxSalary;
    private String location;
    private Long companyId;

    private Company company;
    
}
