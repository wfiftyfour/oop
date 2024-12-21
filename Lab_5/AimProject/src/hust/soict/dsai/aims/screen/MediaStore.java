package hust.soict.dsai.aims.screen;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel{
   private Media media;
   public MediaStore(Media media)
   {
	   this.media= media;
	   this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	   
	   JLabel title = new JLabel(media.getTitle());
	   title.setFont(new Font(title.getFont().getName(),Font.PLAIN,20));
	   title.setAlignmentX(CENTER_ALIGNMENT);
	   
	   JLabel cost = new JLabel(""+media.getCost()+" $");
	   cost.setAlignmentX(CENTER_ALIGNMENT);
	   
	   JPanel container = new JPanel();
	   container.setLayout(new FlowLayout(FlowLayout.CENTER));
	   JButton btncart= new JButton("Add to cart");
	   btncart.addActionListener(new ButtonListener());
	   container.add(btncart);
	   if(media instanceof Playable)
	   {
		   JButton btnplay=new JButton("Play");
		   btnplay.addActionListener(new ButtonListener());
		   container.add(btnplay);
	   }
	   this.add(Box.createVerticalGlue());
	   this.add(title);
	   this.add(cost);
	   this.add(Box.createVerticalGlue());
	   this.add(container);
	   this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	   
   }
   private class ButtonListener implements ActionListener
   {

	@Override
	public void actionPerformed(ActionEvent e) {
		   String button = e.getActionCommand();
		   //xu li button play
		   if(button.equals("Play"))
		   {
				 if(media instanceof DigitalVideoDisc) {
					 //Play for DVD
				     DigitalVideoDisc dvd = (DigitalVideoDisc)media;
					  JFrame frame = new JFrame("JOptionPane showMessageDialog example");
					  if(dvd.getLength()>0)
						  JOptionPane.showMessageDialog(frame,
					                "DVD length: " + dvd.getLength(),
					                dvd.title+ " is playing",
					                JOptionPane.INFORMATION_MESSAGE);
					  else
						  JOptionPane.showMessageDialog(frame,
					                "ERROR: DVD length is non-positive!",
					                dvd.title+ " ERROR",
					                JOptionPane.ERROR_MESSAGE);
				 }
				 else
				 {   //Play for CD
					  CompactDisc cd = (CompactDisc)media;
					  JFrame frame = new JFrame("JOptionPane showMessageDialog example");
					  if(cd.getLength()>0)
						  JOptionPane.showMessageDialog(frame,
					                "CD length: " + cd.getLength(),
					                cd.title+ " is playing",
					                JOptionPane.INFORMATION_MESSAGE);
					  else
						  JOptionPane.showMessageDialog(frame,
					                "ERROR: CD length is non-positive!",
					                cd.title+ " ERROR",
					                JOptionPane.ERROR_MESSAGE);
				 }
		   }
		   else
		   {//Add to static cart Aims.Mediacart
			   Aims.Mediacart.addMedia(media);
			   JFrame frame = new JFrame("JOptionPane showMessageDialog example");
				  JOptionPane.showMessageDialog(frame,
			                "Add "+media.getTitle()+ " to Cart",
			                "Add to cart",
			                JOptionPane.INFORMATION_MESSAGE);
			   
		   }
	}
	  
   }
}
