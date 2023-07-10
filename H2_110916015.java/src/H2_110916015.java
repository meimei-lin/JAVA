import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color; 
public class H2_110916015 extends JFrame {
	static JFrame window=new JFrame("我的計算機");
	private JPanel bPanel=new JPanel();
	private JButton btn7=new JButton("7");
	private JButton btn8=new JButton("8");
	private JButton btn9=new JButton("9");
	private JButton btnAdd=new JButton("+");
	private JButton btn4=new JButton("4");
	private JButton btn5=new JButton("5");
	private JButton btn6=new JButton("6");
	private JButton btnSub=new JButton("-");
	private JButton btn1=new JButton("1");
	private JButton btn2=new JButton("2");
	private JButton btn3=new JButton("3");
	private JButton btnMultipus=new JButton("*");
	private JButton btn0=new JButton("0");
	private JButton btnResult=new JButton("=");
	private JButton ACbtn=new JButton("清空");
	private JButton btnDivide=new JButton("/");

	private JTextField txt=new JTextField(15);
	private List<String>lists=new ArrayList<String>(); 
	
	public static void main(String[] args){
		window.getContentPane().setBackground(Color.pink);
		try {
			new H2_110916015().init();
		}
		catch (Exception e) {
			System.exit(0); 
		}
	}
	public void init() throws Exception{
		bPanel.setLayout(new GridLayout(4,3)); 
		bPanel.add(btn7);
		bPanel.add(btn8);
		bPanel.add(btn9);
		bPanel.add(btnAdd);
		bPanel.add(btn4);
		bPanel.add(btn5);
		bPanel.add(btn6);
		bPanel.add(btnSub);
		bPanel.add(btn1);
		bPanel.add(btn2);
		bPanel.add(btn3);
		bPanel.add(btnMultipus);
		bPanel.add(btn0);
		bPanel.add(ACbtn);
		bPanel.add(btnResult);
		bPanel.add(btnDivide);
		window.add(txt,BorderLayout.NORTH); 
		window.add(bPanel);            
		window.add(bPanel,BorderLayout.SOUTH); 
		ACbtn.addActionListener(e->{
			String text=txt.getText();
			if("".equals(text)){
				return;
			}
			if("+".equals(text) || "-".equals(text) || "*".equals(text) || "/".equals(text)){
				lists.remove(0);
			}
			txt.setText("");  
		});
		ActionListener BtnListener=new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String text=txt.getText();
				if("除數不能為0".equals(text)){
					txt.setText(e.getActionCommand());
					return;
				}
				if(text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/")){
					lists.add(text); 
					txt.setText("");
					text=""; 
				}
				text=text+e.getActionCommand();
				txt.setText(text);
				
			}
		};

		btn1.addActionListener(BtnListener);
		btn2.addActionListener(BtnListener);
		btn3.addActionListener(BtnListener);
		btn4.addActionListener(BtnListener);
		btn5.addActionListener(BtnListener);
		btn6.addActionListener(BtnListener);
		btn7.addActionListener(BtnListener);
		btn8.addActionListener(BtnListener);
		btn9.addActionListener(BtnListener);
		btn0.addActionListener(e->{
			String text=txt.getText();
			if("+".equals(text) || "-".equals(text) || "*".equals(text) || "/".equals(text)){
				lists.add(text);
				text=""; 
			}
			text=text+e.getActionCommand();
			txt.setText(text);
		});
		ActionListener opeBtnListener=new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String text=txt.getText();
				if("".equals(text)){
					return;
				}
				if("+".equals(text) || "-".equals(text) || "*".equals(text) || "/".equals(text)){
					return;
				}
				lists.add(text);
				txt.setText("");
				txt.setText(e.getActionCommand());
			}
		};
		btnAdd.addActionListener(opeBtnListener);
		btnSub.addActionListener(opeBtnListener);
		btnMultipus.addActionListener(opeBtnListener);
		btnDivide.addActionListener(opeBtnListener);
		ActionListener resultBtnListener=new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(lists.isEmpty()){
					return;
				}
				String text=txt.getText();
				if("".equals(txt) || "+".equals(text) || "-".equals(text) || "*".equals(text) || "/".equals(text)){
					return;
				}
				lists.add(text);
				if(lists.size()<3){
					return;
				}
				String one=lists.get(0); 
				String two=lists.get(1); 
				String three=lists.get(2); 
				switch(two){
				case "+":
					double i=Double.parseDouble(one);
					double j=Double.parseDouble(three);
					txt.setText((i+j)+"");
					break;
				case "-":
					double x=Double.parseDouble(one);
					double y=Double.parseDouble(three);
					txt.setText((x-y)+""); 
					break;
					
				case "*":
					double a=Double.parseDouble(one);
					double b=Double.parseDouble(three);
					txt.setText((a*b)+"");
					break;
				case "/":
					double c=Double.parseDouble(one);
					double d=Double.parseDouble(three);
					try {
						if(d==0){
							txt.setText("除數不能為0");
							lists.clear();
							return;
						}
						txt.setText((c/d)+"");
					}
					catch(ArithmeticException ne) {}
					break;
				}
				lists.clear();
			}
		};
		btnResult.addActionListener(resultBtnListener);
		
		SwingUtilities.updateComponentTreeUI(window.getContentPane());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(300,300); 
		window.setResizable(true);  
		window.pack();              
		window.setVisible(true); 
	}
}
