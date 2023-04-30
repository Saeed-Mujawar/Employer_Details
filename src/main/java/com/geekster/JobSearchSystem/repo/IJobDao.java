package com.geekster.JobSearchSystem.repo;

import com.geekster.JobSearchSystem.model.Job;
import com.geekster.JobSearchSystem.model.JobType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobDao extends CrudRepository<Job,Integer> {

    List<Job> findByJobType(JobType jobType);

    List<Job> findByTitleContainingIgnoreCase(String title);

    List<Job> findByCompanyNameContainingIgnoreCase(String companyName);

    @Modifying
    @Query(value = "update job set Salary=:salary where id=:id",nativeQuery = true)
    void updateSalary(int id, Double salary);

    @Modifying
    @Query(value = "update job set Company_Name=:companyName where id=:id",nativeQuery = true)
    void updateCompanyNameById(int id, String companyName);

    @Modifying
    @Query(value = "Delete from Job where Salary <= :salary",nativeQuery = true)
    void removeJobsLessThanSalary(Double salary);
}
