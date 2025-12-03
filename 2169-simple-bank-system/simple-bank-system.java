class Bank {
    long[] accountBalance;

    public Bank(long[] balance) {
        this.accountBalance=balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(accountBalance.length<account1 || accountBalance.length<account2)
            return false;
        if(accountBalance[account1-1]<money)
            return false;
        accountBalance[account1-1]-=money;
        accountBalance[account2-1]+=money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(accountBalance.length<account)
            return false;
        accountBalance[account-1]+=money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(accountBalance.length<account-1)
            return false;
        if(accountBalance[account-1]<money)
            return false;
        accountBalance[account-1]-=money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */