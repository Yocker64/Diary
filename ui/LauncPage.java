package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class LauncPage implements ActionListener{

    JFrame frame = new JFrame();   //Creating the Frame 
    JButton escribirButton = new JButton("Escribir");  //Creating buttons
    JButton visitarButton = new JButton("Visitar");  //Creating buttons
    JButton editarButton = new JButton("Editar");  //Creating buttons


    LauncPage(){

        escribirButton.setBounds(200,200, 100, 30);   // setting the bounds of the buttons
        visitarButton.setBounds(200,250, 100, 30);   //Where in the JFrame are they gonna be located
        editarButton.setBounds(200,300, 100, 30);   //and their size

        escribirButton.setFocusable(false);    //Preventing the buttons from being highlighted
        visitarButton.setFocusable(false);
        editarButton.setFocusable(false);
        
        escribirButton.addActionListener(this);   //Adding the action listener to the buttons
        visitarButton.addActionListener(this);   //Adding the action listener to the buttons
        editarButton.addActionListener(this);   //Adding the action listener to the buttons


        
        frame.add(escribirButton);    //Adding the buttons to the JFrame
        frame.add(visitarButton);     //If you dont do this the buttons wont be shown
        frame.add(editarButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Make the program end when you close the window
        frame.setSize(500 , 500);   //Setting the dimensions of the frame
        frame.setLayout(null);   
        frame.setVisible(true);   //Make the window visible
        frame.setLocationRelativeTo(null);   //Makes the window appear at the center of the screen

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==escribirButton){  //Si presionas el botón de escribir

            frame.dispose();
            EscribirPage escribirPage = new EscribirPage();

        }
        if(e.getSource()==visitarButton){    //Aqui adentro va la accion que quieres realizar cuando se presiona el boton
            
            frame.dispose();
            EditarPage editarPage = new EditarPage();
        }
        if(e.getSource()==editarButton){    //Aqui adentro va la accion que quieres realizar cuando se presiona el boton
            
            frame.dispose();
            VisitarPage visitarPage = new VisitarPage();
        }

   }
}
