package hello.application_service;

import hello.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ConsumeRest {

    public void consume(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User[]> users = restTemplate.getForEntity("http://localhost:8081/bye", User[].class);
        User[] userList = users.getBody();
        System.out.println(userList[0].getUser());
    }
    public void produce(){
        User user = new User("jock", "dock", true);
        RestTemplate restTemplate = new RestTemplate();
        User result = restTemplate.postForObject("http://localhost:8081/",user,User.class);
        System.out.println(result);
    }
}
