package com.example.project.services;

import com.example.project.entity.Bill;
import com.example.project.entity.Request;
import com.example.project.entity.Room;
import com.example.project.entity.User;
import com.example.project.interfces.BillService;
import com.example.project.interfces.RequestService;
import com.example.project.interfces.RoomService;
import com.example.project.interfces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Transactional
@Service
@AllArgsConstructor
public class RequestServiceImpl {
    private final UserService userService;
    private final RoomService roomService;
    private final RequestService requestService;
    private final BillService billService;

    public void createRequestItem(Request request) {
        requestService.save(request);
    }

    public void addRequest(Timestamp checkin, Timestamp checkout, Integer places, String apartclass, Integer userId) {

        User client = userService.findByUserId(userId).orElseThrow();
        Request request = new Request();
        request.setPlaces(places);
        request.setApartclass(apartclass);
        request.setCheckin(checkin);
        request.setCheckout(checkout);
        request.setClient(client);
        requestService.save(request);
    }


    public void addBill(Integer userId, Integer adminId, Room room) {
        int price = room.getPrice();
        User client = userService.findByUserId(userId).orElseThrow();
        User admin = userService.findByUserId(adminId).orElseThrow();
        Bill bill = new Bill();
        Timestamp localtime = new Timestamp(System.currentTimeMillis());
        bill.setClient(client);
        bill.setAdmin(admin);
        bill.setSum(price);
        bill.setBillDate(localtime);
        billService.save(bill);
    }

    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return userService.findAll();
    }

    public void updateFullRequetItem(Integer id, Request request) {
        Request request_ = requestService.findById(id).orElseThrow();
    }


    public void deleteRequestItem(Integer id) {
        requestService.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Request> getRequest() {
        return requestService.findAll();
    }

    public void updateFullRequestItem(Integer id, Request request) {
    }
}
