

import java.math.BigDecimal;


public class Account {
 
	/**
     * Represents UNIQUE account id, e.g. GB123-456
     */
    private String accountId;
 
    /**
     * Represents current balance of the account
     */
    private BigDecimal balance;
 
    public Account(String accountId, BigDecimal balance) {
        this.accountId = accountId;
        this.balance = balance;
    }
    
    public String getAccountId() {
    	return accountId;
    }
    
    public void setAccountId(String accountId) {
    	this.accountId = accountId;
    }

    public BigDecimal getBalance() {
    	return balance;
    }
    
    public void setBalance(BigDecimal balance) {
    	this.balance = balance;
    }

    public String toString() {
        return accountId;
    }

    public boolean equals(final Object otherId) {
        if (null != otherId && otherId instanceof Account) {
            final Account otherAccount = (Account) otherId;
            return (this.toString().equals(otherAccount.toString()));
        } else {
            return false;
        }
    }
    
    public int hashCode()
    {
        return accountId.hashCode();
    }

}
 