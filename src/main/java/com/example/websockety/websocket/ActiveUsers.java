package com.example.websockety.websocket;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;

@Component
public class ActiveUsers {

    private Set<String> users;

    public ActiveUsers() {
        this.users = new HashSet<>();
    }

    public void addUser(String username){
        users.add(username);
    }

    public void removeUser(String username){
        users.remove(username);
    }

    public Set<String> getUsers() {
        return users;
    }

    public void setUsers(Set<String> users) {
        this.users = users;
    }

    public int size(){
        return users.size();
    }
}
