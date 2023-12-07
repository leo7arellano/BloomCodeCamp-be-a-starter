package com.hcc.controllers;

import com.hcc.entities.Assignment;
import com.hcc.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @GetMapping
    public List<Assignment> getAllAssignments() {return assignmentRepository.findAll();}

    @GetMapping("/{id}")
    public Assignment getAssignmentById(@PathVariable Long id) {
        return assignmentRepository.findById(id).get();
    }

    @PostMapping
    public Assignment createAssignment(@RequestBody Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @PutMapping(value = "/{id}")
    public Assignment updateAssignment(@PathVariable Long id, @RequestBody Assignment assignment) {
        Assignment existingAssignment = assignmentRepository.findById(id).get();

        existingAssignment.setBranch(assignment.getBranch());
        existingAssignment.setCodeReviewer(assignment.getCodeReviewer());
        existingAssignment.setGithubUrl(assignment.getGithubUrl());
        existingAssignment.setStatus(assignment.getStatus());
        existingAssignment.setNumber(assignment.getNumber());
        //existingAssignment.setReviewVideoUrl(assignment.getReviewVideoUrl());
        existingAssignment.setUser(assignment.getUser());

        return assignmentRepository.save(existingAssignment);
    }

}
