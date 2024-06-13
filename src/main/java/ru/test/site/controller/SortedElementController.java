package ru.test.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.test.site.model.SortedElement;
import ru.test.site.repository.SortedElementRepository;

@RestController
public class SortedElementController {
    @Autowired
    private SortedElementRepository sortedElementRepository;
    @PostMapping("/sorted-element")
    public SortedElement create(@RequestBody SortedElement sortedElement) {
        return sortedElementRepository.save(sortedElement);
    }
}
