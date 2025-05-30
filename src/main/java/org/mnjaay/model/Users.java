package org.mnjaay.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Users implements Serializable {
    private static final long serialVersionUID = 5684699198488893428L;

    private List<User> users;

    public Users() {
        users = new ArrayList<>();
    }

    public void add(User user) {
        this.users.add(user);
    }

    public void remove(int id) {
        setUsers(
                this.users.stream().filter(u -> u.getId() != id)
                        .collect(Collectors.toList())
        );
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
