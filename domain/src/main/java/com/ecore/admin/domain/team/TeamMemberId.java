package com.ecore.admin.domain.team;

import com.ecore.admin.domain.Identifier;
import com.ecore.admin.domain.user.User;

public class TeamMemberId extends Identifier {

    private Team team;

    private User user;

    public TeamMemberId(Team team, User user) {
        this.team = team;
        this.user = user;
    }

    public Team getTeam() {
        return team;
    }

    public User getUser() {
        return user;
    }
}
