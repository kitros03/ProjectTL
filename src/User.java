
import java.util.ArrayList;

public class User {
    private int user_ID = 0;
    private String f_name, l_name, username, email, password, address;
    private long phone_number;

    ArrayList<User> userList = new ArrayList<>();

    public User(){};

    public User(int user_ID, String f_name, String l_name, String username, String email, String password, long phone_number, String address) {
        this.user_ID = user_ID;
        this.f_name = f_name;
        this.l_name = l_name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.address = address;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public String getFirstname() {
        return f_name;
    }

    public void setFirstname(String f_name) {
        this.f_name = f_name;
    }

    public String getLastname() {
        return l_name;
    }

    public void setLastname(String l_name) {
        this.l_name = l_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
