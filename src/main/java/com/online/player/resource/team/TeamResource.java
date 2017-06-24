package com.online.player.resource.team;

import com.online.player.dto.team.CreateTeamRequest;
import com.online.player.dto.team.TeamResponse;
import com.online.player.dto.team.UpdateTeamRequest;
import com.online.player.service.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ikota on 11.6.17.
 */
@RestController
@RequestMapping("/teams")
public class TeamResource {

    @Autowired
    private TeamService service;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Page<TeamResponse> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                     @RequestParam(value = "size", defaultValue = "10") int size) {
        return service.getAll(page, size);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TeamResponse getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public TeamResponse create(@RequestBody CreateTeamRequest request) {
        return service.create(request);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public TeamResponse update(@PathVariable("id") Long id,
                               @RequestBody UpdateTeamRequest request) {
        return service.update(id, request);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
