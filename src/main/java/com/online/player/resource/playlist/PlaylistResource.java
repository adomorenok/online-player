package com.online.player.resource.playlist;

import com.online.player.dto.playlist.CreatePlaylistRequest;
import com.online.player.dto.playlist.PlaylistResponse;
import com.online.player.dto.playlist.UpdatePlaylistRequest;
import com.online.player.service.playlist.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ikota on 11.6.17.
 */
@RestController
@RequestMapping("/playlists")
public class PlaylistResource {

    @Autowired
    private PlaylistService service;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Page<PlaylistResponse> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                         @RequestParam(value = "size", defaultValue = "10") int size) {
        return service.getAll(page, size);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PlaylistResponse getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public PlaylistResponse create(@RequestBody CreatePlaylistRequest request) {
        return service.create(request);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public PlaylistResponse update(@PathVariable("id") Long id,
                                   @RequestBody UpdatePlaylistRequest request) {
        return service.update(id, request);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Long id) {
        service.delete(id);
    }


}
