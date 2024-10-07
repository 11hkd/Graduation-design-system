package org.example.jdbcexamples.mapper;

import org.example.jdbcexamples.dox.Address;
import org.example.jdbcexamples.dox.User;
import org.example.jdbcexamples.dto.AddressUserDTO;
import org.example.jdbcexamples.dto.UserAddressDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserExtractor implements ResultSetExtractor<UserAddressDTO> {

    @Override
    public UserAddressDTO extractData(ResultSet rs) throws SQLException, DataAccessException {
        User user =null;
        List<Address> addresses = new ArrayList<>();
        while (rs.next()) {
            if(user==null){
                user = User.builder()
                        .id(rs.getString("u.id"))
                        .name(rs.getString("name"))
                        .build();
            }
            Address address = Address.builder()
                    .id(rs.getString("a.id"))
                    .detail(rs.getString("a.detail"))
                    .userId(rs.getString("user_id"))
                    .build();
            addresses.add(address);
        }
        return UserAddressDTO
                    .builder()
                    .user(user)
                    .addresses(addresses)
                    .build();
        }
}
