package com.example.artskool_back.service;

import com.example.artskool_back.entity.Event;
import com.example.artskool_back.repository.ArtskoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtskoolService {
    private final ArtskoolRepository artskoolRepository;

    ArtskoolService(ArtskoolRepository artskoolRepository) {
        this.artskoolRepository = artskoolRepository;
    }

    public List<Event> findAllEvents() {
        return artskoolRepository.findAll();
    }

    public Event findNearestUpcomingEvent() {
        return artskoolRepository.findNearestUpcomingEvent().orElseThrow();
    }

    public Event findLastFinishedEvent() {
        return artskoolRepository.findLastFinishedEvent().orElseThrow();
    }
}
