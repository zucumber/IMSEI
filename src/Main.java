import java.awt.Container;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.sql.Connection;
import javax.swing.GroupLayout;

public class Main{

	static JFrame frame1= new JFrame();
	static JFrame frame2= new JFrame();
	static JFrame frame3= new JFrame();
	
	//constructor
	public Main (){
		frame1.setVisible(true);
		frame2.setVisible(false);
		frame3.setVisible(false);
		frame1.setSize(500, 300);	
		frame2.setSize(100,100);
		frame3.setSize(500,500);
	}
	
	public static void test(String str){
		System.out.println(str);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JComponent panel = new JComponent("gdfhkjhfa");
		JLabel labelt1 = new JLabel("label1");
		JLabel labelt2 = new JLabel("label2");
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		
		layout.setAutoCreateContainerGaps(true);
		GroupLayout.SequentialGroup	hGroup = layout.createSequentialGroup();
		hGroup.addGroup(layout.createParallelGroup().addComponent(labelt1).addComponent(labelt2));
		layout.setHorizontalGroup(hGroup);
		
		panel.setVisible(true);
		
		Main openMain = new Main();
		//Container cont = null;
		
		final JTextField tf1 = new JTextField("Please fill anything.");
		final JTextField tfInBook = new JTextField("1");
		JLabel label=new JLabel("Book");
		
		JButton btn1 = new JButton("btn");
		JButton btn2 = new JButton("Input Inventory");
		JButton btn3 = new JButton("Back");
		JButton btn4 = new JButton("Output Inventory");
		JButton btn5 = new JButton("Back");
		
		//input book
		JButton btnInBook = new JButton("Insert Book");
		
		btnInBook.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Database DB =new Database();
				//DB.inputDB("book",7,tfInBook.getText());
				DB.addDB("items","book",7);
				System.out.println("dd");
				DB.outputDB("book",tfInBook.getText());
			}
		});
		
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Database DB =new Database();
				//test(tf1.getText());
				//DB.initialDB();
				DB.inputDB("studname",7,tf1.getText());
				String idL=DB.getLastId("studname");
				DB.inputDB("studname",Integer.parseInt(idL)+1,tf1.getText()); //iterate id number for new input
				DB.outputDB("studname",tf1.getText()); 
			}
		});
		
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame1.setVisible(false);
				frame3.setVisible(false);
				frame2.setVisible(true);
			}
			
		});
		
		btn3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame2.setVisible(false);
				frame3.setVisible(false);
				frame1.setVisible(true);
				
			}
		});
		
		btn4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame2.setVisible(false);
				frame1.setVisible(false);
				frame3.setVisible(true);
				
			}
		});
		
		btn5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame2.setVisible(false);
				frame3.setVisible(false);
				frame1.setVisible(true);
			}
		});
		
		//frame1
		frame1.setLayout(new FlowLayout());
		frame2.setLayout(new FlowLayout());
		frame3.setLayout(new FlowLayout());
		frame1.add(tf1);
		frame1.add(btn1);
		frame1.add(btn2);
		frame1.add(btn4);
		frame1.setVisible(true);

		//frame2
		frame2.add(btn3);
		frame2.add(label);
		frame2.add(btnInBook);
		frame2.add(tfInBook);
		
		//frame3
		frame3.add(btn5);
	}
}
