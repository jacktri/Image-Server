package hello.controller;

import hello.command.RequestWrapper;
import hello.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> get() {
        RequestWrapper k = new RequestWrapper();
        k.setHeck("whacky");
        List<User> users = new ArrayList<>();
        User u1 = new User();
        u1.setPassword("rock");
        u1.setUser("jack");
        u1.setAccess(true);
        User u2 = new User();
        u2.setPassword("rock22");
        u2.setUser("jack22");
        u2.setAccess(true);
        users.add(u2);
        users.add(u1);
        k.setWards(users);

        return new ResponseEntity<RequestWrapper>(k, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody User input) {

        System.out.println(input.getUser());
        RequestWrapper k = new RequestWrapper();
        k.setHeck("yyyy");
        List<User> users = new ArrayList<>();
        User u1 = new User();
        u1.setPassword("yyyy");
        u1.setUser("jyyyy");
        u1.setAccess(true);
        User u2 = new User();
        u2.setPassword("yyyy");
        u2.setUser("yyyy");
        u2.setAccess(true);
        users.add(u2);
        users.add(u1);
        k.setWards(users);
        return new ResponseEntity<RequestWrapper>(k, HttpStatus.CREATED);
}
}