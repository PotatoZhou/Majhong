package com.mahjong.springboot;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("select users from ")
    User findByName(String Name);
    User findById(long id);
}
