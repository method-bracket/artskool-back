package com.example.artskool_back.repository;

import com.example.artskool_back.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ArtskoolRepository extends JpaRepository<Event, Long> {
    @NativeQuery(value = "SELECT * FROM event e " +
            "WHERE e.date_time_to > CURRENT_TIMESTAMP " +
            "ORDER BY " +
            "CASE WHEN e.date_time_from <= CURRENT_TIMESTAMP THEN 0 " +
            "ELSE 1 " +
            "END, " +
            "CASE WHEN e.date_time_from <= CURRENT_TIMESTAMP THEN e.date_time_from " +
            "END DESC, " +
            "CASE WHEN e.date_time_from > CURRENT_TIMESTAMP THEN e.date_time_from " +
            "END ASC " +
            "LIMIT 1")
    Optional<Event> findNearestUpcomingEvent();
}
