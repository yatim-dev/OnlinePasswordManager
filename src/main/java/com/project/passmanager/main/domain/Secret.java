package com.project.passmanager.main.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Secret {
    private String id;
    private String name;
}
