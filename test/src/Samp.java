import java.awt.*;
import javax.swing.*;
import test.GameRule;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;
import java.util.*;
//想想還有沒有其他的東西要import
public class Samp extends JFrame implements ActionListener,MouseMotionListener,MouseListener //名稱改一改
{
	Container c;
	//設定UI元件
	JButton bot,gule;
	JLabel lab1,lab2,lab3;
	//設定共用的變數與類別
	java.util.Random rg,rc;
	int x1,y1,x2,y2,x3,y3,x4,y4,x5,y5,x6,y6,mode,color,ms,mt;//mt時間,ms分數
	javax.swing.Timer t;
	@SuppressWarnings("removal")
	public Samp() //建構元，名稱改一改
	{
		super("打地鼠");
		//初始化共用變數
		x1=170;y1=250;
		x2=330;y2=250;
		x3=500;y3=250;
		x4=170;y4=350;
		x5=330;y5=350;
		x6=500;y6=350;
		mode=0;
		color=0;
		rg=new Random();
		rc=new Random();
		c=getContentPane();//取得ContentPane
		//設定版面設定
		c.setLayout(new FlowLayout());//對齊中間
		//初始化UI元件
		c.add(new JLabel(new ImageIcon("image.jpg")));
		
		
		bot=new JButton("開始");
		lab1=new JLabel("剩下:60秒");
		lab2=new JLabel("成績:0");
		lab3=new JLabel("獲得總分:");
		gule=new JButton("遊戲規則");
		
		
		//將UI元件加入ContentPane
		c.add(lab1);c.add(bot);c.add(lab2);c.add(gule);
		c.add(lab3);
		//設定UI元件與滑鼠的事件觸發傾聽者
		bot.addActionListener(this);gule.addActionListener(this);//rebin.addActionListener(this);
		//stop1.addActionListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		addMouseListener(this);
		setSize(640,480);//設定size，顯示出去
		setVisible(true);
		t=new javax.swing.Timer(1000,this);
	}
	public void getrule() {
		gule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameRule();
            }
        });
	}
	public void SetColor(int color,Graphics g)
	{
		if(color==1) 
			g.setColor(Color.yellow);
		else if(color==2) 
			g.setColor(Color.gray);
		else
			g.setColor(Color.black);
	}
	public int score(int color,int ms)
	{
		if(color==1) 
			ms*=2;
		else if(color==2) 
			ms-=2;
		else
			ms+=1;
		return ms;
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);//畫出元件
		
		g.drawOval(x1-50,y1-50,70,70);
		g.drawOval(x2-50,y2-50,70,70);
		g.drawOval(x3-50,y3-50,70,70);
		g.drawOval(x4-50,y4-50,70,70);
		g.drawOval(x5-50,y5-50,70,70);
		g.drawOval(x6-50,y6-50,70,70);
		//額外的畫圖程式寫在這裡
		
		SetColor(color,g);
		if(mode==1)
			g.fillOval(x1-50,y1-50,70,70);
		else
			g.drawOval(x1-50,y1-50,70,70);
		if(mode==2)
			g.fillOval(x2-50,y2-50,70,70);
		else
			g.drawOval(x2-50,y2-50,70,70);
		if(mode==3)
			g.fillOval(x3-50,y3-50,70,70);
		else
			g.drawOval(x3-50,y3-50,70,70);
		if(mode==4)
			g.fillOval(x4-50,y4-50,70,70);
		else
			g.drawOval(x4-50,y4-50,70,70);
		if(mode==5)
		{
			//g.setColor(Color.gray);
			g.fillOval(x5-50,y5-50,70,70);
		}
		else
			g.drawOval(x5-50,y5-50,70,70);
		if(mode==6) {
			//g.setColor(Color.yellow);
			g.fillOval(x6-50,y6-50,70,70);
		}
		else
			g.drawOval(x6-50,y6-50,70,70);
		
	}
	
	public void mouseDragged(MouseEvent xxx) { };
	public void mouseMoved(MouseEvent e){ };
	//UI元件事件處理類別寫在這裡
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==bot)
		{
			mt=60;
			ms=0;
			lab2.setText("成績:"+ms);
			t.start();
			
		}
		else if (e.getSource()==t)
		{
			mt=mt-1;
			mode=rg.nextInt(7)+1;
			color=rc.nextInt(5)+1;
			lab1.setText("剩下:"+mt+"秒");
			if(mt==0) {
				t.stop();
				mode=0;
				lab3.setText("獲得總分"+ms);
			}
			repaint();
		}
		else if(e.getSource()==gule) {
			 getrule();
		}
	
	}
	
	public void mouseEntered(MouseEvent e){ };
	public void mouseExited(MouseEvent e){ };
	public void mousePressed(MouseEvent e)
	{
		int mx,my;
		mx=e.getX();my=e.getY();
		if (mode==1)
		{
			if ((x1-mx)*(x1-mx)+(y1-my)*(y1-my)<2500)
			{
			ms=score(color,ms);
			lab2.setText("成績:"+ms);
			mode=0;
			repaint();
			}
		}
		else if (mode==2)
		{
			if ((x2-mx)*(x2-mx)+(y2-my)*(y2-my)<2500)
			{
				ms=score(color,ms);
				lab2.setText("成績:"+ms);
				mode=0;
				repaint();
			}
		}
		else if (mode==3)
		{
			if ((x3-mx)*(x3-mx)+(y3-my)*(y3-my)<2500)
			{
				ms=score(color,ms);
				lab2.setText("成績:"+ms);
				mode=0;
				repaint();
			}
		}
		else if (mode==4)
		{
			if ((x4-mx)*(x4-mx)+(y4-my)*(y4-my)<2500)
			{
				ms=score(color,ms);
				lab2.setText("成績:"+ms);
				mode=0;
				repaint();
			}
		}
		else if (mode==5)
		{
			if ((x5-mx)*(x5-mx)+(y5-my)*(y5-my)<2500)
			{
				ms=score(color,ms);
				lab2.setText("成績:"+ms);
				mode=0;
				repaint();
			}
		}
		else if (mode==6)
		{
			if ((x6-mx)*(x6-mx)+(y6-my)*(y6-my)<2500)
			{
				ms=score(color,ms);
				lab2.setText("成績:"+ms);
				mode=0;
				repaint();
			}
		}
	
	};
	public void mouseReleased(MouseEvent e){ };
	public void mouseClicked(MouseEvent e){ };

//滑鼠事件處理類別寫在這裡
/***主程式***/
	public static void main(String args[]) //程式起點
	{
		Samp app=new Samp(); //名稱改一改，啟動UI元件
		app.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
		}); //處理視窗關閉要求
		}
}