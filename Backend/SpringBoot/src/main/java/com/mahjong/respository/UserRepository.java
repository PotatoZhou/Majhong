package com.mahjong.springboot;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByName(String Name);
    User findById(long id);
}
