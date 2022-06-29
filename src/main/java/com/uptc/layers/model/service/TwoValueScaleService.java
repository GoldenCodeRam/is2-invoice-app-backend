package com.uptc.layers.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uptc.layers.model.entity.TwoValueScale;
import com.uptc.layers.model.entity.TwoValueScaleDAO;

public interface TwoValueScaleService {
    public List<TwoValueScale> findAll();
    public void deleteById(Long id);
    public void save(TwoValueScale twoValueScale);
    
    @Service
    public static class TwoValueScaleServiceImpl implements TwoValueScaleService {
        @Autowired
        private TwoValueScaleDAO dao;

        @Override
        public List<TwoValueScale> findAll() {
            return (List<TwoValueScale>) dao.findAll();
        }

        @Override
        public void deleteById(Long id) {
            dao.deleteById(id);
        }

        @Override
        public void save(TwoValueScale twoValueScale) {
            dao.save(twoValueScale);
        }
    }
}
