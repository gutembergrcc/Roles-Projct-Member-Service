package com.ecore.admin.application.team.role.create;

public record CreateRoleCommand(String name, String acronym) {
    public static CreateRoleCommand with(final String name, final String acronym){
        return new CreateRoleCommand(name, acronym);
    }
}
