
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

public class game extends Thread implements ActionListener,MouseMotionListener,MouseListener {
	public static JLabel[] allmouse=new JLabel[6];
	public static int ms=0,mt=0;
	public static JLabel lab1,lab2;
	public static JButton bot,glue;
	javax.swing.Timer t;
	public game() {
		t=new javax.swing.Timer(500,this);
		bot.addActionListener(this);glue.addActionListener(this);
	}
	public void getrule() {
		glue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameRule();
            }
        });
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==bot)
		{
			mt=60;
			ms=0;
			lab2.setText("成績:"+ms);
			t.start();
			new game().start();//啟動執行續
			
		}
		else if (e.getSource()==t)
		{
			mt=mt-1;
			lab1.setText("剩下:"+mt+"秒");
			if(mt==0) {
				t.stop();
			}
			
		}
		else if(e.getSource()==glue) {
			 getrule();
		}
	}
	public static void main(String[]args) {
		JFrame c=new JFrame();
		c.setTitle("打地鼠遊戲");
		c.setSize(640,480);
		
		JLabel bgimage=new JLabel();
		bgimage.setIcon(new ImageIcon("image.jpg"));
		bgimage.setBounds(0,0,640,480);
		

		
		for(int i=0;i<6;i++) {
			JLabel mouse=new JLabel();
			mouse.setIcon(new ImageIcon("mouse.png"));
			mouse.setSize(90,90);
			mouse.setVisible(false);
			mouse.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					ms+=1;
					lab2.setText("成績:"+ms);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
			c.add(mouse);
			allmouse[i]=mouse;
			
		}
		allmouse[0].setLocation(120,190);
		allmouse[1].setLocation(285,190);
		allmouse[2].setLocation(450,190);
		allmouse[3].setLocation(120,280);
		allmouse[4].setLocation(285,280);
		allmouse[5].setLocation(450,280);
		
		
		lab1=new JLabel("剩下:60秒");
		lab2=new JLabel("成績:0");
		bot=new JButton("開始");
		glue=new JButton("遊戲規則");
		lab1.setBounds(150,-70,450,200);
		lab2.setBounds(250,-70,450,200);
		bot.setBounds(300,20,100,30);
		glue.setBounds(450,20,100,30);
		c.add(lab1);c.add(lab2);c.add(bot);c.add(glue);
		c.add(bgimage);
		c.setVisible(true);
		game app=new game();
	}
	Random rg=new Random();
	public void run() {
		while(true) {
			try {
				sleep(1000);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			int mode=rg.nextInt(6);
			allmouse[mode].setVisible(true);
			try {
				sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			allmouse[mode].setVisible(false);
			if(mt==0)break;
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}}
	