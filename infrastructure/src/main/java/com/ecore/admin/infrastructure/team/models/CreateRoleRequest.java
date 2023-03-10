package com.ecore.admin.infrastructure.team.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateRoleRequest(@JsonProperty("name") String name,
                                @JsonProperty("acronym") String acronym) {
}
