package com.devlinduldulao.officeapp.web.services;

import com.devlinduldulao.officeapp.core.entities.DepartmentEntity;

import java.util.List;

public interface IDepartmentService {
    boolean exists(Long id);
    List<DepartmentEntity> getDepartmentsList();
    DepartmentEntity getDepartmentById(Long id);
    DepartmentEntity createDepartment(DepartmentEntity departmentEntity);
    void updateDepartment(DepartmentEntity departmentEntity);
    void delete(Long id);
}
