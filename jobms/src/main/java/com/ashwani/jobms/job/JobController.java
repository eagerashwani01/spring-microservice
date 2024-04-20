package com.ashwani.jobms.job;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.ashwani.jobms.job.dto.JobDTO;


@RestController
@RequestMapping("/jobs")
@Tag(name = "Job Controller is here")
public class JobController {

    @Autowired
    private JobService jobService;

    @Operation(summary = "GET all jobs", description = "It returns all jobs from database")
    @GetMapping
    public ResponseEntity<List<JobDTO>> findAll(){
        List<JobDTO> jobs = jobService.allJobs();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findOne(@PathVariable Long id){
        Job job = jobService.oneJob(id);
        if(job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/company")
    public ResponseEntity<List<Job>> getAllJobsForCompany(@PathVariable Long id) {
        List<Job> allJobsForCompany = jobService.getAllJobsForCompany(id);
        
        return new ResponseEntity<>(allJobsForCompany, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job job){
        boolean updated = jobService.updateJob(id, job);
        if(updated)
            return new ResponseEntity<>("Job updated Successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeJob(@PathVariable Long id){
        boolean removed = jobService.removeJobById(id);
        if(removed)
            return new ResponseEntity<>("Job removed Successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
