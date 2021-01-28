package Model;

import java.util.List;
import java.util.Random;

public class Account {

    private double Balance;
    private double interestRate;
    private double calculatedInterest;
    private long accountNumber;
    private List<Customer> OwningCustomers;
    private Customer originalOwner;

    Account(Customer originalOwner, double balance){
        setAccountNumber(accountNumber);
        this.originalOwner = originalOwner;
        AddOwningCustomer(originalOwner);
        this.Balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        Random prng = new Random();
        String acctString = "";

        /**
         * Generate a random account number
         * of type Long
         * With 12 ^ 9 combinations: Over 5 billion
         */
        for (int i = 0; i < 12; i++){
            int inNum = prng.nextInt(9);
            acctString += inNum;
        }

        accountNumber = Long.parseLong(acctString);

        this.accountNumber = accountNumber;
    }

    public void AddOwningCustomer(Customer customerToAdd){
        OwningCustomers.add(customerToAdd);
    }

    public void Deposit(double Amount){
        this.Balance += Amount;
    }

    public void Withdraw(double Amount){
        this.Balance -= Amount;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getCalculatedInterest() {
        return calculatedInterest;
    }

    public void setCalculatedInterest(double calculatedInterest) {
        this.calculatedInterest = calculatedInterest;
    }

    public List<Customer> getOwningCustomers(){
        return OwningCustomers;
    }

    public Customer getOriginalOwner() {
        return originalOwner;
    }

    public void setOriginalOwner(Customer originalOwner) {
        this.originalOwner = originalOwner;
    }
}
