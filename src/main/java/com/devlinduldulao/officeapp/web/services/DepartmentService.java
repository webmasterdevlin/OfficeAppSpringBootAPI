package com.devlinduldulao.officeapp.web.services;

import com.devlinduldulao.officeapp.core.entities.DepartmentEntity;
import com.devlinduldulao.officeapp.core.interfaces.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DepartmentService implements IDepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public boolean exists(int id) {
        return false;
    }

    @Override
    public Iterable<DepartmentEntity> getDepartmentsList() {
        return null;
    }

    @Override
    public DepartmentEntity getDepartmentById(int id) {
        return null;
    }

    @Override
    public DepartmentEntity createDepartment(DepartmentEntity departmentEntity) {
        return null;
    }

    @Override
    public DepartmentEntity updateDepartment(DepartmentEntity departmentEntity) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
