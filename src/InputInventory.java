
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
	JPanel panInItem1 = new JPanel();
	JPanel panButton = new JPanel();
	JPanel panTitle = new JPanel();
	JPanel panLeft = new JPanel();
	
	JPanel container = new JPanel();
	JPanel containerBottom = new JPanel();
	
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
    JLabel title=new JLabel("Input Inventory");
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
		
		//layout for label and comboBox
		GroupLayout layInItem = new GroupLayout(panInItem1);
	    panInItem1.setLayout(layInItem);
	    
	    //layout for buttons
	    GroupLayout layButton = new GroupLayout(panButton);
	    panButton.setLayout(layButton);
	    
	   // panInItem2.setLayout(new FlowLayout());
	    container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
	    containerBottom.setLayout(new BoxLayout(containerBottom, BoxLayout.X_AXIS));
	    panTitle.add(title);
	    
	    
	    
	    //panel positioning by adding gaps
	    panInItem1.setBorder(BorderFactory.createEmptyBorder(0, 0, 100, 0));
	    panButton.setBorder(BorderFactory.createEmptyBorder(0, 50, 100, 0));
	    
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
	
	    //buttons layout
	    GroupLayout.SequentialGroup XlayButton = layButton.createSequentialGroup();
	    GroupLayout.ParallelGroup XPar = layButton.createParallelGroup();
	    XPar.addComponent(butInsert);
	    XPar.addComponent(butCancel);
	    XlayButton.addGroup(XPar);
	    
	    GroupLayout.SequentialGroup YlayButton = layButton.createSequentialGroup();
	    YlayButton.addComponent(butInsert);
	    YlayButton.addComponent(butCancel);
	   	    
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
	   // GroupLayout.ParallelGroup Buttons = layInItem.createParallelGroup();
	    //Buttons.addComponent(butInsert);
	    //Buttons.addComponent(butCancel);
	        
	    /*Making a Horizontal Layout*/
	    leftToRight.addGroup(Label_Combo1);
	    leftToRight.addGroup(Label_Combo2);
	    //leftToRight.addGroup(Buttons);
	    //panButton.add(butInsert);
	    //panButton.add(butCancel);

	    
	    /*Vertical Layout*/
	    GroupLayout.SequentialGroup topToBottom = layInItem.createSequentialGroup();
	    
	    /*Grouping Label and combo Box and Insert button*/
	    GroupLayout.ParallelGroup row1 = layInItem.createParallelGroup();
	    row1.addComponent(labBook);
	    row1.addComponent(comBook);
	    //row1.addComponent(butInsert);
	    /*Grouping Label and combo Box and Cancel button*/
	    GroupLayout.ParallelGroup row2 = layInItem.createParallelGroup();
	    row2.addComponent(labPencil);
	    row2.addComponent(comPencil);
	   // row2.addComponent(butCancel);
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
	    
	    layButton.setHorizontalGroup(XlayButton);
	    layButton.setVerticalGroup(YlayButton);
	    
	    /*set gap between component in layout*/
	    layInItem.setAutoCreateGaps(true);
	    layButton.setAutoCreateGaps(true);
	    
	    //containerBottom.add(panLeft);//deploy containerLeft if needed
	    containerBottom.add(panInItem1);
	    containerBottom.add(panButton);
	    //containerBottom.add(butInsert);
	    //containerBottom.add(butCancel);
	    container.add(panTitle);
	   // container.add(panInItem1);
	    container.add(containerBottom);
	    
	    /*setting frame*/
	    frInItem.add(container);
		//frInItem.add(panInItem);
	    frInItem.pack(); 
	    
	   /*starting location of frame*/
	    //frInItem.setLocationRelativeTo(null);
	    
	    /*accept close button on WS*/
	    frInItem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //frInItem.setBounds(40, 40, 400, 400);
	    frInItem.setSize(400, 300);
	    frInItem.setVisible(true);
	    
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Declaration*/
		InputInventory gui = new InputInventory(0,0,0);
		
	}

}
