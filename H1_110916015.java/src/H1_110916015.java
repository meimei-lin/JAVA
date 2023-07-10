import java.util.Scanner;
import java.util.InputMismatchException;
class Account 
{
	private int value=0 ;//帳戶餘額
	public void saveMoney(int money) {
		this.value=value+money;
	}
	public int getMoney(int money)
	{
		if(this.value>=money) {
			this.value=value-money;
		}
		return money;
	}
	public int search() {//查詢餘額
		return this.value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value=value;
	}
}
class positerIntException extends Exception{}

class positer{
	private int money;
	public void input(int m) throws positerIntException{
		if(money<=0) {
			throw new positerIntException();
		}
	}
}

class takeMoney extends Thread{//取款的執行緒
	private Account account;
	private int money;
	public takeMoney() {
		super();
	}
	public takeMoney(int money,Account account) {
		this.account=account;
		this.money=money;
	}
	public void run() {
		synchronized(account) {
			try {
				sleep(5);
				if(money>account.search()) 
				{
					System.out.println("餘額不足");
					
				}
			}
			catch(ArithmeticException e){}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			int getMoney=account.getMoney(money);
			System.out.println("您要提領的金額為:"+this.money+"元.您的帳戶有:"+account.search()+"元.");
		}
	}
}
class SaveMoney extends Thread{//存款的執行緒
	private Account account;
	private int money;//金額
	public SaveMoney() {
		super();
	}
	public SaveMoney(int money,Account account) {
		this.account=account;
		this.money=money;
	}
	public void run() {
		synchronized(account) {
			try {
				sleep(5);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			account.saveMoney(this.money);
			System.out.println("您存入的金額為:"+this.money+"元.您的帳戶有:"+account.search()+"元.");
		}
	}
}

public class H1_110916015{
	public static void main(String[]args) {
		Account account=new Account();
		account.setValue(0);
		while(true) {
		try {
			while(true) {
				int i;
				System.out.println("請選擇(1)存款 (2)提款");
				Scanner input=new Scanner(System.in);
				i=input.nextInt();
				if(i==1) {
					int mon;
					System.out.println("請輸入要存入的金額:");
					Scanner save = new Scanner(System.in);
					mon = save.nextInt();
					if(mon>0) {
						new SaveMoney(mon,account).start();
					}
					else {
						positer po=new positer();
						try {
							po.input(mon);
						}
						catch(positerIntException e) {
							System.out.println("請輸入正整數");
						}
					}
				}else if(i==2) {
					int mon1;
					System.out.println("請輸入要提領的金額:");
					Scanner pick = new Scanner(System.in);
					mon1 = pick.nextInt();
					if(mon1>0) {
						new takeMoney(mon1,account).start();
					}
					else {
						positer po=new positer();
						try {
							po.input(mon1);
						}
						catch(positerIntException e) {
							System.out.println("請輸入正整數");
						}
					}
				}else {
					System.out.println("輸入錯誤");
				}
			}
		}
		catch(InputMismatchException e) {
			System.out.println("請輸入正整數");
		}
		catch(NumberFormatException e) {
			System.out.println("請輸入正整數");
		}
	}
}
}