package Class_Objects;

class BankAccount {
    public String username;
    private String password;

    public void setPassword(String pwd){
        password = pwd;
    }
}

public class OOPS {
    public static void main(String[] args){
        BankAccount myAcc = new BankAccount();
        myAcc.username = "Aakash";
        myAcc.setPassword("Anime"); // Allows you to set the password using a public method without directly accessing the private password.
    }
}