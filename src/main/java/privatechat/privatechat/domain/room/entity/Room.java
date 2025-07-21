package privatechat.privatechat.domain.room.entity;

import jakarta.persistence.*;
import privatechat.privatechat.domain.chat.entity.Chat;
import privatechat.privatechat.domain.user.entity.User;

import java.util.List;

@Entity
public class Room {
    @Id
    private Long id;

    @OneToOne
    private Chat firstChat;

    @ManyToMany(mappedBy = "rooms")
    private List<User> users;
}
