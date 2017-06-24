package com.online.player.service.playlist.impl;

import com.online.player.dto.playlist.CreatePlaylistRequest;
import com.online.player.dto.playlist.PlaylistResponse;
import com.online.player.dto.playlist.UpdatePlaylistRequest;
import com.online.player.exception.EntityNotFoundException;
import com.online.player.model.playlist.Playlist;
import com.online.player.repository.playlist.PlaylistRepository;
import com.online.player.service.playlist.PlaylistService;
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
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public Page<PlaylistResponse> getAll(int page, int size) {
        Page<Playlist> playlistPage = playlistRepository.findAll(new PageRequest(page, size));
        return new PageImpl<>(playlistPage.getContent().stream().map(PlaylistResponse::new).collect(Collectors.toList()),
                new PageRequest(page, size), playlistPage.getTotalElements());
    }

    @Override
    public PlaylistResponse getById(Long id) {
        if (!playlistRepository.exists(id)) {
            throw new EntityNotFoundException("Playlist is not found.");
        }
        return new PlaylistResponse(playlistRepository.findOne(id));
    }

    @Override
    public PlaylistResponse create(CreatePlaylistRequest request) {
        return new PlaylistResponse(playlistRepository.save(new Playlist()
                        .setName(request.getName())
                        .setType(request.getType())
                // .setCreator()
        ));

    }

    @Override
    public PlaylistResponse update(Long id, UpdatePlaylistRequest request) {
        if (!playlistRepository.exists(id)) {
            throw new EntityNotFoundException("Playlist is not found.");
        }

        return new PlaylistResponse(playlistRepository.save(playlistRepository.findOne(id)
                .setName(request.getName())
                .setType(request.getType())));
    }

    @Override
    public void delete(Long id) {
        if (!playlistRepository.exists(id)) {
            throw new EntityNotFoundException("Playlist is not found.");
        }

        playlistRepository.delete(id);
    }
}
