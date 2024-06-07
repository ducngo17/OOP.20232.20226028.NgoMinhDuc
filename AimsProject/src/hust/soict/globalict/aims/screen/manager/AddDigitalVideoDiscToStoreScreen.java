package hust.soict.globalict.aims.screen.manager;
import hust.soict.globalict.aims.store.*;
import hust.soict.globalict.aims.media.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField IDInput;
    private JTextField TitleInput;
    private JTextField CategoryInput;
    private JTextField DirectorInput;
    private JTextField LengthInput;
    private JTextField CostInput;

    JPanel createCenter() {
        ConfirmListener cfListener = new ConfirmListener();

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(7,2));
        
        center.add(new JLabel("Enter ID"));
        IDInput = new JTextField(20);
        center.add(IDInput);

        center.add(new JLabel("Enter title"));
        TitleInput = new JTextField(20);
        center.add(TitleInput);

        center.add(new JLabel("Enter category"));
        CategoryInput = new JTextField(20);
        center.add(CategoryInput);

        center.add(new JLabel("Enter director"));
        DirectorInput = new JTextField(20);
        center.add(DirectorInput);

        center.add(new JLabel("Enter length"));
        LengthInput = new JTextField(20);
        center.add(LengthInput);

        center.add(new JLabel("Enter cost"));
        CostInput = new JTextField(20);
        center.add(CostInput);

        center.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(cfListener);
		
		container.add(confirmButton);
		
		center.add(Box.createVerticalGlue());
		center.add(container);

        return center;
    }
    
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
    }

    private class ConfirmListener implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e) {
            String button = e.getActionCommand();
            if (button.equals("Confirm")){
                int id = Integer.parseInt(IDInput.getText());
                String title = TitleInput.getText();
                String category = CategoryInput.getText();
                String director = DirectorInput.getText();
                int length = Integer.parseInt(LengthInput.getText());
                float cost = Float.parseFloat(CostInput.getText());
                DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, director, length, cost);
                store.addMedia(dvd);
                JOptionPane.showMessageDialog(null, "Add DVD successfully");     
            }               
        }
    }
}