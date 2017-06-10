package com.online.player.resource.user;

import com.online.player.dto.user.CreateUserRequest;
import com.online.player.dto.user.UpdateUserRequest;
import com.online.player.dto.user.UserResponse;
import com.online.player.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ikota on 9.6.17.
 */
@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Page<UserResponse> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                     @RequestParam(value = "size", defaultValue = "10") int size,
                                     @RequestParam(value = "email", required = false) String email) {
        return service.getAll(page, size, email);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public UserResponse getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public UserResponse create(@RequestBody CreateUserRequest request) {
        return service.create(request);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public UserResponse update(@PathVariable("id") Long id,
                               @RequestBody UpdateUserRequest request) {
        return service.update(id, request);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
