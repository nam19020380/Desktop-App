package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
public class Friendship {
    private Integer id;

    User user;

    private Integer friendId;

    private int side;

    Date date;

    public Friendship(User user, Integer friendId, int side, Date date) {
        this.user = user;
        this.friendId = friendId;
        this.side = side;
        this.date = date;
    }
}
