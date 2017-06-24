package com.online.player.service.track.tag.impl;

import com.online.player.dto.track.tag.CreateTagRequest;
import com.online.player.dto.track.tag.TagResponse;
import com.online.player.dto.track.tag.UpdateTagRequest;
import com.online.player.exception.EntityNotFoundException;
import com.online.player.model.track.Tag;
import com.online.player.repository.track.tag.TagRepository;
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
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Page<TagResponse> getAll(int page, int size) {
        Page<Tag> tagPage = tagRepository.findAll(new PageRequest(page, size));
        return new PageImpl<>(tagPage.getContent().stream().map(TagResponse::new).collect(Collectors.toList()),
                new PageRequest(page, size), tagPage.getTotalElements());
    }

    @Override
    public TagResponse getById(Long id) {
        if (!tagRepository.exists(id)) {
            throw new EntityNotFoundException("Tag is not found.");
        }

        return new TagResponse(tagRepository.findOne(id));
    }

    @Override
    public TagResponse create(CreateTagRequest request) {
        return new TagResponse(tagRepository.save(new Tag()
                .setName(request.getName())));
    }

    @Override
    public TagResponse update(Long id, UpdateTagRequest request) {
        if (!tagRepository.exists(id)) {
            throw new EntityNotFoundException("Tag is not found.");
        }

        return new TagResponse(tagRepository.save(tagRepository.findOne(id)
                .setName(request.getName())));
    }

    @Override
    public void delete(Long id) {
        if (!tagRepository.exists(id)) {
            throw new EntityNotFoundException("Tag is not found.");
        }

        tagRepository.delete(id);
    }

    @Override
    public Tag getOrCreate(CreateTagRequest request) {
        if (request.getId() != null && tagRepository.exists(request.getId())) {
            return tagRepository.findOne(request.getId());
        }

        return tagRepository.save(new Tag()
                .setName(request.getName()));
    }
}
