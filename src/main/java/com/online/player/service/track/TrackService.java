package com.online.player.service.track;

import com.online.player.dto.track.create.CreateUpdateTrackRequest;
import com.online.player.dto.track.TrackResponse;
import org.springframework.data.domain.Page;

/**
 * Created by ikota on 11.6.17.
 */
public interface TrackService {

    Page<TrackResponse> getAll(int page, int size);

    TrackResponse getById(Long id);

    TrackResponse create(CreateUpdateTrackRequest request);

    TrackResponse update(Long id, CreateUpdateTrackRequest request);

}
