package com.online.player.service.impl;

import com.online.player.dto.user.CreateUserRequest;
import com.online.player.dto.user.UpdateUserRequest;
import com.online.player.dto.user.UserResponse;
import com.online.player.exception.EntityNotFoundException;
import com.online.player.model.user.User;
import com.online.player.repository.user.UserRepository;
import com.online.player.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

/**
 * Created by ikota on 3.6.17.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<UserResponse> getAll(int page, int size, String email) {
        Page<User> userPage = null;
        if (StringUtils.isBlank(email)) {
            userPage = userRepository.findAll(new PageRequest(page, size));
        } else {
            userPage = userRepository.findByEmail("%" + email + "%", new PageRequest(page, size));
        }
        return new PageImpl<>(userPage.getContent().stream().map(UserResponse::new).collect(Collectors.toList()),
                new PageRequest(page, size), userPage.getTotalElements());
    }

    @Override
    public UserResponse getById(Long id) {
        if (!userRepository.exists(id)) {
            throw new EntityNotFoundException("User is not found.");
        }
        return new UserResponse(userRepository.findOne(id));
    }

    @Override
    public UserResponse create(CreateUserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        return new UserResponse(userRepository.save(user));
    }

    @Override
    public UserResponse update(Long id, UpdateUserRequest request) {
        if (!userRepository.exists(id)) {
            throw new EntityNotFoundException("User is not found.");
        }

        User user = userRepository.findOne(id);
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        return new UserResponse(userRepository.save(user));
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.exists(id)) {
            throw new EntityNotFoundException("User is not found.");
        }

        userRepository.delete(id);
    }

}
