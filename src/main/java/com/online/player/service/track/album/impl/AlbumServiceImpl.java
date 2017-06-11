package com.online.player.service.track.album.impl;

import com.online.player.dto.track.album.AlbumResponse;
import com.online.player.dto.track.create.CreateUpdateAlbumTrackRequest;
import com.online.player.model.track.Album;
import com.online.player.repository.track.album.AlbumRepository;
import com.online.player.service.track.album.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ikota on 11.6.17.
 */
@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public Album getOrCreate(CreateUpdateAlbumTrackRequest request) {
        if (request.getId() != null && albumRepository.exists(request.getId())) {
            return albumRepository.findOne(request.getId());
        }

        return albumRepository.save(new Album()
                .setName(request.getName()));
    }

    @Override
    public List<AlbumResponse> getByAuthorId(Long authorId) {
        return albumRepository.findByAuthorId(authorId).stream().map(AlbumResponse::new).collect(Collectors.toList());
    }
}
