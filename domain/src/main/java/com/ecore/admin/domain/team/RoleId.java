package com.ecore.admin.domain.team;

import com.ecore.admin.domain.Identifier;
import com.ecore.admin.domain.utils.IdUtils;

import java.util.Objects;

public class RoleId extends Identifier{

    private final String value;

    public String getValue() {
        return value;
    }

    private RoleId(final String value) {
        this.value = Objects.requireNonNull(value);
    }

    public static RoleId unique() {
        return RoleId.from(IdUtils.uuid());
    }

    public static RoleId from(final String id) {
        return new RoleId(id);
    }
}
