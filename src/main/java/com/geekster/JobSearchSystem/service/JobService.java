package com.geekster.JobSearchSystem.service;

import com.geekster.JobSearchSystem.model.Job;
import com.geekster.JobSearchSystem.model.JobType;
import com.geekster.JobSearchSystem.repo.IJobDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    IJobDao jobDao;

    public List<Job> getAll() {
        return (List<Job>) jobDao.findAll();
    }

    public String saveJobs(List<Job> jobs) {
        jobDao.saveAll(jobs);
        return "Added successfully";
    }

    public String deleteJobById(int id) {
        if(jobDao.existsById(id)){
            jobDao.deleteById(id);
            return "Deleted Successfully";
        }return "NO jobs to Delete";
    }

    public List<Job> getAllJobsByJobType(JobType jobTypeEnum) {
        return jobDao.findByJobType(jobTypeEnum);
    }


    public List<Job> findByTitleContainingIgnoreCase(String title) {
        return jobDao.findByTitleContainingIgnoreCase(title);
    }

    public List<Job> findByCompanyNameContainingIgnoreCase(String companyName) {
        return jobDao.findByCompanyNameContainingIgnoreCase(companyName);
    }

    public void updateSalary(int id, Double salary) {
        jobDao.updateSalary(id,salary);
    }

    public void updateCompanyNameById(int id, String companyName) {
        jobDao.updateCompanyNameById(id,companyName);
    }

    public void removeJobsLessThanSalary(Double salary) {
        jobDao.removeJobsLessThanSalary(salary);
    }
}
