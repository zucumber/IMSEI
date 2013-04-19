
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.GroupLayout;


public class InputInventory {

	int book;
	int pencil;
	int eraser;
	
	/* Declare Frame*/
	JFrame frInItem=new JFrame();
	JFrame frConfirm=new JFrame();
	JPanel panInItem = new JPanel();
	//JPanel panInItem = new JPanel(new BorderLayout(50,10));
	
	/*Declare Button*/
    JButton butInsert = new JButton("Insert");
    JButton butCancel = new JButton("Cancel");
    
    /*Declare ComboBox*/
    Integer[] intInItem = {0,1,2,3,4,5,6,7,8,9,10};
    JComboBox comBook = new JComboBox(intInItem);
    JComboBox comPencil = new JComboBox(intInItem);
    JComboBox comEraser = new JComboBox(intInItem);
    
    /*Declare Label*/
    JLabel labBook=new JLabel("Book");
    JLabel labPencil=new JLabel("Pencil");
    JLabel labEraser=new JLabel("Eraser");
	/**
	 * @param args
	 */
	
	public InputInventory(int book, int pencil, int eraser){
		
		this.book=book;
		this.pencil=pencil;
		this.eraser=eraser;
		
		comBook.setSelectedIndex(book);
		comPencil.setSelectedIndex(pencil);
		comEraser.setSelectedIndex(eraser);
		
		GroupLayout layInItem = new GroupLayout(panInItem);
	    panInItem.setLayout(layInItem);
	    
	    //panel positioning by adding gaps
	    panInItem.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
	    
	    /*Fix the size of ComboBox*/
	    comBook.setMaximumSize(comBook.getPreferredSize());
	    comPencil.setMaximumSize(comPencil.getPreferredSize());
	    comEraser.setMaximumSize(comEraser.getPreferredSize());
	   
	    /*add listener into buttons (butInsert)*/
	    butInsert.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Confirm showConfirm = new Confirm(
						comBook.getSelectedIndex(),
						comPencil.getSelectedIndex(),
						comEraser.getSelectedIndex()
							
				);
				frInItem.setVisible(false);				
				/*Need to update all method in Confirm(),SisGui() classes  
				 * if there is any changes on database name
				 * 
				 */
			}
		});
	    
	    /*add listener into buttons (butCancel)*/
	    butCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frInItem.setVisible(false);
				/*The frame before this frame(frInItem) is not ready yet*/
			}
		});
	    
	    
	    /*Horizontal Layout Instance*/
	    GroupLayout.SequentialGroup leftToRight = layInItem.createSequentialGroup();
	    
	    /*Grouping Labels*/
	    GroupLayout.ParallelGroup Label_Combo1 = layInItem.createParallelGroup();
	    Label_Combo1.addComponent(labBook);
	    Label_Combo1.addComponent(labPencil);
	    Label_Combo1.addComponent(labEraser);
	    
	    /*Grouping ComboBoxes*/
	    GroupLayout.ParallelGroup Label_Combo2 = layInItem.createParallelGroup();
	    Label_Combo2.addComponent(comBook);
	    Label_Combo2.addComponent(comPencil);
	    Label_Combo2.addComponent(comEraser);
	    
	    /*Grouping Buttons*/
	    GroupLayout.ParallelGroup Buttons = layInItem.createParallelGroup();
	    Buttons.addComponent(butInsert);
	    Buttons.addComponent(butCancel);
	        
	    /*Making a Horizontal Layout*/
	    leftToRight.addGroup(Label_Combo1);
	    leftToRight.addGroup(Label_Combo2);
	    leftToRight.addGroup(Buttons);

	    
	    /*Vertical Layout*/
	    GroupLayout.SequentialGroup topToBottom = layInItem.createSequentialGroup();
	    
	    /*Grouping Label and combo Box and Insert button*/
	    GroupLayout.ParallelGroup row1 = layInItem.createParallelGroup();
	    row1.addComponent(labBook);
	    row1.addComponent(comBook);
	    row1.addComponent(butInsert);
	    /*Grouping Label and combo Box and Cancel button*/
	    GroupLayout.ParallelGroup row2 = layInItem.createParallelGroup();
	    row2.addComponent(labPencil);
	    row2.addComponent(comPencil);
	    row2.addComponent(butCancel);
	    /*Grouping Label and combo Box*/
	    GroupLayout.ParallelGroup row3 = layInItem.createParallelGroup();
	    row3.addComponent(labEraser);
	    row3.addComponent(comEraser);  
   
	    /*Making a Vertical Layout*/
	    topToBottom.addGroup(row1);
	    topToBottom.addGroup(row2);
	    topToBottom.addGroup(row3);
	    	    
	    /*set Horizontal and vertical layout*/
	    layInItem.setHorizontalGroup(leftToRight);
	    layInItem.setVerticalGroup(topToBottom);
	    
	    /*set gap between component in layout*/
	    layInItem.setAutoCreateGaps(true);
	    
	    /*setting frame*/
		frInItem.add(panInItem);
	    frInItem.pack(); 
	    
	   /*starting location of frame*/
	    //frInItem.setLocationRelativeTo(null);
	    
	    /*accept close button on WS*/
	    frInItem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //frInItem.setBounds(40, 40, 400, 400);
	    frInItem.setSize(500, 500);
	    frInItem.setVisible(true);
	    
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Declaration*/
		InputInventory gui = new InputInventory(0,0,0);
		
	}

}
