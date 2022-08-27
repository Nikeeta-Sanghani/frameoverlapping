/*
 * THS IS AN SIMPLE EXAMPLE OF FRAMEOVERLAPING
 */
package frameoverlapping;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.print.attribute.AttributeSetUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class frameoverlapping extends JFrame implements ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    JFrame firstframe;
    JFrame secondframe;
    JButton nextbutton = new JButton("Next Frame");
    JButton previousbutton = new JButton("Previous Frame");
    public frameoverlapping()
    {
	initialize();
    }
    public static void main(String[] args) {
   	EventQueue.invokeLater(new Runnable() {
   	    public void run() {
   		try {
   			// it is to make sure that after clicking on previous frame only the first frame is to be shown
   			 frameoverlapping window = new frameoverlapping();
			window.firstframe.setVisible(true);
			//window.firstframe.setOpacity((float) 0.7);  // you cannot use here because the frame is decorated e.g. title color font etc.
   		    new frameoverlapping();
   		} catch (Exception e) {
   		    e.printStackTrace();
   		}
   	    }
   	});
       }
	private void initialize() {
	    firstframe= new JFrame();
	    secondframe=new JFrame();
		firstframe.setLayout(null);
		secondframe.setLayout(null);
		firstframe.setBounds(100,100, 1000, 1000);  // full size of the frame
		firstframe.setVisible(true);
		firstframe.setResizable(false);
		//firstframe.setUndecorated(true);
		
		secondframe.setBounds(100, 500, 1000, 600);
		secondframe.getContentPane().setBackground( Color.ORANGE );
		secondframe.setFont(new Font("Arial", Font.PLAIN, 14));
		secondframe.setTitle("Child Frame");
			
		secondframe.setResizable(false);
		previousbutton.setBounds(20,10,170,40);
		previousbutton.setVisible(true);
		previousbutton.addActionListener(this);
		nextbutton.setBounds(20, 10, 170, 40);
		nextbutton.setVisible(true);
		nextbutton.addActionListener(this);
		firstframe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		firstframe.getContentPane().setBackground( Color.PINK );
	    firstframe.setFont(new Font("Arial", Font.PLAIN, 14));
	    firstframe.setTitle("Parent Frame");
	    firstframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		firstframe.getContentPane().add(nextbutton);
		secondframe.getContentPane().add(previousbutton);
	}
    @Override
    public void actionPerformed(ActionEvent e) {
	if (e.getSource()==nextbutton)
	{
	    firstframe.setVisible(false);
	    nextbutton.setVisible(false);
	    secondframe.setVisible(true);
	}
	if (e.getSource()==previousbutton)
	{
	    secondframe.setVisible(false);
	    secondframe.dispose();  // this means all the values including any variables , objects their properties etc are not referenceble now
	    firstframe.setVisible(true);
	    nextbutton.setVisible(true);
	}
    }
}