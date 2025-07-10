package com.embarkx.jobms.JobFolder;

import java.util.List;

import com.embarkx.jobms.dto.JobDTO;

public interface JobService {
    List<JobDTO> findAll();
    void createJob(Job job);
    JobDTO findById(Long id);
    void deleteJob(Long id) throws Exception;
    Job updateJob(Long id, Job job) throws Exception;
    
}
