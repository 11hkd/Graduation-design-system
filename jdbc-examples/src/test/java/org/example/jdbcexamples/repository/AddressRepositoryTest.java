package org.example.jdbcexamples.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.jdbcexamples.dox.Address;
import org.example.jdbcexamples.dto.AddressUserDTO;
import org.example.jdbcexamples.dto.UserAddressDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;
    @Test
    void save() {
       for(Address address : addressRepository.findByUserId("1283960607856160768")) log.debug("address: {}", address);
    }

    @Test
    void findByAId() {
        AddressUserDTO addressDTO = addressRepository.findByAId("1283960607856160768");
        log.debug("user: {}", addressDTO.getUser());
        log.debug("address: {}", addressDTO.getAddress());
    }
}