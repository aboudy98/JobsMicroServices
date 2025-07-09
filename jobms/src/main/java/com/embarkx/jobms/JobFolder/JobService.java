package com.embarkx.jobms.JobFolder;

import java.util.List;

import com.embarkx.jobms.dto.JonWithCompanyDTO;

public interface JobService {
    List<JonWithCompanyDTO> findAll();
    void createJob(Job job);
    Job findById(Long id);
    void deleteJob(Long id) throws Exception;
    Job updateJob(Long id, Job job) throws Exception;
    
}
