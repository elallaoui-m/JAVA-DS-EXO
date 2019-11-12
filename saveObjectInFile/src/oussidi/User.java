package oussidi;

import java.io.Serializable;

public class User  {
    private static final long serialVersionUID = 1L;
    String username;
    String password;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    @Override
    public String toString() {
        return username+"|"+password+"\n";
    }
}
