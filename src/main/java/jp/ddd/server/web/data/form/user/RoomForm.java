package jp.ddd.server.web.data.form.user;

import jp.ddd.server.other.utils.Msg;
import jp.ddd.server.web.data.Form;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class RoomForm implements Form {
    private static final long serialVersionUID = 1L;

    @NotNull(message = Msg.NOT_NULL)
    private String roomName;

    @NotNull(message = Msg.NOT_NULL)
    private List<Integer> roomUserIdList;
}
