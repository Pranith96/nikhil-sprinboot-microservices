import java.util.Objects;

public class Bank {

	private int accountId;
	private double balance;
	private String status;
	private String accountType;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Bank(int accountId, double balance, String status, String accountType) {
		this.accountId = accountId;
		this.balance = balance;
		this.status = status;
		this.accountType = accountType;
	}

	public Bank() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountId, accountType, balance, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		return accountId == other.accountId && Objects.equals(accountType, other.accountType)
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "Bank [accountId=" + accountId + ", balance=" + balance + ", status=" + status + ", accountType="
				+ accountType + "]";
	}

}
