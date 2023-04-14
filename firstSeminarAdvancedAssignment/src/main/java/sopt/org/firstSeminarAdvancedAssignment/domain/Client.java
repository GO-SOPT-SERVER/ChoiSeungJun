package sopt.org.firstSeminarAdvancedAssignment.domain;

public class Client {

    private String accountNumber;
    private String password;
    private int amount;
    private String name;
    private String birth;
    private String tel;
    private String address;


    public Client(String accountNumber, String name, String birth, String tel, String address, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.tel = tel;
        this.address = address;
        this.amount = 0;
    }

    public boolean checkPassword(String password) {
        if (this.password.equals(password)) {
            return true;
        }
        return false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getAmount() {
        return amount;
    }
}
