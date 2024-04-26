package ui;

import java.awt.Font;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class EscribirPage extends JFrame{

    JFrame frame = new JFrame();              //Creates the new frame
    JLabel label = new JLabel("Hello");  //Creates a label
    Date fecha = new Date();                  //Fecha



    EscribirPage(){

        JMenuBar mb = new JMenuBar();

        JMenu menu = new JMenu("File");
        mb.add(menu);

        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem salir = new JMenuItem("Salir");  

        menu.add(guardar);
        menu.add(salir);

        mb.add(menu);

        frame.setJMenuBar(mb);


        






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
