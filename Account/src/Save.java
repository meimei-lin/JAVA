

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
/**
 * 
 * 存檔
 *
 */
@SuppressWarnings("serial")
public class  Save extends JFrame {
	static JTextArea jText = new JTextArea();
	JFrame frame = new JFrame();
	Account a = new Account();
	
	public void SaveAccount(int sum) {
		String t = "您的帳戶有:"+String.valueOf(sum)+"元";
		jText.setText(t);
	}
	
	/**
	 * 存檔的函示
	 */
	public void save() {	

		String text = jText.getText();
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory( new File( "./") );
        int actionDialog = chooser.showSaveDialog(this);
        if (actionDialog == JFileChooser.APPROVE_OPTION)
        {
            File fileName = new File(chooser.getSelectedFile( ) + "" );
            if(fileName.exists())
            {
                actionDialog = JOptionPane.showConfirmDialog(this,
                                   "Replace existing file?");
                if (actionDialog == JOptionPane.NO_OPTION)
                    return;
            }
            try
            {
                BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

                    out.write(text);
                    out.close();
            }
            catch(Exception e)
            {
                 System.err.println("Error: " + e.getMessage());
            }
        }
	}
}
