package com.online.player.service;

import com.online.player.dto.user.CreateUserRequest;
import com.online.player.dto.user.UpdateUserRequest;
import com.online.player.dto.user.UserResponse;
import org.springframework.data.domain.Page;

/**
 * Created by ikota on 3.6.17.
 */
public interface UserService {

    Page<UserResponse> getAll(int page, int size, String email);

    UserResponse getById(Long id);

    UserResponse create(CreateUserRequest request);

    UserResponse update(Long id, UpdateUserRequest request);

    void delete(Long id);
}
