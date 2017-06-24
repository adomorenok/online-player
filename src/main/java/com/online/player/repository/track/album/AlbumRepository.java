package com.online.player.repository.track.album;

import com.online.player.model.track.Album;
import com.online.player.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by ikota on 11.6.17.
 */
public interface AlbumRepository extends BaseRepository<Album> {

    @Query("select t.album from Track t where t.author.id = :authorId")
    List<Album> findByAuthorId(@Param("authorId") Long authorId);

}
