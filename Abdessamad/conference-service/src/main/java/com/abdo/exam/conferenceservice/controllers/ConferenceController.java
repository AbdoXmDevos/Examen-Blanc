package com.abdo.exam.conferenceservice.controllers;

import com.abdo.exam.conferenceservice.entities.Conference;
import com.abdo.exam.conferenceservice.entities.Review;
import com.abdo.exam.conferenceservice.services.ConferenceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conferences")
@AllArgsConstructor
public class ConferenceController {
    private ConferenceService conferenceService;

    @GetMapping
    public List<Conference> getAllConferences() {
        return conferenceService.getAllConferences();
    }

    @GetMapping("/{id}")
    public Conference getConference(@PathVariable Long id) {
        return conferenceService.getConference(id);
    }

    @PostMapping
    public Conference saveConference(@RequestBody Conference conference) {
        return conferenceService.saveConference(conference);
    }

    @PostMapping("/{id}/reviews")
    public Conference addReview(@PathVariable Long id, @RequestBody Review review) {
        return conferenceService.addReview(id, review);
    }
}