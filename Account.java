public class Account extends Person{
    private String userName;
    private String password;

    public Account(String name, String address, String phoneNumber, String id, String userName, String password) {
        super(name, address, phoneNumber, id);
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
