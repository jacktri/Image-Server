package hello.controller;

import hello.command.RequestWrapper;
import hello.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heck")
public class PageOneController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> get(){
        RequestWrapper k = new RequestWrapper();
        return new ResponseEntity<RequestWrapper>(k, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody String input){
        System.out.println(input);
        RequestWrapper k = new RequestWrapper();
        return new ResponseEntity<RequestWrapper>(k, HttpStatus.OK);
    }
}
