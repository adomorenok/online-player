package com.online.player.dto.track.create;

import lombok.Data;

/**
 * Created by ikota on 11.6.17.
 */
@Data
public class CreateUpdateTrackRequest {

    private String name;
    private CreateUpdateAuthorTrackRequest author;
    private CreateUpdateAlbumTrackRequest album;

}
