package privatechat.privatechat.domain.chat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import privatechat.privatechat.domain.room.entity.Room;

@Entity
public class Chat {
    //UUID
    @Id
    String id;
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    Room room;

    String previousChatId;
    String nextChatId;

    String cipherText;
}
