package com.ecore.admin.infrastructure.api.controller;

import com.ecore.admin.application.team.role.create.CreateRoleCommand;
import com.ecore.admin.application.team.role.create.CreateRoleOutput;
import com.ecore.admin.application.team.role.create.CreateRoleUseCase;
import com.ecore.admin.domain.exceptions.DomainException;
import com.ecore.admin.infrastructure.api.RoleAPI;
import com.ecore.admin.infrastructure.team.models.CreateRoleRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class RoleController implements RoleAPI {

    private final CreateRoleUseCase createRoleUseCase;

    public RoleController(CreateRoleUseCase createRoleUseCase) {
        this.createRoleUseCase = createRoleUseCase;
    }

    @Override
    public ResponseEntity<?> createRole(final CreateRoleRequest input) {
        final var command = CreateRoleCommand.with(input.name(), input.acronym());

        CreateRoleOutput output = null;
        try{
            output = this.createRoleUseCase.execute(command);
        }catch (DomainException e){
            return ResponseEntity.unprocessableEntity().body(e.getErrors());
        }

        return ResponseEntity.created(URI.create("/roles" + output.id())).body(output);
    }
}
