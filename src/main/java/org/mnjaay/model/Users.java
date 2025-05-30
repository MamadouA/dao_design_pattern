package org.mnjaay.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Users implements Serializable {
    @Serial
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
                this.users.stream().filter(u -> u.getId() != id).toList()
        );
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
