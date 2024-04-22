public class Customer{

      public String customerName;
      public String password;
      public int accountNumber;
      public int balance;
      public Customer() {
           
      }
      public Customer(String customerName,int accountNumber,String password,int balance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.password = password;
        this.balance = balance;
      }
      public String getCustomerName() {
        return customerName;
      }
      public int getAccountNumber() {
        return accountNumber;
      }
      public String getPassword() {
        return password;
      }
      public int getBalance() {
        return balance;
      }
      public void setCustomerName(String customerName) {
        this.customerName = customerName;
      }
      public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
      }
      public void setPassword(String password) {
        this.password = password;
      }
      public void setBalance(int balance) {
        this.balance = balance;
      }

      @Override 
      public String toString() {
            return "customerName " + getCustomerName() +
                   "account Number " + getAccountNumber() +
                   "password " + getPassword() +
                   "balance " +getBalance();
      }

}