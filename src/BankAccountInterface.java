public interface BankAccountInterface {
    String fetchBalance(String password);
    String addBalance(double amount);
    String withdrawMoney(double amount,String password);
    String changePassword(String oldPassword,String newPassword);
    double calculateInterest(int year);
}
