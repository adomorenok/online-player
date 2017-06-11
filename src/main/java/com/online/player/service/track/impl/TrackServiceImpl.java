package com.online.player.service.track.impl;

import com.online.player.dto.track.TrackResponse;
import com.online.player.dto.track.create.CreateUpdateTrackRequest;
import com.online.player.exception.EntityNotFoundException;
import com.online.player.model.track.Track;
import com.online.player.repository.track.TrackRepository;
import com.online.player.service.track.TrackService;
import com.online.player.service.track.album.AlbumService;
import com.online.player.service.track.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created by ikota on 11.6.17.
 */
@Service
public class TrackServiceImpl implements TrackService {

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AlbumService albumService;

    @Override
    public Page<TrackResponse> getAll(int page, int size) {
        Page<Track> userPage = trackRepository.findAll(new PageRequest(page, size));
        return new PageImpl<>(userPage.getContent().stream().map(TrackResponse::new).collect(Collectors.toList()),
                new PageRequest(page, size), userPage.getTotalElements());
    }

    @Override
    public TrackResponse getById(Long id) {
        if (!trackRepository.exists(id)) {
            throw new EntityNotFoundException("Track is not found.");
        }

        return new TrackResponse(trackRepository.findOne(id));
    }

    @Override
    public TrackResponse create(CreateUpdateTrackRequest request) {
        return new TrackResponse(trackRepository.save(new Track()
                .setName(request.getName())
                .setAuthor(authorService.getOrCreate(request.getAuthor()))
                .setAlbum(albumService.getOrCreate(request.getAlbum()))));
    }

    @Override
    public TrackResponse update(Long id, CreateUpdateTrackRequest request) {
        if (!trackRepository.exists(id)) {
            throw new EntityNotFoundException("Track is not found.");
        }

        return new TrackResponse(trackRepository.save(trackRepository.findOne(id)
                .setName(request.getName())
                .setAuthor(authorService.getOrCreate(request.getAuthor()))
                .setAlbum(albumService.getOrCreate(request.getAlbum()))));
    }

}
