package gr.aube.cf.model;

import gr.aube.cf.exceptions.InsufficientBalanceException;
import gr.aube.cf.exceptions.NegativeAmountException;
import gr.aube.cf.exceptions.SsnNotValidException;

public class OverdraftJointAccount extends JointAccount {
    public OverdraftJointAccount (){};

    public OverdraftJointAccount(User holder, String iban,
                                 double balance, User secondHolder) {
        super(holder, iban, balance, secondHolder);
    }

    @Override
    public void withdraw(double amount, String ssn)
            throws InsufficientBalanceException, SsnNotValidException, NegativeAmountException {
        try {
            if (amount < 0) throw new NegativeAmountException(amount);
            if (!isSsnValid(ssn)) throw new SsnNotValidException(ssn);

            setBalance(getBalance() - amount);
        } catch (SsnNotValidException | NegativeAmountException e) {
            System.err.println("Error : withdrawal");
            throw e;
        }
    }
}
