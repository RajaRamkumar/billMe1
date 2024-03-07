package com.eviden.billMe.controller;

import com.eviden.billMe.entity.BillMeSkill;
import com.eviden.billMe.entity.BillMeUser;
import com.eviden.billMe.exception.ResourceNotFoundException;
import com.eviden.billMe.exception.UserNotFoundException;
import com.eviden.billMe.repository.BillMeUserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/billMeUser")
public class BillMeUserController {

    @Autowired
    private BillMeUserRepository billMeUserRepository;

    @GetMapping("/jenkinsdemo")
    public String jenkinsdemo(){
        return "jenkinsdemo";
    }

    @GetMapping("/login")
    public BillMeUser billMeUserLogin(@RequestParam("userName") String userName,
                                      @RequestParam("password") String password){
        BillMeUser billMeUser = billMeUserRepository.findByUserName(userName);
        if(billMeUser == null){
            throw new UserNotFoundException("Invalid UserName OR Password");
        }
        return billMeUser;
    }

    @GetMapping("/usersRes")
    public ResponseEntity< List < BillMeUser >> users() {
        List < BillMeUser > users = new ArrayList< >();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "UserController");
        headers.add("Date",LocalDate.now().plusMonths(1).toString());
        //return ResponseEntity.status(203).body(users);
        return ResponseEntity.accepted().headers(headers).body(users);
    }


    @GetMapping("/users")
    public List<BillMeUser> billMeUserList(){
        return billMeUserRepository.findAll();
    }

    @GetMapping("/userss")
    public List<BillMeUser> billMeUserList1(BillMeUser billMeUser){
        System.out.println("am in Request");
        return billMeUserRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<BillMeUser> userList(@PathVariable("id") String id){
        return billMeUserRepository.findById(Integer.parseInt(id));
    }

    @PostMapping("/users")
    public BillMeUser createUser(@RequestBody @Valid BillMeUser billMeUser){
        return billMeUserRepository.save(billMeUser);
    }

    @PutMapping("/users/data")
    private void update(@RequestParam("id") String id,
                          @RequestParam("file") MultipartFile file,
                        @RequestParam("contactNo") String contactNo,
                        @RequestParam("billMeSkill") BillMeSkill billMeSkill) throws IOException {
        Optional<BillMeUser> billMeUser = billMeUserRepository.findById(Integer.parseInt(id));
        billMeUser.get().setResume(file.getBytes());
        billMeUser.get().setContactNo(contactNo);
        billMeUser.get().setBillMeSkill(billMeSkill);
        billMeUserRepository.save(billMeUser.get());
    }

}