import java.util.*;

public class Process {
    private static DataBase db;
    private List<Customer> allCus;
    private static Customer cus;
    private List<String> transactionHistory;
    private int totalBalance;
    private int rewards;
    public Process() {
        db = new DataBase();
        allCus = new ArrayList<>(db.getCustomers());
        cus = new Customer();
        transactionHistory = new ArrayList<>();
        totalBalance = 0;
        rewards = 0;
    }
    public String loginToAcc(int accNum, String passKey) {
        
        StringBuilder modifiedPassKey = new StringBuilder(passKey);
        for (int i = 0; i < modifiedPassKey.length(); i++) {
            char c = modifiedPassKey.charAt(i);
            if (c == 'A') {
                modifiedPassKey.setCharAt(i, 'B');
            } else if (c == 'B') {
                modifiedPassKey.setCharAt(i, 'C');
            } else if (c == 'a') {
                modifiedPassKey.setCharAt(i, 'b');
            } else if (c == 'b') {
                modifiedPassKey.setCharAt(i, 'c');
            } else if (c == 'c') {
                modifiedPassKey.setCharAt(i, 'd');
            } else if (c == '0') {
                modifiedPassKey.setCharAt(i, '1');
            } else if (c == '1') {
                modifiedPassKey.setCharAt(i, '2');
            }
        }
        return modifiedPassKey.toString();
        
    }
    public void start() {
    Scanner input = new Scanner(System.in);
    String str;

    do {
        System.out.println("Enter account number:");
        int accNum = input.nextInt();
        input.nextLine(); 
        System.out.println("Enter password:");
        String passKey = input.nextLine();
        for (Customer ch : allCus) {
            if (ch.getAccountNumber() == accNum) {
                totalBalance = ch.getBalance();
            }
        }
        System.out.println("Enter 'Account login' to login or 'exit' to quit:");
        str = input.nextLine();
        
        if (str.equals("Account login")) {
            String modifiedPassKey = loginToAcc(accNum, passKey);
            boolean success = false;
            for (Customer ch : allCus) {
                System.out.println("all:"+ch.getPassword());
                if (ch.getPassword().equals(modifiedPassKey)) {
                    success = true;
                    break;
                }
            }
            if (success) {
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed");
            }
            
            System.out.println("Choose the menu: 1.Create Gift Card 2.TopUp 3.Transaction History 4.Block 5.log out");
            String menu = input.nextLine();
            
            if (menu.equals("Create Gift Card")) {
              
            } 
            else if (menu.equals("TopUp")) {
                System.out.println("Enter your phone number:");
                String phnNumber = input.nextLine();
                System.out.println("Enter amount:");
                int amt = input.nextInt();
                int balance = 0;
                int availableBalance =  totalBalance - amt;
                totalBalance -= amt;
                cus.setBalance(availableBalance);
                System.out.println("Available amount: " + availableBalance);
                transactionHistory.add((String)("for topUp at - " + amt));
            }
            else if (menu.equals("Transaction")) {
                System.out.println(transactionHistory);
            }
            else if (menu.equals("Block")) {
                System.out.println("your card is block. you can't bale to do topUp");
                break;
            }
            else if(menu.equals("log out")) {
                System.out.println("your currect accout was log out so relogin your account");
                continue;
            }
        }
        else if(str.equals("purchase")) {

            System.out.println("enter purchase amount");
            int amt = input.nextInt();
            totalBalance -= amt;
            System.out.println("available balance is :"+ totalBalance);
            if (amt >= 100 ) {
               rewards++;
               if (rewards >= 10) {
                   totalBalance += 10;
                   System.out.println("rewards is added and balance is :"+ totalBalance);
               }
            }

        }

        
    } while (!str.equals("exit"));
}

    
}
