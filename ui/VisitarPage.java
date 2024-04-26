package ui;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VisitarPage {
    JFrame frame = new JFrame();              //Creates the new frame
    JLabel label = new JLabel("Hello");  //Creates a label



    VisitarPage(){

        label.setBounds(0,0,100,50);            //Set the bounds for the label
        label.setFont(new Font(null, Font.PLAIN,25));  //Sets the font

        frame.add(label);                                        //adds the label

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Make the program end when you close the window
        frame.setSize(500 , 500);   //Setting the dimensions of the frame
        frame.setLayout(null);   
        frame.setVisible(true);   //Make the window visible
        frame.setLocationRelativeTo(null);   //Makes the window appear at the center of the screen
        
    }
}
