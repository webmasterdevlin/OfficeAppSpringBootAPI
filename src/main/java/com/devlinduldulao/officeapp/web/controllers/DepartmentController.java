package com.devlinduldulao.officeapp.web.controllers;

import com.devlinduldulao.officeapp.application.dtos.DepartmentDto;
import com.devlinduldulao.officeapp.core.entities.DepartmentEntity;
import com.devlinduldulao.officeapp.web.services.DepartmentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@Api(value="Departments", description="Operations pertaining to departments of Office App")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(value = "/api/departments", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<DepartmentDto> getDepartments() {
        var departments = departmentService.getDepartmentsList();
        return departments.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @RequestMapping(value = "/api/departments/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DepartmentDto getDepartment(@PathVariable("id") Long id) {
        return convertToDto(departmentService.getDepartmentById(id));
    }

    @RequestMapping(value = "/api/departments",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public DepartmentDto createDepartment(@Valid @RequestBody DepartmentDto departmentDto) throws ParseException {
        var departmentEntity = convertToEntity(departmentDto);
        var createdDepartment = departmentService.createDepartment(departmentEntity);
        return convertToDto(createdDepartment);
    }

    @RequestMapping(value = "/api/departments/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDepartment(@PathVariable("id") Long id, @Valid @RequestBody DepartmentDto departmentDto) throws ParseException {

        if (!id.equals(departmentDto.getId())) throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "id does not match"
        );

        var departmentEntity = convertToEntity(departmentDto);
        departmentService.updateDepartment(departmentEntity);
    }

    @RequestMapping(value = "/api/departments/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteDepartment(@PathVariable("id") long id) {
        departmentService.delete(id);
    }

    private DepartmentDto convertToDto(DepartmentEntity departmentEntity) {
        return  modelMapper.map(departmentEntity, DepartmentDto.class);
    }
    private DepartmentEntity convertToEntity(DepartmentDto departmentDto) throws ParseException {
        return modelMapper.map(departmentDto, DepartmentEntity.class);
    }
}
