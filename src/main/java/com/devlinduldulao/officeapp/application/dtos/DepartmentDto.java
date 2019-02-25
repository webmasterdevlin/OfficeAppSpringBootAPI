package com.devlinduldulao.officeapp.application.dtos;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class DepartmentDto {
    private int id;
    @NotNull
    private String name;
    private String description;
    private String head;
    private String code;
}
