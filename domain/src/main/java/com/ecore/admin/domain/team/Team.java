package com.ecore.admin.domain.team;

import com.ecore.admin.domain.Entity;
import com.ecore.admin.domain.utils.InstantUtils;
import com.ecore.admin.domain.validation.ValidationHandler;

import java.time.Instant;

public class Team extends Entity<TeamId> {

    private boolean active;
    private Instant deletedAt;

    private Team(TeamId teamId, boolean active, Instant deletedAt) {
        super(teamId);
        this.active = active;
        this.deletedAt = deletedAt;
    }

    public static Team newTeam(final boolean isActive) {
        final var id = TeamId.unique();
        final var now = InstantUtils.now();
        final var deletedAt = isActive ? null : now;
        return new Team(id, isActive, deletedAt);
    }

    @Override
    public void validate(ValidationHandler handler) {
        /** Para o desafio não criei validador para Team e User. No cenário real as entidades teriam seus validadores,
         * Caso no avanço do projeto não fosse necessário teria um Entity (mais generico) sem o validade. **/

    }
}
