package com.ecore.admin.infrastructure.team.persistence;

import com.ecore.admin.domain.team.Role;
import com.ecore.admin.domain.team.RoleId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Role")
@Table(name = "roles")
public class RoleJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "acronym", length = 30)
    private String acronym;

    public RoleJpaEntity(){

    }
    public RoleJpaEntity(String id, String name, String acronym) {
        this.id = id;
        this.name = name;
        this.acronym = acronym;
    }

    public static RoleJpaEntity from(final Role role){
        return new RoleJpaEntity(role.getId().getValue(), role.getName(), role.getAcronym());
    }

    public Role toAggregate() {
        return Role.with(RoleId.from(getId()), getName(), getAcronym());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }
}
