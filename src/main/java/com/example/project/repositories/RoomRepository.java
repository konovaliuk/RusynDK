package com.example.project.repositories;

import com.example.project.entity.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Integer> {
    List<Room> findByPlaces(Integer places);

    List<Room> findByPrice(Integer price);

    List<Room> findByApartClass(String apartclass);
}
