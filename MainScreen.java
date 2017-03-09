/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpark;

// Imports - awt //
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Imports - swing //
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
        
public class MainScreen extends JFrame implements ActionListener
{
    
    // Attributes // 
    
    private carPark park;
    private GridBagConstraints constraints;
    
    private JLabel lbl_status;
    private JLabel lbl_regNo;
    private JLabel lbl_colour;
    private JLabel lbl_make;
    private JLabel lbl_model;
    
    private JTextField txt_regNo;
    private JTextField txt_colour;
    private JTextField txt_make;
    private JTextField txt_model;
    
    private JButton btnAdd;
    private JButton btnRemove;
    
    public MainScreen()
    {
        park = new carPark();
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        constraints = new GridBagConstraints();
        
        // set up our components //
        initComponents();
        
        // Create Layout //
        layoutComponents();
    }
    
    public void initComponents()
    {
    lbl_status = new JLabel("Car park has" + park.spacesRemaining() + " remaining");
    lbl_regNo = new JLabel("RegNo");
    lbl_colour = new JLabel("Colour");
    lbl_make = new JLabel("Make");
    lbl_model = new JLabel("Model");
    
    txt_regNo = new JTextField();
    txt_colour = new JTextField();
    txt_make = new JTextField();
    txt_model = new JTextField();
    
    btnAdd = new JButton("Add");
    btnAdd.addActionListener(this);
    btnRemove = new JButton("Remove");
    btnRemove.addActionListener(this);
    }
    
    public void layoutComponents()
    {
      
        constraints.gridy = 0;
        constraints.gridx = 0;
        this.add(lbl_regNo, constraints);
        
        constraints.gridy = 1;
        this.add(lbl_colour, constraints);
        
        constraints.gridy = 2;
        this.add(lbl_make, constraints);
        
        constraints.gridy = 3;
        this.add(lbl_model, constraints);
        
        constraints.gridy = 0;
        constraints.gridx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(txt_regNo, constraints);
        
        constraints.gridy=1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(txt_colour, constraints);
        
        constraints.gridy=2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(txt_make, constraints);

        constraints.gridy=3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(txt_model, constraints);
        
        constraints.gridy = 4;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        this.add(lbl_status, constraints);
        
        constraints.gridwidth = 1;
        constraints.gridy = 5;
        this.add(btnAdd, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 5;
        this.add(btnRemove, constraints);
    }
    
    public void actionPerformed(ActionEvent ev)
    {
        if (ev.getSource().equals(btnAdd))
        {
            String regNo = txt_regNo.getText();
            String colour = txt_colour.getText();
            String make = txt_make.getText();
            String model = txt_make.getText();
            
            if(park.parkFull())
                    {
                        JOptionPane.showMessageDialog(null, "The Park is full!");
                    }
            else 
            {
                park.addCar(regNo, colour, make, model);
                JOptionPane.showMessageDialog(null, "Car has been added");
            }
            lbl_status.setText("Car park has" + park.spacesRemaining() + " remaining");
            txt_regNo.setText("");
            txt_colour.setText("");
            txt_make.setText("");
            txt_model.setText("");
        }
        else if (ev.getSource().equals(btnRemove))
        {
            String regNo = txt_regNo.getText();
            park.removeCar(regNo);
            JOptionPane.showMessageDialog(null, "Car has been removed");
        }
        lbl_status.setText("Car park has" + park.spacesRemaining() + " remaining");
        txt_regNo.setText("");
        txt_colour.setText("");
        txt_make.setText("");
        txt_model.setText("");
    }   
}
