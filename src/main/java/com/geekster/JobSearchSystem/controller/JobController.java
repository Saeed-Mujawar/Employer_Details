package com.geekster.JobSearchSystem.controller;

import com.geekster.JobSearchSystem.model.Job;
import com.geekster.JobSearchSystem.model.JobType;
import com.geekster.JobSearchSystem.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping(value = "/jobs")
    public List<Job> getAllJobs() {
        return jobService.getAll();
    }

    @GetMapping("/jobType/{jobType}")
    public List<Job> getAllJobsByJobType(@PathVariable String jobType) {
        JobType jobTypeEnum = JobType.valueOf(jobType);
        return jobService.getAllJobsByJobType(jobTypeEnum);
    }

    @GetMapping("/title/{title}")
    public List<Job> getAllJobsByTitle(@PathVariable String title) {
        return jobService.findByTitleContainingIgnoreCase(title);
    }


    @GetMapping("/companyName/{companyName}")
    public List<Job> getAllJobsByCompanyName(@PathVariable String companyName) {
        return jobService.findByCompanyNameContainingIgnoreCase(companyName);
    }

    @PostMapping(value = "/job")
    public String saveJobs(@Valid @RequestBody List<Job> jobs) {
        return jobService.saveJobs(jobs);
    }





    @PutMapping("/update/id/{id}/salary/{salary}")
    public void updateSalary(@PathVariable int id,@PathVariable Double salary){
        jobService.updateSalary(id,salary);
    }

    @PutMapping("id/{id}/companyName/{companyName}")
    public void updateCompanyNameById(@PathVariable int id,@PathVariable String companyName){
        jobService.updateCompanyNameById(id,companyName);
    }

    @DeleteMapping("/salary/{salary}")
    public void removeJobsLessThanSalary(@PathVariable Double salary){
        jobService.removeJobsLessThanSalary(salary);
    }

    @DeleteMapping("/{id}")
    public String deleteJobById(@PathVariable int id) {
        return jobService.deleteJobById(id);
    }
}

