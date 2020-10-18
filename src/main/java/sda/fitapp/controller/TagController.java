package sda.fitapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sda.fitapp.entity.Tag;
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
    public Tag addTag(@RequestBody Tag tag){
        return tagRepository.save(tag);
    }
    @GetMapping
    public List<Tag> getAllTags(){
        return tagRepository.findAll();
    }
    @GetMapping("/api/tag/{id}")
    public Tag getTagById(@RequestParam Long id){
        return tagRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
    @GetMapping("/api/tag/{name}")
    public Tag getTagByName(@RequestParam String name){
        return tagRepository.findFirstByName(name).orElseThrow(NoSuchElementException::new);
    }


}
