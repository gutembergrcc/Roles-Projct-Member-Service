package com.ecore.admin.domain.team;

import com.ecore.admin.domain.validation.Error;
import com.ecore.admin.domain.validation.ValidationHandler;
import com.ecore.admin.domain.validation.Validator;

public class RoleValidator extends Validator {

    public static final int NAME_MAX_LENGTH = 255;
    public static final int NAME_MIN_LENGTH = 3;
    public static final int ACRONYM_MAX_LENGTH = 30;
    public static final int ACRONYM_MIN_LENGTH = 3;
    private final Role role;

    public RoleValidator(final Role role, final ValidationHandler handler) {
        super(handler);
        this.role = role;
    }

    @Override
    public void validate() {
        checkNameConstraints();
        checkAcronymConstraints();
    }

    private void checkNameConstraints() {
        String name = this.role.getName();

        if (name == null) {
            this.validationHandler().append(new Error("'name' should not be null"));
            return;
        }

        if (name.isBlank()) {
            this.validationHandler().append(new Error("'name' should not be empty"));
            return;
        }

        final int length = name.trim().length();
        if (length > NAME_MAX_LENGTH || length < NAME_MIN_LENGTH) {
            this.validationHandler().append(new Error("'name' must be between 3 and 255 characters"));
        }
    }

    private void checkAcronymConstraints() {
        String acronym = this.role.getAcronym();

        if (acronym == null) {
            this.validationHandler().append(new Error("'acronym' should not be null"));
            return;
        }

        if (acronym.isBlank()) {
            this.validationHandler().append(new Error("'acronym' should not be empty"));
            return;
        }

        final int length = acronym.trim().length();
        if (length > ACRONYM_MAX_LENGTH || length < ACRONYM_MIN_LENGTH) {
            this.validationHandler().append(new Error("'acronym' must be between 3 and 30 characters"));
        }
    }
}
