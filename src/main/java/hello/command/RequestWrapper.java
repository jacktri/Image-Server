package hello.command;

import hello.domain.User;

import java.util.List;

public class RequestWrapper {

    List<User> wards;
    String heck;

    public List<User> getWards() {
        return wards;
    }

    public void setWards(List<User> wards) {
        this.wards = wards;
    }

    public String getHeck() {
        return heck;
    }

    public void setHeck(String heck) {
        this.heck = heck;
    }
}
