package com.online.player.resource.track;

import com.online.player.dto.track.TrackResponse;
import com.online.player.dto.track.create.CreateUpdateTrackRequest;
import com.online.player.service.track.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ikota on 11.6.17.
 */
@RestController
@RequestMapping("/tracks")
public class TrackResource {

    @Autowired
    private TrackService service;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Page<TrackResponse> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                      @RequestParam(value = "size", defaultValue = "10") int size) {
        return service.getAll(page, size);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TrackResponse getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public TrackResponse create(@RequestBody CreateUpdateTrackRequest request) {
        return service.create(request);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public TrackResponse update(@PathVariable("id") Long id,
                                @RequestBody CreateUpdateTrackRequest request) {
        return service.update(id, request);
    }

}
