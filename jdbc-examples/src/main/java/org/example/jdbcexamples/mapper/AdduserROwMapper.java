package org.example.jdbcexamples.mapper;

import org.example.jdbcexamples.dox.Address;
import org.example.jdbcexamples.dox.User;
import org.example.jdbcexamples.dto.AddressUserDTO;
import org.example.jdbcexamples.dto.UserAddressDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AdduserROwMapper implements RowMapper <AddressUserDTO>{


    @Override
    public AddressUserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        var user = User.builder()
                .id(rs.getString("u.id"))
                .name(rs.getString("name"))
                .createTime(rs.getObject("u.create_time", LocalDateTime.class))
                .updateTime(rs.getObject("u.update_time", LocalDateTime.class))
                .build();
        var address = Address.builder()
                .id(rs.getString("a.id"))
                .detail(rs.getString("a.detail"))
                .userId(rs.getString("a.user_id"))
                .createTime(rs.getObject("a.create_time", LocalDateTime.class))
                .updateTime(rs.getObject("a.update_time", LocalDateTime.class))
                .build();

        return AddressUserDTO.builder()
                .user(user)
                .address(address)
                .build();
    }
}
