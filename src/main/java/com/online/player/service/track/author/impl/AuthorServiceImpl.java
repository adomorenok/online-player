package com.online.player.service.track.author.impl;

import com.online.player.dto.track.author.AuthorResponse;
import com.online.player.dto.track.create.CreateUpdateAuthorTrackRequest;
import com.online.player.model.track.Author;
import com.online.player.repository.track.author.AuthorRepository;
import com.online.player.service.track.author.AuthorService;
import com.online.player.service.track.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created by ikota on 11.6.17.
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private TagService tagService;

    @Override
    public Author getOrCreate(CreateUpdateAuthorTrackRequest request) {
        if (request.getId() != null && authorRepository.exists(request.getId())) {
            return authorRepository.findOne(request.getId());
        }

        return authorRepository.save(new Author()
                .setName(request.getName())
                .setTags(request.getTags().stream().map(tagService::getOrCreate).collect(Collectors.toSet())));
    }

    @Override
    public Page<AuthorResponse> getAll(int page, int size) {
        Page<Author> authorPage = authorRepository.findAll(new PageRequest(page, size));
        return new PageImpl<>(authorPage.getContent().stream().map(AuthorResponse::new).collect(Collectors.toList()),
                new PageRequest(page, size), authorPage.getTotalElements());
    }
}
