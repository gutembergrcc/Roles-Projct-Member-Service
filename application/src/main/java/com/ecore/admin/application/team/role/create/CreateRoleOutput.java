package com.ecore.admin.application.team.role.create;

import com.ecore.admin.domain.team.Role;

public record CreateRoleOutput(String id) {
    public static CreateRoleOutput from(final Role role) {
        return new CreateRoleOutput(role.getId().getValue());
    }
}
