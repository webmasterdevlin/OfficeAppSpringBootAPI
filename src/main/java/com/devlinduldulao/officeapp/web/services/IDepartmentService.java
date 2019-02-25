package com.devlinduldulao.officeapp.web.services;

import com.devlinduldulao.officeapp.core.entities.DepartmentEntity;

public interface IDepartmentService {
    boolean exists(int id);
    Iterable<DepartmentEntity> getDepartmentsList();
    DepartmentEntity getDepartmentById(int id);
    DepartmentEntity createDepartment(DepartmentEntity departmentEntity);
    DepartmentEntity updateDepartment(DepartmentEntity departmentEntity);
    void delete(int id);
}
