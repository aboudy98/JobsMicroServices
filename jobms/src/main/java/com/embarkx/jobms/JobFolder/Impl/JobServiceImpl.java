package com.embarkx.jobms.JobFolder.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

import com.embarkx.jobms.JobFolder.Job;
import com.embarkx.jobms.JobFolder.JobRepository;
import com.embarkx.jobms.JobFolder.JobService;
import com.embarkx.jobms.JobFolder.External.Company;
import com.embarkx.jobms.dto.JonWithCompanyDTO;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    private JonWithCompanyDTO convertToDTO(Job job){
            RestTemplate restTemplate = new RestTemplate();
            JonWithCompanyDTO jobWithCompanyDTO = new JonWithCompanyDTO();
            jobWithCompanyDTO.setJob(job);
            Company company = restTemplate.getForObject("http://localhost:8081/companies/"+ job.getCompanyId(), 
            Company.class);
            jobWithCompanyDTO.setCompany(company);
           

        return jobWithCompanyDTO;

    }

    @Override
    public List<JonWithCompanyDTO> findAll() {
        List<Job> jobs = jobRepository.findAll();
        List<JonWithCompanyDTO> jonWithCompanyDTOs = new ArrayList<>();
       

       // this is a stream operation to convert each Job to JonWithCompanyDTO
        return jobs.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);

    }

    @Override
    public Job findById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteJob(Long id) throws Exception {
        Job jobById = findById(id);
        if (jobById == null) {
            throw new Exception("Job not found with id: " + id);
        }
        jobRepository.deleteById(id);
    }

    @Override
    public Job updateJob(Long id, Job job) throws Exception {

        Job existingJob = findById(id);
        if (existingJob == null) {
            throw new Exception("Job not found with id: " + id);
        }

        existingJob.setTitle(job.getTitle());
        existingJob.setDescription(job.getDescription());
        existingJob.setMinSalary(job.getMinSalary());
        existingJob.setMaxSalary(job.getMaxSalary());
        existingJob.setLocation(job.getLocation());
        jobRepository.save(existingJob);
        return existingJob;
    }

}
