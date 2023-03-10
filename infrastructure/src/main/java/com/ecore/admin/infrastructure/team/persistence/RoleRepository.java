package com.ecore.admin.infrastructure.team.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleJpaEntity, String> {
}
