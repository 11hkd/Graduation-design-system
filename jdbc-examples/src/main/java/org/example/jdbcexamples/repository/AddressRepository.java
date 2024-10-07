package org.example.jdbcexamples.repository;

import org.example.jdbcexamples.dox.Address;
import org.example.jdbcexamples.dto.AddressUserDTO;
import org.example.jdbcexamples.dto.UserAddressDTO;
import org.example.jdbcexamples.mapper.AdduserROwMapper;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
    @Query("""
        select * from address a where a.user_id = :userId
""")
    List<Address> findByUserId(String userId);
@Query
        (value= """
select * from address a,user u
where a.user_id=u.id and a.id='2222';
""",
        rowMapperClass = AdduserROwMapper.class)
AddressUserDTO findByAId(String aid);
}
