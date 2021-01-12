package View;

import Model.*;

public interface AppView {

    void DepositIntoAccount(double Amount);

    void WithdrawFromAccount(double Amount);

    void CreateNewCustomer();

    void AddCustomerToAccount(Customer customer, Account account);

    void AddAccountToCustomer(Customer customer, Account account);

    void DisplayInterestCalculated();

    boolean confirmExit();

}
