package com.zhengxiang.reservation.commonPOJO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminUser implements Serializable {

    private String username;
    private String password;
}
