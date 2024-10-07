package org.example.jdbcexamples.dox;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AddressUser {
    private String id;
    private String name;
    private String detail;
    private String userId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
