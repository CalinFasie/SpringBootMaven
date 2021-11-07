package com.example.demo.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Role {

    @Id
    private Long roleId;
    private String roleName;
    private String roleDescription;
}
