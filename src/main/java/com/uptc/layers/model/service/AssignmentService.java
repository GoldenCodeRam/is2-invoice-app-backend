package com.uptc.layers.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uptc.layers.model.entity.Assignment;
import com.uptc.layers.model.entity.AssignmentDAO;

public interface AssignmentService {
    public List<Assignment> findAll();
    public Assignment findById(Long assignmentId);

    @Service
    public static class AssignmentServiceImpl implements AssignmentService {
        @Autowired
        private AssignmentDAO dao;

        @Override
        public List<Assignment> findAll() {
            return (List<Assignment>) dao.findAll();
        }

        @Override
        public Assignment findById(Long assignmentId) {
            return dao.findById(assignmentId).get();
        }
    }
}
