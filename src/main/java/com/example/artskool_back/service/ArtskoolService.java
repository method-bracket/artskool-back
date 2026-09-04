package com.example.artskool_back.service;

import com.example.artskool_back.entity.Event;
import com.example.artskool_back.repository.ArtskoolRepository;
import org.springframework.stereotype.Service;

@Service
public class ArtskoolService {
    private final ArtskoolRepository artskoolRepository;

    ArtskoolService(ArtskoolRepository artskoolRepository) {
        this.artskoolRepository = artskoolRepository;
    }

    public Event findNearestUpcomingEvent() {
        return artskoolRepository.findNearestUpcomingEvent().orElseThrow();
    }
}
