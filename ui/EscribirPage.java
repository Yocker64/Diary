package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
import javax.swing.ScrollPaneConstants;

public class EscribirPage extends JFrame implements ActionListener {

  JTextArea textoArea = new JTextArea(40, 30);
  JTextField tituloField = new JTextField(20); // 20 caracteres de ancho
  JFrame frame = new JFrame(); // Creates the new frame
  Date fecha = new Date(); // Metí la fecha del dia de hoy en la variable
                           // el formato es este: Fri Apr 26 05:49:41 CST 2024
  String datoDeFecha = fecha.toString().substring(0, Math.min(28, 10));  //Creates a string of 10 characters, ideal to name my files
  JLabel label = new JLabel(datoDeFecha); // Creates a label
  File file = new File("filename.txt"); // Creates a file

  EscribirPage() {

    ImageIcon menuIcon = new ImageIcon("images/ellipsis-v-icon.png"); // Creates an object of the icon

    JMenuBar mb = new JMenuBar(); // Creates the menubar

    JMenu menu = new JMenu(""); // Creates the name of the menu
    menu.setIcon(menuIcon); // Adds the icon of the three dots ellipsis-v-icon.png
    mb.add(menu); // Adds menu to the menu bar

    JMenuItem guardar = new JMenuItem("Guardar"); // creates the Item Guardar
    JMenuItem salir = new JMenuItem("Menu Principal"); // Creates the item menú principal

    ImageIcon guardarIcon = new ImageIcon("images/save-icon.png"); // Creates an object of the icons
    ImageIcon menuPricipalIcon = new ImageIcon("images/home-icon.png"); // Creates an object of the icons

    guardar.setIcon(guardarIcon); // Adds the icons to the items
    salir.setIcon(menuPricipalIcon); // Adds the icons to the items

    guardar.addActionListener(this); // Adds the action listeners
    salir.addActionListener(this);

    guardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));  //Esto es opcional, son solo los acordes para crear acceso mas rapido a distintas funciones
    salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

    menu.add(guardar); // Adds both options or items
    menu.add(salir);

    mb.add(menu);

    frame.setJMenuBar(mb); // Sets the menubar into the JFrame

    label.setBounds(400, 0, 100, 50); // Set the bounds for the label

    // Crear un JTextField

    tituloField.setText("Escribe el título aquí");
    tituloField.addFocusListener(new FocusListener() {
      @Override
            public void focusGained(FocusEvent e) {
                if (tituloField.getText().equals("Type your message here...")) {
                    tituloField.setText("");
                }
            }

      @Override
      public void focusLost(FocusEvent e) {
        // TODO Auto-generated method stub
        if (textoArea.getText().isEmpty()) {
          textoArea.setText("Type your message here...");
      }
      }
      
    });
    tituloField.setBounds(150, 10, 200, 20);

    textoArea.setBackground(Color.LIGHT_GRAY);
    textoArea.setText("Escribe tus pensamientos aquí");

    JScrollPane scroll = new JScrollPane(textoArea);

    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED); // Creates the when to show the
                                                                                         // scroll pane policies.
    scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); // Creates the when to show
                                                                                             // the scroll pane
                                                                                             // policies.
    scroll.setBounds(20, 40, 2000, 150);
    textoArea.setBounds(20, 40, 2000, 150);

    label.setFont(new Font(null, Font.PLAIN, 15)); // Sets the font

    frame.add(label); // adds the label

    // Agregar el JTextField al JFrame con restricciones de BorderLayout
    // frame.add(textoArea);
    frame.add(tituloField);
    frame.add(scroll, BorderLayout.SOUTH);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Make the program end when you close the window
    frame.setSize(500, 500); // Setting the dimensions of the frame
    frame.setLayout(new BorderLayout());
    frame.setVisible(true); // Make the window visible
    frame.setLocationRelativeTo(null); // Makes the window appear at the center of the screen


    try {
            BufferedReader reader = new BufferedReader(new FileReader("Information/"+datoDeFecha));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
                textoArea.append(linea+"\n");
            }

            reader.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

  }

  @Override
  public void actionPerformed(ActionEvent e) { // Creates an action listener
    if (e.getSource() instanceof JMenuItem) {
      JMenuItem item = (JMenuItem) e.getSource();
      String text = item.getText();
      System.out.println(text);

      if (item.getText() == "Guardar") {

        File myObj = new File("Information/"+datoDeFecha);
        try {
          if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
            try {
              BufferedWriter writer = new BufferedWriter(new FileWriter("Information/"+datoDeFecha));
              writer.write(textoArea.getText());
              writer.newLine();
              writer.close();
              System.out.println(textoArea.getText());
            } catch (Exception e2) {
              // TODO: handle exception
            }

          } else {
            System.out.println("File already exists.");
            // EscribirArcchivo(textoArea.getText());
            try {
              BufferedWriter writer = new BufferedWriter(new FileWriter("Information/"+datoDeFecha));
              writer.write(textoArea.getText());
              writer.newLine();
              writer.close();
              System.out.println(textoArea.getText());
            } catch (Exception e2) {
              // TODO: handle exception
            }
          }
        } catch (IOException e1) {
          // TODO Auto-generated catch block
          System.out.println(e1.getMessage());
        }

      } else {

      }

    }

  }

  public void EscribirArcchivo(String entryOfTheDay) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("Information/filename.txt"));
      writer.write(entryOfTheDay);
      writer.close();
      System.out.println(entryOfTheDay);
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}