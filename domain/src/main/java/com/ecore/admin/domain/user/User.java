package com.ecore.admin.domain.user;

import com.ecore.admin.domain.Entity;
import com.ecore.admin.domain.utils.InstantUtils;
import com.ecore.admin.domain.validation.ValidationHandler;

import java.time.Instant;

public class User extends Entity<UserId> {

    private boolean active;
    private Instant deletedAt;

    private User(UserId userId, boolean active, Instant deletedAt) {
        super(userId);
        this.active = active;
        this.deletedAt = deletedAt;
    }

    public static User newUser(final boolean isActive) {
        final var id = UserId.unique();
        final var now = InstantUtils.now();
        final var deletedAt = isActive ? null : now;
        return new User(id, isActive, deletedAt);
    }

    @Override
    public void validate(ValidationHandler handler) {
        /** Para o desafio não criei validador para Team e User. No cenário real as entidades teriam seus validadores,
         * Caso no avanço do projeto não fosse necessário teria um Entity (mais generico) sem o validade. **/
    }
}
