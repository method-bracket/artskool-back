package com.example.artskool_back.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
@Schema(description = "Contains information about a given site-wide art event.")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "The event's unique ID.")
    private long id;
    @Schema(description = "The starting date and time of the event. (ISO 8601)")
    private LocalDateTime dateTimeFrom;
    @Schema(description = "The ending date and time of the event. (ISO 8601)")
    private LocalDateTime dateTimeTo;
    @Schema(description = "The title of the event, describing its subject.")
    private String subject;
    @Schema(description = "An extended description of the event's subject containing additional information, such as a list of references.")
    private String description;
    @Schema(description = "The URL of the website background used during the event.")
    private String backgroundImgUrl;
    @Schema(description = "The icon of the event, used throughout the website.")
    private String iconUrl;

    public Event() {

    }

    public Event(LocalDateTime dateTimeFrom, LocalDateTime dateTimeTo, String subject, String description, String backgroundImgUrl, String iconUrl) {
        this.dateTimeFrom = dateTimeFrom;
        this.dateTimeTo = dateTimeTo;
        this.subject = subject;
        this.description = description;
        this.backgroundImgUrl = backgroundImgUrl;
        this.iconUrl = iconUrl;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDateTimeFrom() {
        return dateTimeFrom;
    }

    public LocalDateTime getDateTimeTo() {
        return dateTimeTo;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public String getBackgroundImgUrl() {
        return backgroundImgUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDateTimeFrom(LocalDateTime dateTimeFrom) {
        this.dateTimeFrom = dateTimeFrom;
    }

    public void setDateTimeTo(LocalDateTime dateTimeTo) {
        this.dateTimeTo = dateTimeTo;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBackgroundImgUrl(String backgroundImgUrl) {
        this.backgroundImgUrl = backgroundImgUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
