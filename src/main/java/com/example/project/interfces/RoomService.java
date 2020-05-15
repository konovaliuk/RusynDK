package com.example.project.interfces;

import com.example.project.entity.*;

import java.util.List;
import java.util.Optional;


public interface RoomService {
List <Room> findAll();
List <Room> findByPlaces(Integer places);
List <Room> findByPrice(Integer price);
List <Room> findByApartClass(String apartclass);
Optional <Room> findById(Integer id);
void save(Room room);
}
