package oneTask;

import oneTask.Code;

public class CreditCard {

    private final String accountCode;    //номер счета
    private long accountBalance;         //текущая сумма на счету

    public CreditCard() {
        Code code = new Code();
        this.accountCode = code.getCode();
        this.accountBalance = 0;
    }

    public CreditCard(long accountBalance) {
        Code code = new Code();
        this.accountCode = code.getCode();
        this.accountBalance = accountBalance;
    }

    public CreditCard(String accountCode, long accountBalance) {
        this.accountCode = accountCode;
        this.accountBalance = accountBalance;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public boolean deposit(long amount) {                         //Пополнение счета
        if ((Long.MAX_VALUE - this.accountBalance) >= amount) {
            this.accountBalance = accountBalance + amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(long amount) {                         //Снятие денег со счета
        if ((this.accountBalance - amount) >= 0) {
            this.accountBalance = accountBalance - amount;
            return true;
        } else {
            return false;
        }
    }

    public void displayInfo() {                                //Вывод информации (у.е. - условные еденицы)
        System.out.println("Номер счета: " + this.accountCode);
        System.out.println("Текущая сумма на счету: " + this.accountBalance + " у.е.");
    }


}