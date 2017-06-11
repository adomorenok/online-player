package com.online.player.dto.playlist;

import com.online.player.enums.PlaylistType;
import lombok.Data;

/**
 * Created by ikota on 11.6.17.
 */
@Data
public class UpdatePlaylistRequest {

    private String name;
    private PlaylistType type;

}
