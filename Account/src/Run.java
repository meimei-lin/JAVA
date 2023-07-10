import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Run {
 public void run() {
  Account account=new Account();
  account.setValue(0);
  while(true) {
  try {
   while(true) {
    int i;
    String s1 = JOptionPane.showInputDialog(null,"請選擇(1)存款 (2)提款","輸入",JOptionPane.PLAIN_MESSAGE);
    Scanner input=new Scanner(s1);
    i=input.nextInt();
    if(i==1) {
     int mon;
     String s2 = JOptionPane.showInputDialog(null,"請輸入要存入的金額:","輸入",JOptionPane.PLAIN_MESSAGE);
     Scanner save = new Scanner(s2);
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
    	  JOptionPane.showMessageDialog(null,"請輸入正整數","警告",JOptionPane.WARNING_MESSAGE);
      }
     }
    }else if(i==2) {
     int mon1;
     String s3 = JOptionPane.showInputDialog(null,"請輸入要提領的金額:","輸入",JOptionPane.PLAIN_MESSAGE);
     Scanner pick = new Scanner(s3);
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
    	  JOptionPane.showMessageDialog(null,"請輸入正整數","警告",JOptionPane.WARNING_MESSAGE);
      }
     }
    }else {
    	JOptionPane.showMessageDialog(null,"輸入錯誤","警告",JOptionPane.WARNING_MESSAGE);
    }
   }
  }
  catch(InputMismatchException e) {
	  JOptionPane.showMessageDialog(null,"請輸入正整數","警告",JOptionPane.WARNING_MESSAGE);
  }
  catch(NumberFormatException e) {
	  JOptionPane.showMessageDialog(null,"請輸入正整數","警告",JOptionPane.WARNING_MESSAGE);
  }
 }
}
}