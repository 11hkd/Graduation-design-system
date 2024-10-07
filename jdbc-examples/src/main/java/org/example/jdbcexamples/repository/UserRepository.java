package org.example.jdbcexamples.repository;

import org.example.jdbcexamples.dto.UserAddressDTO;
import org.example.jdbcexamples.dto.UserCountDTO;
import org.example.jdbcexamples.mapper.UserExtractor;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.example.jdbcexamples.dox.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User, String>{
    @Query(value="""
        select * from user u join address a
        on u.id=a.user_id
        where u.id='1283960607856160768';
""",
        resultSetExtractorClass = UserExtractor.class)
        UserAddressDTO findByUserId(String uid);

@Query(value="""
        select u.id as user_id, count(a.id) as address_count
        from user u left join address a
        on u.id=a.user_id
        group by u.id;""")
    List<UserCountDTO> findCounts();

}
