
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;


public class SisGui {

	/* Declare Frame*/
	JFrame fr=new JFrame();
	JPanel pan = new JPanel();
	//JPanel panInItem = new JPanel(new BorderLayout(50,10));
	
	/*Declare Button*/
    JButton btnIn = new JButton("Inventory Input");
    JButton btnOut = new JButton("Inventory Output");
    
	/**
	 * @param args
	 */
	
	private SisGui(){
		
		GroupLayout lay = new GroupLayout(pan);
	    pan.setLayout(lay);
	    
	    //panel positioning by adding gaps
	    pan.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
	    
	    /*add listener into buttons (butCancel)*/
	    btnIn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				InputInventory In = new InputInventory(0,0,0);
			}
		});
	    
	    /*add listener into buttons (butCancel)*/
	    btnOut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//OutputInventory In = new OutputInventory();
				System.out.println("Output Inventory is not ready yet!");
				/*The frame before this frame(frInItem) is not ready yet*/
			}
		});
	    
	    
	    /*Horizontal Layout Instance*/
	    GroupLayout.SequentialGroup leftToRight = lay.createSequentialGroup();
	    
	    /*Grouping buttons*/
	    GroupLayout.ParallelGroup btn = lay.createParallelGroup();
	    btn.addComponent(btnIn);
	    btn.addComponent(btnOut);
	    
	    
	    /*Making a Horizontal Layout*/
	    leftToRight.addGroup(btn);
	    
	    /*Vertical Layout*/
	    GroupLayout.SequentialGroup topToBottom = lay.createSequentialGroup();
	    
	    /*Making a Vertical Layout*/
	    topToBottom.addComponent(btnIn);
	    topToBottom.addComponent(btnOut);

	    /*set Horizontal and vertical layout*/
	    lay.setHorizontalGroup(leftToRight);
	    lay.setVerticalGroup(topToBottom);
	    
	    /*set gap between component in layout*/
	    lay.setAutoCreateGaps(true);
	    
	    /*setting frame*/
		fr.add(pan);
	    fr.pack(); 
    
	    /*accept close button on WS*/
	    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    fr.setSize(500, 500);
	    fr.setVisible(true);
	   
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Declaration*/
		SisGui gui = new SisGui();
		
	}

}
