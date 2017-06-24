package com.online.player.service.track.author;

import com.online.player.dto.track.author.AuthorResponse;
import com.online.player.dto.track.create.CreateUpdateAuthorTrackRequest;
import com.online.player.model.track.Author;
import org.springframework.data.domain.Page;

/**
 * Created by ikota on 11.6.17.
 */
public interface AuthorService {

    Author getOrCreate(CreateUpdateAuthorTrackRequest request);

    Page<AuthorResponse> getAll(int page, int size);

}
