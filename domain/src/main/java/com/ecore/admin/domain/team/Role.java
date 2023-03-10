package com.ecore.admin.domain.team;

import com.ecore.admin.domain.Entity;
import com.ecore.admin.domain.validation.ValidationHandler;

public class Role extends Entity<RoleId> {

    private String name;

    private String acronym;

    private Role(RoleId id, String name, String acronym) {
        super(id);
        this.name = name;
        this.acronym = acronym;
    }

    public static Role newRole(final String name, String acronym) {
        final var id = RoleId.unique();
        return new Role(id, name, acronym);
    }

    public static Role with(final RoleId roleId, final String name, String acronym) {
        return new Role(roleId, name, acronym);
    }

    @Override
    public void validate(ValidationHandler handler) {
        new RoleValidator(this, handler).validate();
    }

    public String getName() {
        return name;
    }

    public String getAcronym() {
        return acronym;
    }
}
