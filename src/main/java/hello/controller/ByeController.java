package hello.controller;

import hello.command.RequestWrapper;
import hello.command.RequestWrapper2;
import hello.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bye")
public class ByeController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> get(){
        List<User> users = new ArrayList<>();
        User user = new User("joe","jopp5555", true);
        User user2 = new User("joe","jopp5555", true);
        User user3 = new User("joe","jopp5555", true);
        users.add(user);
        users.add(user2);
        users.add(user3);
        RequestWrapper2 k = new RequestWrapper2();
        k.setWards(users);
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
}
