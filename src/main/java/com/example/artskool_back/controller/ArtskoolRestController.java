package com.example.artskool_back.controller;

import com.example.artskool_back.entity.Event;
import com.example.artskool_back.service.ArtskoolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artskool")
public class ArtskoolRestController {
    private final ArtskoolService artskoolService;

    ArtskoolRestController(ArtskoolService artskoolService) {
        this.artskoolService = artskoolService;
    }

    @Operation(description = "Returns the nearest upcoming event, or the ongoing event. " +
            "If two or more events overlap with each other, this will return the ongoing event that started most recently.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "The request did not fail and the nearest upcoming or ongoing event has been returned."
            )
    })
    @GetMapping("/upcoming")
    public ResponseEntity<Event> getNearestUpcomingEvent() {
        Event upcomingEvent = artskoolService.findNearestUpcomingEvent();

        return ResponseEntity.ok(upcomingEvent);
    }
}
