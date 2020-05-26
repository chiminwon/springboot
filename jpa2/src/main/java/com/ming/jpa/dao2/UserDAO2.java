package com.ming.jpa.dao2;

import com.ming.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface UserDAO2 extends JpaRepository<User, Long> {

    List<User> getUserByAddressEqualsAndIdLessThanEqual(String address, Long id);

    @Query(value = "select * from t_user where id=(select max(id) from t_user)", nativeQuery = true)
    User maxIdUser();
}
