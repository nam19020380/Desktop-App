package org.example.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class User {
    private Integer id;

    private String email;

    private String password;

    private String name;
}
