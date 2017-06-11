package com.online.player.repository.user;

import com.online.player.model.user.User;
import com.online.player.repository.BaseRepository;

/**
 * Created by ikota on 3.6.17.
 */
public interface UserRepository extends BaseRepository<User> {

    User findByEmail(String email);

}
