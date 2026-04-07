package com.eventix.Services;

import com.eventix.Model.eventixModel;
import com.eventix.Repository.eventixRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class eventixServices {

    private final eventixRepository repository;

    public eventixServices(eventixRepository repository) {
        this.repository = repository;
    }

    public List<eventixModel> getAllEvents() {
        return repository.findAll();
    }

    public eventixModel getEventById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado con ID: " + id));
    }

    public eventixModel createEvent(eventixModel event) {
        return repository.save(event);
    }

    public eventixModel updateEvent(Long id, eventixModel updatedEvent) {
        eventixModel existingEvent = getEventById(id);
        existingEvent.setName(updatedEvent.getName());
        existingEvent.setType(updatedEvent.getType());
        existingEvent.setDate(updatedEvent.getDate());
        existingEvent.setLocation(updatedEvent.getLocation());
        existingEvent.setCapacity(updatedEvent.getCapacity());
        return repository.save(existingEvent);
    }

    public void deleteEvent(Long id) {
        if (!repository.deleteById(id)) {
            throw new RuntimeException("Evento no encontrado para eliminar con ID: " + id);
        }
    }

    public List<eventixModel> getEventsByType(String type) {
        return repository.findByType(type);
    }
}
