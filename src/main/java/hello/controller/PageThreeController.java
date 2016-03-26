package hello.controller;

import hello.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagethree")
public class PageThreeController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> get(){
        return new ResponseEntity<User>(new User(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody User user){
        return new ResponseEntity<User>(new User(), HttpStatus.OK);
    }
}
