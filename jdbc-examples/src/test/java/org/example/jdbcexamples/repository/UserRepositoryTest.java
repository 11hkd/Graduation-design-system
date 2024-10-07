package org.example.jdbcexamples.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.jdbcexamples.dox.Address;
import org.example.jdbcexamples.dox.User;
import org.example.jdbcexamples.dto.UserAddressDTO;
import org.example.jdbcexamples.dto.UserCountDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    void save(){
    var user = User
            .builder()
            .name("test")
            .build();
    userRepository.save(user);
}

    @Test
    void findUserWithAddress() {
        UserAddressDTO byUserId= userRepository.findByUserId("1283960607856160768");
for(Address address : byUserId.getAddresses())
    log.debug(address.toString());
    }

    @Test
    void findCounts() {

        for(UserCountDTO count: userRepository.findCounts())
            log.debug(count.toString());
    }
}