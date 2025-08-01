package com.cst438.controller;

import com.cst438.domain.*;
import com.cst438.dto.EnrollmentDTO;
import com.cst438.service.RegistrarServiceProxy;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

import java.util.List;

@RestController
public class EnrollmentController {

    private final EnrollmentRepository enrollmentRepository;
    private final SectionRepository sectionRepository;
    private final RegistrarServiceProxy registrar;

    public EnrollmentController (
            EnrollmentRepository enrollmentRepository,
            SectionRepository sectionRepository,
            RegistrarServiceProxy registrar
    ) {
        this.enrollmentRepository = enrollmentRepository;
        this.sectionRepository = sectionRepository;
        this.registrar = registrar;
    }


    // instructor gets student enrollments with grades for a section
    @PreAuthorize("hasAuthority('SCOPE_ROLE_INSTRUCTOR')")
    @GetMapping("/sections/{sectionNo}/enrollments")
    public List<EnrollmentDTO> getEnrollments(
            @PathVariable("sectionNo") int sectionNo, Principal principal ) {
				
		// check that the sectionNo belongs to the logged in instructor.
		
		// use the EnrollmentRepository findEnrollmentsBySectionNoOrderByStudentName
		// to get a list of Enrollments for the given sectionNo.
		// Return a list of EnrollmentDTOs

        return null;
    }

    // instructor updates enrollment grades
    @PreAuthorize("hasAuthority('SCOPE_ROLE_INSTRUCTOR')")
    @PutMapping("/enrollments")
    public void updateEnrollmentGrade(@Valid @RequestBody List<EnrollmentDTO> dtoList, Principal principal) {
		// for each EnrollmentDTO 
        //    check that logged in user is instructor for the section
        //    update the enrollment grade
        //    send message to Registrar service for grade update
       
    }
}
