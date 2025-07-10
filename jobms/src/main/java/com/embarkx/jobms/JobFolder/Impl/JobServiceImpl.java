package com.embarkx.jobms.JobFolder.Impl;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

import com.embarkx.jobms.Client.CompanyClient;
import com.embarkx.jobms.Client.ReviewClinet;
import com.embarkx.jobms.JobFolder.Job;
import com.embarkx.jobms.JobFolder.JobRepository;
import com.embarkx.jobms.JobFolder.JobService;
import com.embarkx.jobms.JobFolder.External.Company;
import com.embarkx.jobms.JobFolder.External.Review;
import com.embarkx.jobms.JobFolder.mapper.JobMapper;
import com.embarkx.jobms.dto.JobDTO;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

 
    private final CompanyClient companyClient;
    private final ReviewClinet reviewClinet;

    private JobDTO convertToDTO(Job job){
            
            Company company = companyClient.getCompanyById(job.getCompanyId());
          
            List<Review> reviews = reviewClinet.getReviews(job.getCompanyId());
            JobDTO jobWithCompanyDTO = JobMapper.mapToJobWithCompanyDTO(job, company,reviews);
           
           

        return jobWithCompanyDTO;

    }

    @Override
    public List<JobDTO> findAll() {
        List<Job> jobs = jobRepository.findAll();
        List<JobDTO> jonWithCompanyDTOs = new ArrayList<>();
       

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
    public JobDTO findById(Long id) {
        Job job = jobRepository.findById(id).orElse(null);

        return convertToDTO(job);
    }

    @Override
    public void deleteJob(Long id) throws Exception {
        Job jobById = jobRepository.findById(id).orElse(null);
        if (jobById == null) {
            throw new Exception("Job not found with id: " + id);
        }
        jobRepository.deleteById(id);
    }

    @Override
    public Job updateJob(Long id, Job job) throws Exception {

        Job existingJob = jobRepository.findById(id).orElse(null);
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
