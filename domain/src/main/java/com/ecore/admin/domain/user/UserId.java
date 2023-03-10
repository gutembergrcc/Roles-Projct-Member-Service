package com.ecore.admin.domain.user;

import com.ecore.admin.domain.Identifier;
import com.ecore.admin.domain.utils.IdUtils;

import java.util.Objects;

public class UserId extends Identifier {

    private final String value;

    private UserId(final String value) {
        this.value = Objects.requireNonNull(value);
    }

    public static UserId unique() {
        return UserId.from(IdUtils.uuid());
    }

    public static UserId from(final String id) {
        return new UserId(id);
    }
}
