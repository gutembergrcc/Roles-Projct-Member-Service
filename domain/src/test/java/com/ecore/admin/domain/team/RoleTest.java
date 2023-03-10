package com.ecore.admin.domain.team;

import com.ecore.admin.domain.exceptions.DomainException;
import com.ecore.admin.domain.validation.Notification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoleTest {

    @Test
    public void givenAValidParams_whenCallNewRole_thenInstantiateARole() {
        final var expectedName = "Developer";
        final var expectedAcronym = "DEV";

        final var actualRole = Role.newRole(expectedName, expectedAcronym);

        Assertions.assertNotNull(actualRole);
        Assertions.assertNotNull(actualRole.getId());
        Assertions.assertEquals(expectedName, actualRole.getName());
        Assertions.assertEquals(expectedAcronym, actualRole.getAcronym());
    }

    @Test
    public void givenAnInvalidNullName_whenCallNewRoleyAndValidate_thenShouldReceiveError() {
        final String expectedName = null;
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' should not be null";
        final var expectedAcronym = "DEV";

        final var actualRole = Role.newRole(expectedName, expectedAcronym);

        Notification notification = Notification.create();
        actualRole.validate(notification);

        Assertions.assertEquals(expectedErrorCount, notification.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, notification.getErrors().get(0).message());
    }

    @Test
    public void givenAnEmptyName_whenCallNewRoleyAndValidate_thenShouldReceiveError() {
        final String expectedName = " ";
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' should not be empty";
        final var expectedAcronym = "DEV";

        final var actualRole = Role.newRole(expectedName, expectedAcronym);

        Notification notification = Notification.create();
        actualRole.validate(notification);

        Assertions.assertEquals(expectedErrorCount, notification.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, notification.getErrors().get(0).message());
    }

    @Test
    public void givenAInvalidName_whenCallNewRoleyAndValidate_thenShouldReceiveError() {
        final String expectedName = "Te ";
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' must be between 3 and 255 characters";
        final var expectedAcronym = "DEV";

        final var actualRole = Role.newRole(expectedName, expectedAcronym);

        Notification notification = Notification.create();
        actualRole.validate(notification);

        Assertions.assertEquals(expectedErrorCount, notification.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, notification.getErrors().get(0).message());
    }

    @Test
    public void givenAInvalidNameMore255Chars_whenCallNewRoleyAndValidate_thenShouldReceiveError() {
        final String expectedName = """
                xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                """;
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' must be between 3 and 255 characters";
        final var expectedAcronym = "DEV";

        final var actualRole = Role.newRole(expectedName, expectedAcronym);

        Notification notification = Notification.create();
        actualRole.validate(notification);

        Assertions.assertEquals(expectedErrorCount, notification.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, notification.getErrors().get(0).message());
    }

    @Test
    public void givenAnInvalidNullAcronym_whenCallNewRoleyAndValidate_thenShouldReceiveError() {
        final String expectedName = "Developer";
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'acronym' should not be null";
        final String expectedAcronym = null;

        final var actualRole = Role.newRole(expectedName, expectedAcronym);

        Notification notification = Notification.create();
        actualRole.validate(notification);

        Assertions.assertEquals(expectedErrorCount, notification.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, notification.getErrors().get(0).message());
    }

    @Test
    public void givenAnInvalidEmptyAcronym_whenCallNewRoleyAndValidate_thenShouldReceiveError() {
        final String expectedName = "Developer";
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'acronym' should not be empty";
        final String expectedAcronym = " ";

        final var actualRole = Role.newRole(expectedName, expectedAcronym);

        Notification notification = Notification.create();
        actualRole.validate(notification);

        Assertions.assertEquals(expectedErrorCount, notification.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, notification.getErrors().get(0).message());
    }

    @Test
    public void givenAnInvalidAcronymLess3_whenCallNewRoleyAndValidate_thenShouldReceiveError() {
        final String expectedName = "Developer";
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'acronym' must be between 3 and 30 characters";
        final String expectedAcronym = "D";

        final var actualRole = Role.newRole(expectedName, expectedAcronym);

        Notification notification = Notification.create();
        actualRole.validate(notification);

        Assertions.assertEquals(expectedErrorCount, notification.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, notification.getErrors().get(0).message());
    }

    @Test
    public void givenAnInvalidAcronymMore30_whenCallNewRoleyAndValidate_thenShouldReceiveError() {
        final String expectedName = "Developer";
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'acronym' must be between 3 and 30 characters";
        final String expectedAcronym = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

        final var actualRole = Role.newRole(expectedName, expectedAcronym);

        Notification notification = Notification.create();
        actualRole.validate(notification);

        Assertions.assertEquals(expectedErrorCount, notification.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, notification.getErrors().get(0).message());
    }
}
