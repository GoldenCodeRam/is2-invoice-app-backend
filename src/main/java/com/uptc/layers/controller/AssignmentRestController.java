package com.uptc.layers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uptc.layers.model.entity.Assignment;
import com.uptc.layers.model.entity.TwoValueScale;
import com.uptc.layers.model.service.AssignmentService;
import com.uptc.layers.model.service.TwoValueScaleService;

@RestController
@CrossOrigin
@RequestMapping("/data/assignment")
public class AssignmentRestController {
    @Autowired
    AssignmentService assignmentService;

    @Autowired
    TwoValueScaleService twoValueScaleService;

    @GetMapping("/all")
    public List<Assignment> all() {
        return assignmentService.findAll();
    }

    @PostMapping("/find")
    public Assignment findWithId(@RequestBody Long assignmentId) {
        return assignmentService.findById(assignmentId);
    }

    @GetMapping("/two-value-scale/all")
    public List<TwoValueScale> allTwoValueScales() {
        return twoValueScaleService.findAll();
    }

    @DeleteMapping("/two-value-scale")
    public void deleteById(@RequestBody Long id) {
        twoValueScaleService.deleteById(id);
    }

    @PostMapping("/two-value-scale")
    public void save(@RequestBody TwoValueScale twoValueScale) {
        System.out.println(twoValueScale);
        twoValueScaleService.save(twoValueScale);
    }
}
