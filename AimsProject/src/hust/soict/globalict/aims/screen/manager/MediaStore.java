package hust.soict.globalict.aims.screen.manager;
import hust.soict.globalict.aims.media.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;

public class MediaStore extends JPanel{
    private Media media;

    //constructor
    public MediaStore(Media media) {
        ButtonListener btnListener = new ButtonListener();

        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(btnListener);
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }    

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            String button = e.getActionCommand();
            if (button.equals("Play")){
                JDialog dialog = new JDialog();
                dialog.setTitle("Play box");
                dialog.setLocationRelativeTo(null);
				dialog.setSize(new Dimension(300, 200));
				dialog.setVisible(true);
                JLabel label;
                if(media instanceof DigitalVideoDisc) {    
					DigitalVideoDisc toPlay = (DigitalVideoDisc) media;
					label = new JLabel("Playing DVD: " + toPlay.getTitle() + ", length: " + toPlay.getLength());
                    
                }
				else {
					CompactDisc toPlay = (CompactDisc) media;
					label = new JLabel("Playing CD: " + toPlay.getTitle()  + ", length: " + toPlay.getLength());
                }
                dialog.add(label);
            }
        }
    }
}