// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        HDFCAccount PraneethAcc=new HDFCAccount("Praneeth","praneethpass",10000);
        System.out.println(PraneethAcc);

        SBIAccount RamAcc=new SBIAccount("Ram","rampass",1000);
        System.out.println(RamAcc);

        System.out.println(RamAcc.setPassword("123"));
        System.out.println(RamAcc.withdrawMoney(1000,"rampass"));
    }
}