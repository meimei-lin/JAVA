import javax.swing.JOptionPane;

class Account 
{
 private int value=0 ;
 public  void saveMoney(int money) {
  this.value=value+money;
 }
 public int getMoney(int money)
 {
  if(this.value>=money) {
   this.value=value-money;
  }
  return money;
 }
 public int search() {
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

class takeMoney extends Thread{
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
	 Save s = new Save();
  synchronized(account) {
   try {
    sleep(5);
    if(money>account.search()) 
    {
     JOptionPane.showMessageDialog(null, "餘額不足","提示",JOptionPane.INFORMATION_MESSAGE);
     
    }
   }
   catch(ArithmeticException e){}
   catch(InterruptedException e) {
    e.printStackTrace();
   }
   int getMoney=account.getMoney(money);
   JOptionPane.showMessageDialog(null, "您要提領的金額為:"+this.money+"元.您的帳戶有:"+account.search()+"元.","提示",JOptionPane.INFORMATION_MESSAGE);
   s.SaveAccount(account.search());
  }
 }
}
class SaveMoney extends Thread{
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
	 Save s = new Save();
  synchronized(account) {
   try {
    sleep(5);
   }
   catch(InterruptedException e) {
    e.printStackTrace();
   }
   account.saveMoney(this.money);
   JOptionPane.showMessageDialog(null, "您存入的金額為:"+this.money+"元.您的帳戶有:"+account.search()+"元.","提示",JOptionPane.INFORMATION_MESSAGE);
   s.SaveAccount(account.search());
  }
 }
}
