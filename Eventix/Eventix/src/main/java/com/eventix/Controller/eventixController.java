package com.eventix.Controller;
import com.eventix.Model.eventixModel;
import com.eventix.Services.eventixServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class eventixController {

    private final eventixServices service;

    public eventixController(eventixServices service) {
        this.service = service;
    }

    @GetMapping
    public List<eventixModel> getAllEvents() {
        return service.getAllEvents();
    }

    @GetMapping("/{id}")
    public eventixModel getEventById(@PathVariable Long id) {
        return service.getEventById(id);
    }

    @GetMapping("/search")
    public List<eventixModel> getEventsByType(@RequestParam String type) {
        return service.getEventsByType(type);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public eventixModel createEvent(@Valid @RequestBody eventixModel event) {
        return service.createEvent(event);
    }

    @PutMapping("/{id}")
    public eventixModel updateEvent(@PathVariable Long id, @Valid @RequestBody eventixModel event) {
        return service.updateEvent(id, event);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEvent(@PathVariable Long id) {
        service.deleteEvent(id);
    }
}