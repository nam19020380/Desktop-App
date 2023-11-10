package org.example.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {
    private Integer id;

    private Integer userId;

    private Integer winCount;

    private Integer loseCount;

    private Integer elo;

    private  Boolean isForgetPassword;
}
