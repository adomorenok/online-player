package com.online.player.service.track.tag;

import com.online.player.dto.track.tag.CreateTagRequest;
import com.online.player.dto.track.tag.TagResponse;
import com.online.player.dto.track.tag.UpdateTagRequest;
import com.online.player.model.track.Tag;
import org.springframework.data.domain.Page;

/**
 * Created by ikota on 11.6.17.
 */
public interface TagService {
    
    Page<TagResponse> getAll(int page, int size);

    TagResponse getById(Long id);

    TagResponse create(CreateTagRequest request);

    TagResponse update(Long id, UpdateTagRequest request);

    void delete(Long id);

    Tag getOrCreate(CreateTagRequest request);

}
