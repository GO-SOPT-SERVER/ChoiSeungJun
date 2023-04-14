package sopt.org.firstSeminarAdvancedAssignment.domain;

public class Client {

    private String accountNumber;
    private String password;

    private int amount;
    private String name;
    private String birth;
    private String tel;
    private String address;


    public Client(String accountNumber, String password, String name, String birth, String tel, String address) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.tel = tel;
        this.address = address;
        this.amount = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
