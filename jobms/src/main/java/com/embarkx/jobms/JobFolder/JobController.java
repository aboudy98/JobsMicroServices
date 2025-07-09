package com.embarkx.jobms.JobFolder;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.embarkx.jobms.dto.JonWithCompanyDTO;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @GetMapping
    public ResponseEntity <List<JonWithCompanyDTO>> findAll(){

        return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity <String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findById(@PathVariable Long id) throws Exception {
        Job job = jobService.findById(id);
        if(job == null) {
            
            throw new Exception("Job not found with id: " + id);
        }
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) throws Exception{
        jobService.deleteJob(id);

        return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job job){
        try {
            Job newJob  = jobService.updateJob(id, job);
            return new ResponseEntity<>(newJob, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("Error updating job: " + e.getMessage());
        }
    }
    
}
