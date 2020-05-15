package com.example.project.spring_data;

import com.example.project.entity.Room;
import com.example.project.interfces.RoomService;
import com.example.project.repositories.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository("RoomService")
@Transactional
@AllArgsConstructor
public class RoomImpl implements RoomService {
    private final RoomRepository roomRepository;

    public List<Room> findAll() {
        return (List<Room>) roomRepository.findAll();
    }

    public List<Room> findByPlaces(Integer places) {
        return roomRepository.findByPlaces(places);
    }

    public List<Room> findByPrice(Integer price) {
        return roomRepository.findByPrice(price);
    }

    @Override
    public List<Room> findByApartClass(String apartclass) {
        return roomRepository.findByApartClass(apartclass);
    }

    public Optional<Room> findById(Integer id) {
        return roomRepository.findById(id);
    }

    public void deleteById(Integer id) {
        roomRepository.deleteById(id);
    }

    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }
}