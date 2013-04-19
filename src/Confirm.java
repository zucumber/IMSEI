import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Confirm {

	int book;
	int pencil;
	int eraser;
	
	/*Frame and Panel*/
	JFrame frConfirm = new JFrame();
	JFrame frOK = new JFrame();
	JPanel panConfirm = new JPanel();
	JPanel panfrOK = new JPanel();
	
	/*Buttons*/
	JButton btnOK =new JButton("Confirm");
	JButton btnCancel =new JButton("Cancel");
	
	JButton btnfrOK =new JButton("OK");
	
	/*Labels*/
	JLabel labConfBook = new JLabel("Book :");
	JLabel labConfPencil = new JLabel("Pencil :");
	JLabel labConfEraser = new JLabel("Eraser :");
	
	JLabel labfrOK = new JLabel("Data saved. Click OK to return to top page");
	
	/*Item's Amount Label*/
	JLabel labConfBookAm;
	JLabel labConfPencilAm;
	JLabel labConfEraserAm;
	
	/**
	 * @param args
	 */
	public Confirm(final int book, final int pencil, final int eraser){
		this.book=book;
		this.pencil=pencil;
		this.eraser=eraser;
		
		labConfBookAm = new JLabel(Integer.toString(book));
		labConfPencilAm = new JLabel(Integer.toString(pencil));
		labConfEraserAm = new JLabel(Integer.toString(eraser));
		
		
		 /*add listener into buttons (butInsert)*/
	    btnOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Database DB =new Database();
				/*Need to update all method in Confirm(),SisGui() classes  
				 * if there is any changes on database name
				 * 
				 */
				//DB.addDB("For Debug in case Database not found","book",comBook.getSelectedIndex());
				DB.addDB("items","book", book);
				DB.addDB("items","pencil",pencil);
				DB.addDB("items","eraser",eraser);
				
				frConfirm.setVisible(false);
				frOK.setVisible(true);
				
			}
		});
	    
	    /*add listener into buttons (butCancel)*/
	    btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frConfirm.setVisible(false);
				InputInventory con = new InputInventory(book,pencil,eraser);
			}
		});
	    
	    /*add listener into buttons (butCancel)*/
	    btnfrOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frOK.setVisible(false);
			}
		});
		
		
		GroupLayout layConfirm = new GroupLayout(panConfirm);
		panConfirm.setLayout(layConfirm);
		
		//panel positioning by adding gaps
	    panConfirm.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
	    
		/*Horizontal Layout Instance*/
	    GroupLayout.SequentialGroup leftToRight = layConfirm.createSequentialGroup();
	    
	    /*Grouping Labels*/
	    GroupLayout.ParallelGroup Label1 = layConfirm.createParallelGroup();
	    Label1.addComponent(labConfBook);
	    Label1.addComponent(labConfPencil);
	    Label1.addComponent(labConfEraser);
	    
	    /*Grouping ComboBoxes*/
	    GroupLayout.ParallelGroup Label2 = layConfirm.createParallelGroup();
	    Label2.addComponent(labConfBookAm);
	    Label2.addComponent(labConfPencilAm);
	    Label2.addComponent(labConfEraserAm);
	    
	    /*Grouping Buttons*/
	    GroupLayout.ParallelGroup Btns = layConfirm.createParallelGroup();
	    Btns.addComponent(btnOK);
	    Btns.addComponent(btnCancel);
	        
	    /*Making a Horizontal Layout*/
	    leftToRight.addGroup(Label1);
	    leftToRight.addGroup(Label2);
	    leftToRight.addGroup(Btns);

	    
	    /*Vertical Layout*/
	    GroupLayout.SequentialGroup topToBottom = layConfirm.createSequentialGroup();
	    
	    /*Grouping Label and combo Box and Insert button*/
	    GroupLayout.ParallelGroup row1 = layConfirm.createParallelGroup();
	    row1.addComponent(labConfBook);
	    row1.addComponent(labConfBookAm);
	    row1.addComponent(btnOK);
	    /*Grouping Label and combo Box and Cancel button*/
	    GroupLayout.ParallelGroup row2 = layConfirm.createParallelGroup();
	    row2.addComponent(labConfPencil);
	    row2.addComponent(labConfPencilAm);
	    row2.addComponent(btnCancel);
	    /*Grouping Label and combo Box*/
	    GroupLayout.ParallelGroup row3 = layConfirm.createParallelGroup();
	    row3.addComponent(labConfEraser);
	    row3.addComponent(labConfEraserAm);  
   
	    /*Making a Vertical Layout*/
	    topToBottom.addGroup(row1);
	    topToBottom.addGroup(row2);
	    topToBottom.addGroup(row3);
	    	    
	    /*set Horizontal and vertical layout*/
	    layConfirm.setHorizontalGroup(leftToRight);
	    layConfirm.setVerticalGroup(topToBottom);
	    
	    /*set gap between component in layout*/
	    layConfirm.setAutoCreateGaps(true);
		/********/
		
	    frConfirm.add(panConfirm);
	    frConfirm.pack();
	    frConfirm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frConfirm.setSize(500, 500);
		frConfirm.setVisible(true);
		
		panfrOK.add(labfrOK);
		panfrOK.add(btnfrOK);
		frOK.add(panfrOK);
		frOK.setSize(300, 200);
		
		System.out.println("book="+book + ", pencil =" + pencil + ", eraser =" + eraser);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Confirm confirmOK= new Confirm(1,2,3);
	}

}
