import java.util.UUID;

public class SBIAccount implements BankAccountInterface{

    private String name;
    private String password;
    private String accountNumber;
    private final double minBalance=1000;
    private double balance;
    private final double rateOfInterest=6.5;

    public SBIAccount() {
    }

    public SBIAccount(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountNumber= String.valueOf(UUID.randomUUID());
    }

    public double getInterestRate() {
        return rateOfInterest;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public String setPassword(String password) {
        boolean characters=false;
        boolean numbers=false;
        boolean specialSymbols=false;

        for(int i=0;i<password.length();i++){
            char ch=password.charAt(i);
            if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z')){
                characters=true;
            }
            else if(ch>='0' && ch<='9'){
                numbers=true;
            }
            else{
                specialSymbols=true;
            }
        }

        if(characters && numbers && specialSymbols){
            this.password=password;
            return "Valid password";
        }

        String message="Password must contain";
        if(!characters){
            message+=" character";
        }
        if(!numbers){
            message+=" number";
        }
        if(!specialSymbols){
            message+=" special symbol.";
        }

        return message;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getMinBalance() {
        return minBalance;
    }

    @Override
    public String fetchBalance(String password) {
        return "Balance is : "+this.balance;
    }

    @Override
    public String addBalance(double amount) {
        if(amount < 0){
            return "Invalid amount";
        }
        this.balance+=amount;
        return "New balance : "+this.balance;
    }

    @Override
    public String withdrawMoney(double amount, String password) {
        if(this.password.equals(password)){
            if(this.balance < amount){
                return "Insufficient balance";
            }
            else if(this.balance-this.minBalance < amount){
                return "Should maintain minimum balance : "+this.minBalance;
            }
            this.balance-=amount;
            return "Updated balance : "+this.balance;
        }
        return "Invalid password";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(this.password.equals(oldPassword)){
            String confirm = setPassword(oldPassword);
            if(confirm.equals("Valid password")){
                return "Password changed successfully";
            }
            return confirm;
        }
        return "Invalid password";
    }

    @Override
    public double calculateInterest(int year) {
        return (this.balance*year*rateOfInterest)/100.0;
    }

    @Override
    public String toString() {
        return "SBIAccount{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", minBalance=" + minBalance +
                ", balance=" + balance +
                ", rateOfInterest=" + rateOfInterest +
                '}';
    }
}
