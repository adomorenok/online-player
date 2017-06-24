package com.online.player.dto.track.create;

import com.online.player.dto.track.tag.CreateTagRequest;
import lombok.Data;

import java.util.Set;

/**
 * Created by ikota on 11.6.17.
 */
@Data
public class CreateUpdateAuthorTrackRequest {

    private Long id;
    private String name;
    private Set<CreateTagRequest> tags;

}
