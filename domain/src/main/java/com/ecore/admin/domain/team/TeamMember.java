package com.ecore.admin.domain.team;

import com.ecore.admin.domain.Entity;
import com.ecore.admin.domain.user.User;
import com.ecore.admin.domain.validation.ValidationHandler;


public class TeamMember extends Entity<TeamMemberId> {

    private Role role;

    public TeamMember(TeamMemberId teamMemberId, Role role) {
        super(teamMemberId);
        this.role = role;
    }

    public static TeamMember newTeamMember(final Team team, final User user, final Role role) {
        return new TeamMember(new TeamMemberId(team, user), role);
    }

    public Role getRole() {
        return role;
    }

    @Override
    public void validate(ValidationHandler handler) {
        new TeamMemberValidator(this, handler).validate();
    }
}
