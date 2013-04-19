
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;


public class sample_GroupLayout {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
	    JPanel panel = new JPanel();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    GroupLayout layout = new GroupLayout(panel);
	    panel.setLayout(layout);

	    JButton buttonD = new JButton("D");
	    JButton buttonR = new JButton("R");
	    JButton buttonY = new JButton("Y");
	    JButton buttonO = new JButton("O");
	    JButton buttonT = new JButton("T");

	    GroupLayout.SequentialGroup leftToRight = layout.createSequentialGroup();

	    leftToRight.addComponent(buttonD);
	    GroupLayout.ParallelGroup columnMiddle = layout.createParallelGroup();
	    columnMiddle.addComponent(buttonR);
	    columnMiddle.addComponent(buttonO);
	    columnMiddle.addComponent(buttonT);
	    leftToRight.addGroup(columnMiddle);
	    leftToRight.addComponent(buttonY);

	    GroupLayout.SequentialGroup topToBottom = layout.createSequentialGroup();
	    GroupLayout.ParallelGroup rowTop = layout.createParallelGroup();
	    rowTop.addComponent(buttonD);
	    rowTop.addComponent(buttonR);
	    rowTop.addComponent(buttonY);
	    topToBottom.addGroup(rowTop);
	    topToBottom.addComponent(buttonO);
	    topToBottom.addComponent(buttonT);

	    layout.setHorizontalGroup(leftToRight);
	    layout.setVerticalGroup(topToBottom);

	    frame.add(panel);
	    frame.pack();
	    frame.setVisible(true);

	}

}
