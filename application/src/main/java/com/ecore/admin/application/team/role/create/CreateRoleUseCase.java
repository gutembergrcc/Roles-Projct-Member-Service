package com.ecore.admin.application.team.role.create;

import com.ecore.admin.application.UseCase;
import com.ecore.admin.domain.exceptions.DomainException;
import com.ecore.admin.domain.team.Role;
import com.ecore.admin.domain.team.RoleGateway;
import com.ecore.admin.domain.validation.Notification;

import java.util.Objects;

public class CreateRoleUseCase extends UseCase<CreateRoleCommand, CreateRoleOutput> {

    private final RoleGateway roleGateway;

    public CreateRoleUseCase(final RoleGateway roleGateway) {
        this.roleGateway = Objects.requireNonNull(roleGateway);
    }

    @Override
    public CreateRoleOutput execute(CreateRoleCommand command) {
        final var name = command.name();
        final var acronym = command.acronym();

        final var role = Role.newRole(name, acronym);

        final var notification = Notification.create();
        role.validate(notification);
        if(notification.hasError()){
            throw DomainException.with(notification.getErrors());
        }

        var roleCreated = this.roleGateway.create(role);
        return CreateRoleOutput.from(roleCreated);
    }
}
