package com.geekster.JobSearchSystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Job {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Length(min = 1, max = 255)
    private String title;

    @NotBlank
   @Length(max = 500)
    private String description;

    @NotBlank
    private String location;

    @NotNull
    private Double salary;

    @NotBlank
    private String companyName;

    @NotBlank
    private String employerName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private JobType jobType;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate appliedDate;
}
