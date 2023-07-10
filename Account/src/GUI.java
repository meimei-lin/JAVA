import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI {
	final static JFrame jf = new JFrame("ATM");
	public GUI() {
		jf.setPreferredSize(new Dimension(300,200));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(null);	
		
		/*
		 * Button
		 */
		JButton RunButton = new JButton("開始");
		RunButton.setBounds(50, 50, 150, 35);
		RunButton.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
			 Run r = new Run();
			 r.run();
			 }
		 });
		GUI.jf.add(RunButton);
		
		JButton SaveButton = new JButton("儲存");
		SaveButton.setBounds(50, 100, 150, 35);
		SaveButton.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
			 Save s = new Save();
			 s.save();
			 }
		 });
		GUI.jf.add(SaveButton);
		
		jf.pack();
		jf.setVisible(true);
	}
}
