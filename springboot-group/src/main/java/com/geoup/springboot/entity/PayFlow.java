package com.geoup.springboot.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

/**
 * @author: lisy
 * @version: PayFlow , v0.1 2021年01月29日 10:33
 * @remark：PayFlow
 */
@Data
@Document("pay_flow")
public class PayFlow {

    @Id
    private String id;

    @Field("user_id")
    private String userId;

    @Field("order_id")
    private String orderId;

    @Field("money")
    private BigDecimal money;
}
