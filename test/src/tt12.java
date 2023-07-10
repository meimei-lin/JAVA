import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.Timer;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import test.GameRule;

public class tt12 extends Thread implements ActionListener,MouseMotionListener,MouseListener,Runnable {
	public static JLabel[][] allmouse=new JLabel[6][6];//創建所有老鼠圖片的標籤
	public static int ms=0,mt=0,mode=0,color=0;//mt時間,ms分數,mode老鼠位置,老鼠種類
	public static boolean stop=false;
	 //設定共用的變數與類別
	public static JLabel lab1,lab2; //lab1時間,lab2成績
	public static JButton bot,glue;
	javax.swing.Timer t;
	@SuppressWarnings("removal")
	public tt12() {
		t=new javax.swing.Timer(1000,this);
		bot.addActionListener(this);
		glue.addActionListener(this);//設定UI元件與滑鼠的事件觸發傾聽者
		
	}
	public void getrule() {//遊戲規則函式
		glue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new GameRule();
            }
        });
	}
	@SuppressWarnings("deprecation")
	//UI元件事件處理類別寫在這裡
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==bot)
		{
			mt=60;
			ms=0;
			lab2.setText("成績:"+ms);
			t.start();
			new tt12().start();
		}
		else if (e.getSource()==t)
		{
			if(mt!=0) {
				mt=mt-1;
				lab1.setText("剩下:"+mt+"秒");
			}
			if(mt==0) {
				t.stop();
				t.restart();
				mode=0;
			}
		}
		else if(e.getSource()==glue) {
			 getrule();
		}
	}
	public static  void whichmouse()	//決定地鼠出現的位置顏色
	{	
		Random r=new Random();
		color=r.nextInt(5);
		if(color>2) color=0;
		mode=r.nextInt(6);
		
		if(color==1)
			allmouse[1][mode].setVisible(true);
		else if(color==2)
			allmouse[2][mode].setVisible(true);
		else
			allmouse[0][mode].setVisible(true);
	}
	
	public static void main(String[]args) {
		JFrame c=new JFrame();
		c.setTitle("打地鼠遊戲");
		c.setSize(653,437);
		c.setResizable(false);
		JLabel bgimage=new JLabel();//設置背景圖片的標籤
		bgimage.setIcon(new ImageIcon("images.jpg"));
		bgimage.setBounds(0,0,640,480);
		
		for(int i=0;i<6;i++) //設置6個位置各6種老鼠圖片
		{
			JLabel mouse1=new JLabel();
			mouse1.setIcon(new ImageIcon("mouse1.png"));
			mouse1.setSize(130,130);
			mouse1.setVisible(false);//先設隱藏
			
			JLabel mouse2=new JLabel();
			mouse2.setIcon(new ImageIcon("mouse2.png"));
			mouse2.setSize(130,130);
			mouse2.setVisible(false);
			
			JLabel mouse3=new JLabel();
			mouse3.setIcon(new ImageIcon("mouse3.png"));
			mouse3.setSize(130,130);
			mouse3.setVisible(false);
			
			JLabel mouse1x=new JLabel();
			mouse1x.setIcon(new ImageIcon("mouse1x.png"));
			mouse1x.setSize(130,130);
			mouse1x.setVisible(false);
			
			JLabel mouse2x=new JLabel();
			mouse2x.setIcon(new ImageIcon("mouse2x.png"));
			mouse2x.setSize(130,130);
			mouse2x.setVisible(false);
			
			JLabel mouse3x=new JLabel();
			mouse3x.setIcon(new ImageIcon("mouse3x.png"));
			mouse3x.setSize(130,130);
			mouse3x.setVisible(false);
				

			mouse1.addMouseListener(new MouseListener() {	//一般地鼠加1分
				@Override
				public void mouseClicked(MouseEvent e) {
					ms+=1;
					lab2.setText("成績:"+ms);
					allmouse[color][mode].setVisible(false);
					allmouse[3][mode].setVisible(true);
				}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseReleased(MouseEvent e) {}		
				@Override
				public void mouseEntered(MouseEvent e) {}	
				@Override
				public void mouseExited(MouseEvent e) {}
			});
			mouse2.addMouseListener(new MouseListener() { //黃金鼠分數*2
				@Override
				public void mouseClicked(MouseEvent e) {
					if(ms>0) {
						ms*=2;
						lab2.setText("成績:"+ms);
						allmouse[color][mode].setVisible(false);
						allmouse[4][mode].setVisible(true);
					}
				}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseReleased(MouseEvent e) {}		
				@Override
				public void mouseEntered(MouseEvent e) {}	
				@Override
				public void mouseExited(MouseEvent e) {}
			});
			mouse3.addMouseListener(new MouseListener() {	//壞壞鼠減2分
				@Override
				public void mouseClicked(MouseEvent e) {
					ms-=2;
					lab2.setText("成績:"+ms);
					allmouse[color][mode].setVisible(false);
					allmouse[5][mode].setVisible(true);
				}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseReleased(MouseEvent e) {}		
				@Override
				public void mouseEntered(MouseEvent e) {}	
				@Override
				public void mouseExited(MouseEvent e) {}
			});
			
			c.add(mouse1);//加到視窗上
			c.add(mouse2);
			c.add(mouse3);
			c.add(mouse1x);
			c.add(mouse2x);
			c.add(mouse3x);
			allmouse[0][i]=mouse1;
			allmouse[1][i]=mouse2;
			allmouse[2][i]=mouse3;
			allmouse[3][i]=mouse1x;
			allmouse[4][i]=mouse2x;
			allmouse[5][i]=mouse3x;
		
		}
		for(int i=0;i<6;i++) {
			allmouse[i][0].setLocation(103,84);//第一隻地鼠位置
		}
		for(int i=0;i<6;i++) {
			allmouse[i][1].setLocation(256,84);
		}	
		for(int i=0;i<6;i++) {
			allmouse[i][2].setLocation(410,84);
		}
		for(int i=0;i<6;i++) {
			allmouse[i][3].setLocation(103,201);
		}
		for(int i=0;i<6;i++) {
			allmouse[i][4].setLocation(256,201);
		}
		for(int i=0;i<6;i++) {
			allmouse[i][5].setLocation(410,201);
		}
		
		lab1=new JLabel("剩下:60秒");
		lab2=new JLabel("成績:0");
		bot=new JButton("開始");
		glue=new JButton("遊戲規則");
		lab1.setBounds(150,-70,450,200);
		lab2.setBounds(250,-70,450,200);
		bot.setBounds(300,20,100,30);
		glue.setBounds(450,20,100,30);
		c.add(lab1);c.add(lab2);c.add(bot);c.add(glue);//將UI元件加入視窗
		c.add(bgimage);
		c.setVisible(true);
		tt12 app=new tt12();
		}
	public void run() {
		while(true) {
			try {
				sleep(1000);
			}
			catch(InterruptedException e1){
				e1.printStackTrace();
			}
			whichmouse();	//老鼠出現
			try {
				sleep(1000);
			}
			catch(InterruptedException e1) {
				e1.printStackTrace();
			}
			allmouse[color][mode].setVisible(false);//老鼠消失
			allmouse[color+3][mode].setVisible(false);
			
			if(mt==0) break;
		 }
		}

	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseDragged(MouseEvent e) {}
}
	