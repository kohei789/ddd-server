package jp.ddd.server.domain.model.message;

import jp.ddd.server.domain.model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The persistent class for the message database table.
 */
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@NamedQueries({
  @NamedQuery(name = "Message.findByRoomId", query = "SELECT m FROM Message m WHERE m.roomId=:rid AND m.deleted=0") })
public class Message extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private byte deleted;

    @Embedded
    private MessageDt messageDt;

    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "user_id")
    private Integer userId;

}