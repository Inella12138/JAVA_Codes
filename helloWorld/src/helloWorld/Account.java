package helloWorld;

public class Account {
	private String number;
	private double balance;
	public Account() {
		this("",0);
	}
	public Account(String number,double balance) {
		this.number=number;
		this.balance=balance;
	}
	public String getNumber() {
		return number;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void deposit(double amt) {
		balance+=amt;
	}
}
