package com.devlinduldulao.officeapp.core.interfaces;

import com.devlinduldulao.officeapp.core.entities.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<DepartmentEntity, Long> {
}
