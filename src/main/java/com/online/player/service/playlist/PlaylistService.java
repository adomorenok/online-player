package com.online.player.service.playlist;

import com.online.player.dto.playlist.CreatePlaylistRequest;
import com.online.player.dto.playlist.PlaylistResponse;
import com.online.player.dto.playlist.UpdatePlaylistRequest;
import org.springframework.data.domain.Page;

/**
 * Created by ikota on 11.6.17.
 */
public interface PlaylistService {

    Page<PlaylistResponse> getAll(int page, int size);

    PlaylistResponse getById(Long id);

    PlaylistResponse create(CreatePlaylistRequest request);

    PlaylistResponse update(Long id, UpdatePlaylistRequest request);

    void delete(Long id);

}
