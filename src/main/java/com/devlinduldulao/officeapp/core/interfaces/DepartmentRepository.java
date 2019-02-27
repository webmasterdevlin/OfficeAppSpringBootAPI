package com.devlinduldulao.officeapp.core.interfaces;

import com.devlinduldulao.officeapp.core.entities.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin
public interface DepartmentRepository extends CrudRepository<DepartmentEntity, Long> {
}
