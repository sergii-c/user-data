package com.wc1.poc.userdata.controller;

import com.wc1.poc.userdata.domain.UserData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class UserDataController {

    private Map<Integer, UserData> users = new HashMap<Integer, UserData>() {{
        put(1, new UserData("John", "Smith", 1));
        put(2, new UserData("George", "Douglas", 1));
    }};

    @GetMapping("/user/{id}")
    @ResponseBody
    public ResponseEntity<UserData> getUser(@PathVariable(name="id") int id) {
        return Optional.ofNullable(users.get(id)).map(u->new ResponseEntity<>(u, HttpStatus.OK)).orElseGet(
                () -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}