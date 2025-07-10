package com.embarkx.jobms.dto;


import java.util.List;

import com.embarkx.jobms.JobFolder.External.Company;
import com.embarkx.jobms.JobFolder.External.Review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobDTO {
     private Long id;
    private String title;
    private String description;
    private Long minSalary;
    private Long maxSalary;
    private String location;
    private Long companyId;
    private Company company;
    private List<Review> reviews;

}
