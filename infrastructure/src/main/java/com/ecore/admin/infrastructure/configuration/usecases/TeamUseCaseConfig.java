package com.ecore.admin.infrastructure.configuration.usecases;

import com.ecore.admin.application.team.role.create.CreateRoleUseCase;
import com.ecore.admin.domain.team.RoleGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeamUseCaseConfig {

    private final RoleGateway roleGateway;

    public TeamUseCaseConfig(RoleGateway roleGateway) {
        this.roleGateway = roleGateway;
    }

    @Bean
    public CreateRoleUseCase createRoleUseCase() {
        return new CreateRoleUseCase(roleGateway);
    }
}
