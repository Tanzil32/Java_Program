import java.util.Scanner;

class Account{
    private String accNo;
    private String name;
    private double balance;

    Account(String accNo,String name, double balance){
        this.accNo=accNo;
        this.name=name;
        this.balance=balance;
    }
    public void deposit(double amount){
        if(amount>0){
            balance += amount;
            System.out.println("Amout : "+amount+" is deposited");
        }
        else {
            System.out.println("Invalid amount");
        }
    }
    public void  withdraw(double amount){
        if(amount>0 && balance-amount>0){
            balance -= amount;
            System.out.println("Withdraw amount: "+amount);
            System.out.println("Balance : "+balance);
        }
        else {
            System.out.println("Insufficient valence");
        }
    }
    public String getaccNo(){
        return accNo;
    }
    public void showDetails(){
        System.out.println("Account Number :"+accNo);
        System.out.println("Name :"+name);
        System.out.println("Balance :"+balance);
    }
}
class Bank{
    private Account[ ] accounts;
    private int count;

    Bank(){
        accounts = new Account[100];
        count=0;
    }
    public void addAccount(Account acc){
        if(count<accounts.length){
            accounts[count]=acc;
            count++;
            System.out.println("Account is added successfully");
        }
        else{
            System.out.println("Bank is full! Cannot add more accounts.");
        }
    }
    public Account findAccount(String accNo){
        for (int i=0;i<count;i++){
            if(accounts[i].getaccNo().equals(accNo)) {
                return accounts[i];
            }
        }
        return null;
    }
    public void removeAccount(String accNo){
        for (int i=0;i<count;i++){
            if(accounts[i].getaccNo().equals(accNo)){
                for(int j=i;j<count-1;j++){
                    accounts[j]=accounts[j+1];
                }
                count--;
                accounts[count-1]=null;
                System.out.println("Account removed");
            }
        }
        System.out.println("Account not found");
    }
    public void showAll(){
        if(count==0){
            System.out.println("Account not found");
        }
        for (int i=0;i<count;i++){
            accounts[i].showDetails();
        }
    }
}
public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank= new Bank();
        while (true){
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show All Accounts");
            System.out.println("5. Remove Account");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int ch = input.nextInt();
            if(ch==1){
                System.out.println("Enter your account number: ");
                String accNo = input.next();
                System.out.println("Enter your name: ");
                String name = input.next();
                System.out.println("Enter your amount: ");
                double amount = input.nextDouble();
                bank.addAccount(new Account(accNo,name,amount));

            }
            else if(ch==2){
                System.out.println("Enter your account number: ");
                String acc = input.next();
                Account a= bank.findAccount(acc);
                if(a!=null){
                    System.out.println("Enter your amount: ");
                    double amount = input.nextDouble();
                    a.deposit(amount);
                }
                else {
                    System.out.println("Account not found");
                }
            }
            else if(ch==3){
                System.out.println("Enter your account number: ");
                String acc = input.next();
                Account a=bank.findAccount(acc);
                if (a!=null){
                    System.out.println("Enter your amount: ");
                    double amount = input.nextDouble();
                    a.withdraw(amount);
                }
                else {
                    System.out.println("Account not found");
                }
            }
            else if(ch==4){
                bank.showAll();
            }
            else if(ch==5){
                String accN0 = input.next();
                bank.removeAccount(accN0);
            }
            else if(ch==6){
                break;
            }
            else {
                System.out.println("Invalid input");
            }
        }
        input.close();
    }
}