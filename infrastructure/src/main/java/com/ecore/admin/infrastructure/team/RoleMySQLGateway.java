package com.ecore.admin.infrastructure.team;

import com.ecore.admin.domain.team.Role;
import com.ecore.admin.domain.team.RoleGateway;
import com.ecore.admin.infrastructure.team.persistence.RoleJpaEntity;
import com.ecore.admin.infrastructure.team.persistence.RoleRepository;
import org.springframework.stereotype.Component;

@Component
public class RoleMySQLGateway implements RoleGateway {

    private final RoleRepository repository;

    public RoleMySQLGateway(final RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role create(Role role) {
        return repository.save(RoleJpaEntity.from(role)).toAggregate();
    }
}
