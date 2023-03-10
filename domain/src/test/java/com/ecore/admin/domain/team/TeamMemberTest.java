package com.ecore.admin.domain.team;

import com.ecore.admin.domain.user.User;
import com.ecore.admin.domain.validation.Notification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TeamMemberTest {

    @Test
    public void givenAValidParams_whenCallNewTeamMember_thenInstantiateATeamMember() {
        final User user = User.newUser(true);
        final Team team = Team.newTeam(true);

        final var expectedName = "Developer";
        final var expectedAcronym = "DEV";
        final Role role = Role.newRole(expectedName, expectedAcronym);

        TeamMember teamMember = TeamMember.newTeamMember(team, user, role);

        Assertions.assertNotNull(teamMember);
        Assertions.assertNotNull(teamMember.getId());
        Assertions.assertNotNull(teamMember.getId().getTeam());
        Assertions.assertNotNull(teamMember.getId().getUser());
        Assertions.assertEquals(expectedName, role.getName());
        Assertions.assertEquals(expectedAcronym, role.getAcronym());
    }

    @Test
    public void givenAInvalidUser_whenCallNewTeamMember_thenInstantiateATeamMember() {
        final User user = null;
        final Team team = Team.newTeam(true);

        final var expectedName = "Developer";
        final var expectedAcronym = "DEV";
        final Role role = Role.newRole(expectedName, expectedAcronym);

        TeamMember teamMember = TeamMember.newTeamMember(team, user, role);

        Notification notification = Notification.create();
        teamMember.validate(notification);

        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'User' should not be null";
        Assertions.assertEquals(expectedErrorCount, notification.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, notification.getErrors().get(0).message());
    }

    @Test
    public void givenAInvalidTeam_whenCallNewTeamMember_thenInstantiateATeamMember() {
        final User user = User.newUser(true);
        final Team team = null;

        final var expectedName = "Developer";
        final var expectedAcronym = "DEV";
        final Role role = Role.newRole(expectedName, expectedAcronym);

        TeamMember teamMember = TeamMember.newTeamMember(team, user, role);

        Notification notification = Notification.create();
        teamMember.validate(notification);

        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'Team' should not be null";
        Assertions.assertEquals(expectedErrorCount, notification.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, notification.getErrors().get(0).message());
    }

    @Test
    public void givenAInvalidRole_whenCallNewTeamMember_thenInstantiateATeamMember() {
        final User user = User.newUser(true);
        final Team team = Team.newTeam(true);

        final Role role = null;

        TeamMember teamMember = TeamMember.newTeamMember(team, user, role);
        Notification notification = Notification.create();
        teamMember.validate(notification);

        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'Role' should not be null";
        Assertions.assertEquals(expectedErrorCount, notification.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, notification.getErrors().get(0).message());
    }
}
