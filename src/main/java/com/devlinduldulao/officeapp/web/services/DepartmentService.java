package com.devlinduldulao.officeapp.web.services;

import com.devlinduldulao.officeapp.core.entities.DepartmentEntity;
import com.devlinduldulao.officeapp.core.interfaces.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public boolean exists(Long id) {
        return departmentRepository.existsById(id);
    }

    @Override
    public List<DepartmentEntity> getDepartmentsList() {
        return (List<DepartmentEntity>)  departmentRepository.findAll();
    }

    @Override
    public DepartmentEntity getDepartmentById(Long id) {
        var result = departmentRepository.findById(id);
       return result.orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + id));
    }

    @Override
    public DepartmentEntity createDepartment(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    @Override
    public void updateDepartment(DepartmentEntity departmentEntity) {
        departmentRepository.save(departmentEntity);
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }
}
