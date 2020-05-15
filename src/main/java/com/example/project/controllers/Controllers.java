package com.example.project.controllers;

import com.example.project.entity.Request;
import com.example.project.entity.User;
import com.example.project.services.RequestServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class Controllers {
    private final RequestServiceImpl requestService;

    @GetMapping(value = "/request")
    public ResponseEntity<?> getRequest() {
        return ResponseEntity.ok(requestService.getRequest());
    }

    @PostMapping(value = "/request")
    public ResponseEntity<Object>
    addRequest(@RequestParam Timestamp checkin, Timestamp checkout, Integer places, String apartclass, Integer userId) {
        requestService.addRequest(checkin, checkout, places, apartclass, userId);
        return new ResponseEntity<>("Request added successfully", HttpStatus.CREATED);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<User>
    getUsers() {
        return new ResponseEntity(requestService.getUsers(), HttpStatus.OK);
    }


    @PostMapping(value = "/request")
    public ResponseEntity<Object>
    createRequestItem(@RequestBody Request request) {
        requestService.createRequestItem(request);
        return new ResponseEntity<>("Request is created successfully",
                HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/request/delete/{id}")
    public ResponseEntity<Object>
    deleteRequestItem(@PathVariable("id") Integer id) {
        requestService.deleteRequestItem(id);
        return new ResponseEntity<>("Request is deleted successfully" + "\n" +
                requestService.getRequest(), HttpStatus.OK);
    }

    @PutMapping(value = "/request/update/{id}")
    public ResponseEntity<Object>
    updateRequestItem(@PathVariable("id") Integer id, @RequestBody Request request) {
        requestService.updateFullRequestItem(id, request);
        return new ResponseEntity<>("Request is updated successsfully",
                HttpStatus.OK);
    }
}