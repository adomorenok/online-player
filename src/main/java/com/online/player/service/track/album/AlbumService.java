package com.online.player.service.track.album;

import com.online.player.dto.track.album.AlbumResponse;
import com.online.player.dto.track.create.CreateUpdateAlbumTrackRequest;
import com.online.player.model.track.Album;

import java.util.List;

/**
 * Created by ikota on 11.6.17.
 */
public interface AlbumService {

    Album getOrCreate(CreateUpdateAlbumTrackRequest request);

    List<AlbumResponse> getByAuthorId(Long authorId);

}
