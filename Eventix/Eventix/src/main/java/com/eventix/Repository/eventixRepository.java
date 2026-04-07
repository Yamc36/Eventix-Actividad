package com.eventix.Repository;

import com.eventix.Model.eventixModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class eventixRepository {

    private final List<eventixModel> events = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    public List<eventixModel> findAll() {
        return events;
    }

    public Optional<eventixModel> findById(Long id) {
        return events.stream().filter(e -> e.getId() != null && e.getId().equals(id)).findFirst();
    }

    public eventixModel save(eventixModel event) {
        if (event.getId() == null) {
            event.setId(counter.getAndIncrement());
            events.add(event);
        } else {
            // Actualizar si ya existe
            events.removeIf(e -> e.getId() != null && e.getId().equals(event.getId()));
            events.add(event);
        }
        return event;
    }

    public boolean deleteById(Long id) {
        return events.removeIf(e -> e.getId().equals(id));
    }
    
    // Operación de procesamiento: buscar subconjunto por tipo de evento
    public List<eventixModel> findByType(String type) {
        return events.stream()
                .filter(e -> e.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }
}
