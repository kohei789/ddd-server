package jp.ddd.server.adapter.gateway.dynamodb.table;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import jp.ddd.server.adapter.gateway.dynamodb.table.base.BaseDyn;
import jp.ddd.server.domain.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by noguchi_kohei 
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@DynamoDBTable(tableName = "user")
public class UserDyn implements BaseDyn {
    private static final long serialVersionUID = 5533582298663995575L;
    public static final String TABLE_NAME = "user";

    @DynamoDBHashKey(attributeName = "user_id")
    private Integer userId;

    @DynamoDBAttribute(attributeName = "login_id")
    @DynamoDBIndexHashKey(globalSecondaryIndexName = "idx_lid")
    private String loginId;

    @DynamoDBAttribute
    private String pass;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private String email;

    @DynamoDBAttribute
    private String tel;

    public static UserDyn create(User user) {
        return UserDyn.builder().email(user.getUserInfo().getEmail()).loginId(user.getLoginId().getId())
          .name(user.getUserInfo().getName()).pass(user.getHashPass().getPass()).tel(user.getUserInfo().getTel())
          .build();
    }
}
