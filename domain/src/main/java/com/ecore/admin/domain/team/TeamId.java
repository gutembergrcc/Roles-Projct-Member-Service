package com.ecore.admin.domain.team;

import com.ecore.admin.domain.Identifier;
import com.ecore.admin.domain.user.UserId;
import com.ecore.admin.domain.utils.IdUtils;

import java.util.Objects;

public class TeamId extends Identifier {

    private final String value;

    private TeamId(final String value) {
        this.value = Objects.requireNonNull(value);
    }

    public static TeamId unique() {
        return TeamId.from(IdUtils.uuid());
    }

    public static TeamId from(final String id) {
        return new TeamId(id);
    }
}
