package sda.fitapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sda.fitapp.entity.TagEntity;
import sda.fitapp.repository.TagRepository;
import sda.fitapp.service.TagService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/tag")
public class TagController {
    TagService tagService;
    TagRepository tagRepository;

    @Autowired
    public TagController(TagService tagService, TagRepository tagRepository) {
        this.tagService = tagService;
        this.tagRepository = tagRepository;
    }

    @PostMapping
    public TagEntity addTag(@RequestBody TagEntity tagEntity) {
        return tagRepository.save(tagEntity);
    }

    @GetMapping
    public List<TagEntity> getAllTags() {
        return tagRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public TagEntity getTagById(@PathVariable Long id) {
        return tagRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @GetMapping("/name/{name}")
    public TagEntity getTagByName(@PathVariable String name) {
        return tagRepository.findFirstByName(name).orElseThrow(NoSuchElementException::new);
    }


}
