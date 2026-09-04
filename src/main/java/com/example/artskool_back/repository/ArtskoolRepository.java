package com.example.artskool_back.repository;

import com.example.artskool_back.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ArtskoolRepository extends JpaRepository<Event, Long> {
    @Query("SELECT * FROM events WHERE end_datetime > NOW() " +
            "ORDER BY CASE WHEN start_datetime <= NOW() THEN 0 ELSE 1 END, " +
            "CASE WHEN start_datetime <= NOW() THEN start_datetime END DESC, " +
            "CASE WHEN start_datetime > NOW() THEN start_datetime END ASC " +
            "LIMIT 1;")
    Optional<Event> findNearestUpcomingEvent();
}
