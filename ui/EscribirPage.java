package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class EscribirPage extends JFrame implements ActionListener{

    JFrame frame = new JFrame();              //Creates the new frame
    JLabel label = new JLabel("Hello");  //Creates a label
    Date fecha = new Date();                  //Metí la fecha del dia de hoy en la variable 
                                              //el formato es este: Fri Apr 26 05:49:41 CST 2024

    

    EscribirPage(){


        ImageIcon menuIcon = new ImageIcon("images/ellipsis-v-icon.png");    //Creates an object of the icon
        
        JMenuBar mb = new JMenuBar();         //Creates the menubar
 
        JMenu menu = new JMenu("");         //Creates the name of the menu
        menu.setIcon(menuIcon);               //Adds the icon of the three dots ellipsis-v-icon.png
        mb.add(menu);                         //Adds menu to the menu bar

        JMenuItem guardar = new JMenuItem("Guardar");     // creates the Item Guardar
        JMenuItem salir = new JMenuItem("Menu Principal"); // Creates the item menú principal

        ImageIcon guardarIcon = new ImageIcon("images/save-icon.png");        //Creates an object of the icons
        ImageIcon menuPricipalIcon = new ImageIcon("images/home-icon.png");   //Creates an object of the icons

        guardar.setIcon(guardarIcon);       //Adds the icons to the items
        salir.setIcon(menuPricipalIcon);    //Adds the icons to the items

        guardar.addActionListener(this);    //Adds the action listeners 
        salir.addActionListener(this);

        guardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        menu.add(guardar);                                //Adds both options or items
        menu.add(salir);

        mb.add(menu);

        frame.setJMenuBar(mb);                           //Sets the menubar into the JFrame





        label.setBounds(0,0,100,50);            //Set the bounds for the label

         // Crear un JTextField
        JTextField tituloField = new JTextField(20); // 20 caracteres de ancho
        tituloField.setText("Escribe el título aquí");
        tituloField.setBounds(150,10,200,20);
        JTextArea textoArea = new JTextArea(40,30);
        textoArea.setText("Escribe tus pensamientos aquí");
        textoArea.setBounds(20,40,450,350);

        

        label.setFont(new Font(null, Font.PLAIN,15));  //Sets the font

        frame.add(label);                                        //adds the label


        // Agregar el JTextField al JFrame con restricciones de BorderLayout
        frame.add(textoArea);
        frame.add(tituloField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Make the program end when you close the window
        frame.setSize(500 , 500);   //Setting the dimensions of the frame
        frame.setLayout(null);   
        frame.setVisible(true);   //Make the window visible
        frame.setLocationRelativeTo(null);   //Makes the window appear at the center of the screen
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {   //Creates an action listener
        if(e.getSource() instanceof JMenuItem){    
            JMenuItem item = (JMenuItem) e.getSource();
            String text = item.getText();
            System.out.println(text);

            // if (item.getText()== "Guardar") {
            //     System.out.println(textoField.getText());
            // }
 
        }



    }

    

      
}
