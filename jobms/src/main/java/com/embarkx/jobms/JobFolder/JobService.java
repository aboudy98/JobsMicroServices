package com.embarkx.jobms.JobFolder;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job findById(Long id);
    void deleteJob(Long id) throws Exception;
    Job updateJob(Long id, Job job) throws Exception;
    
}
