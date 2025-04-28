import  java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class splash extends JFrame{
	private JPanel contentpane;
	private static JProgressBar progressbar;
	private static JLabel label_1;
	public static void main(String[] args) {
		 int x;
						splash frame=new splash();
						frame.setVisible(true);
						try {
						for(x=0;x<100;x++) {
								splash.progressbar.setValue(x);
								Thread.sleep(50);
								splash.label_1.setText(Integer.toString(x)+"%");
								if(x==100) {
									frame.dispose();
									}
								
						} 
						}catch (InterruptedException e) {
			
							e.printStackTrace();
						
						}
						
					
	}
	public splash() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,500,400);
		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		JLabel label = new JLabel("");
		ImageIcon icon = new ImageIcon(this.getClass().getResource("C:\\Users\\alank\\Desktop\\pi0c.jpg"));
		label.setIcon(icon);
		label.setBounds(58,45,350,199);
		contentpane.add(label);
		
		
		JProgressBar progressbar =new JProgressBar();
		progressbar.setForeground( new Color(0, 128, 128));
		progressbar.setBounds(20, 350, 470, 16);
		contentpane.add(progressbar);
		
		
	}
	}		
	
