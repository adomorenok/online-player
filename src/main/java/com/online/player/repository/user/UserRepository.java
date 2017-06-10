package com.online.player.repository.user;

import com.online.player.model.user.User;
import com.online.player.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by ikota on 3.6.17.
 */
public interface UserRepository extends BaseRepository<User> {

    @Query("select u from User u where u.email like :email")
    Page<User> findByEmail(@Param("email") String email, Pageable pageable);

}
