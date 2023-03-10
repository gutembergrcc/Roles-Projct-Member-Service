package com.ecore.admin.domain.team;

import com.ecore.admin.domain.user.User;

import java.util.Optional;

public interface TeamMemberGateway {

    TeamMember create(User user, Team team, Role role);

    //Optional<TeamMember> findById(TeamMemberId id);

    Optional<TeamMember> findByRole(Role role);
}
