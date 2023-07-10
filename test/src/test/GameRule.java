package test;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
public class GameRule extends JDialog{
	private int num = 1;
    public GameRule() {
        TextArea textArea = new TextArea(50,50);
        textArea.setText("在60秒的時間內，地鼠跑出來時立即打擊地鼠，打到正常地鼠一隻即得1分，打到壞壞鼠會扣2分，打到黃金鼠分數會加倍喔!");
        JScrollPane jScrollPane = new JScrollPane(textArea);
        JLabel bg=new JLabel();
        JLabel mouse1=new JLabel();
        JLabel mouse2=new JLabel();
        JLabel mouse3=new JLabel();
        bg.setIcon(new ImageIcon("images.jpg"));
        mouse1.setIcon(new ImageIcon("mouse1.png"));
        mouse2.setIcon(new ImageIcon("mouse2.png"));
        mouse3.setIcon(new ImageIcon("mouse3.png"));
        mouse1.setSize(130,130);
        mouse2.setSize(130,130);
        mouse3.setSize(130,130);
        bg.setSize(750,200);
        mouse1.setLocation(110,20);
        mouse2.setLocation(260,20);
        mouse3.setLocation(420,20);
        bg.setLocation(5,30);
        mouse1.setVisible(true);
        mouse2.setVisible(true);
        mouse3.setVisible(true);
        bg.setVisible(true);
        this.add(mouse1);
        this.add(mouse2);
        this.add(mouse3);
        this.add(bg);
        this.add(jScrollPane);
        this.setBounds(100,100,400,400);
        this.setSize(700,200);
        this.setVisible(true);
        textArea.setEditable(false);
        setResizable(false);
    }
}
