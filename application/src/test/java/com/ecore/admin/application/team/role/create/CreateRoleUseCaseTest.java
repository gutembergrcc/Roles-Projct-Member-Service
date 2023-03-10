package com.ecore.admin.application.team.role.create;

import com.ecore.admin.domain.exceptions.DomainException;
import com.ecore.admin.domain.team.RoleGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Tag("unitTest")
public class CreateRoleUseCaseTest {

    @InjectMocks
    private CreateRoleUseCase useCase;

    @Mock
    private RoleGateway gateway;

    @Test
    public void givenAValidCommand_whenCallsCreateRole_shouldReturnRoleId() {
        final var expectedName = "Developer";
        final var expectedAcronym = "DEV";

        final var aCommand =
                CreateRoleCommand.with(expectedName, expectedAcronym);

        when(gateway.create(any()))
                .thenAnswer(returnsFirstArg());

        final var actualOutput = useCase.execute(aCommand);

        Assertions.assertNotNull(actualOutput);
        Assertions.assertNotNull(actualOutput.id());

        Mockito.verify(gateway, times(1)).create(argThat(role ->
                Objects.equals(expectedName, role.getName())
                        && Objects.equals(expectedAcronym, role.getAcronym())
                        && Objects.nonNull(role.getId())
        ));
    }

    @Test
    public void givenAInvalidName_whenCallsCreateRole_thenShouldReturnDomainException() {
        final String expectedName = null;
        final var expectedAcronym = "DEV";

        final var aCommand =
                CreateRoleCommand.with(expectedName, expectedAcronym);

        Assertions.assertThrows(
                DomainException.class, ()-> useCase.execute(aCommand));
    }

    @Test
    public void givenAInvalidAcronym_whenCallsCreateRole_thenShouldReturnDomainException() {
        final var expectedName = "Developer";
        final String expectedAcronym = null;

        final var aCommand =
                CreateRoleCommand.with(expectedName, expectedAcronym);

        Assertions.assertThrows(
                DomainException.class, ()-> useCase.execute(aCommand));
    }
}
