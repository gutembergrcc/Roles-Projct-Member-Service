package com.ecore.admin.domain.team;

import com.ecore.admin.domain.validation.Error;
import com.ecore.admin.domain.validation.ValidationHandler;
import com.ecore.admin.domain.validation.Validator;

public class TeamMemberValidator extends Validator {

    private final TeamMember teamMember;

    public TeamMemberValidator(TeamMember teamMember, ValidationHandler handler) {
        super(handler);
        this.teamMember = teamMember;
    }

    @Override
    public void validate() {
        if (this.teamMember.getId().getTeam() == null) {
            this.validationHandler().append(new Error("'Team' should not be null"));
            return;
        }

        if (this.teamMember.getId().getUser() == null) {
            this.validationHandler().append(new Error("'User' should not be null"));
            return;
        }

        if (this.teamMember.getRole() == null) {
            this.validationHandler().append(new Error("'Role' should not be null"));
            return;
        }
    }
}
