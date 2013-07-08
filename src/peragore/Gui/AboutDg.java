package peragore.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Philip
 * Date: 6/15/13
 * Time: 8:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class AboutDg extends JDialog{
    public AboutDg()
    {
        initUI();
    }

    public final void initUI() {
        setTitle("About Sigma Function Solver");
        setSize(300, 280);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(2);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel name = new JLabel("<html><p align=center>Sigma Function Solver v3.0</p></html>");
        name.setFont(new Font("Serif", 1, 15));
        name.setLocation(55, 20);
        name.setSize(200, 30);
        panel.add(name);

        JLabel subtitle = new JLabel("<html><p align=center>(v2.0) Now With Added Polynomials!</p></html>");
        subtitle.setFont(new Font("Serif", 1, 13));
        subtitle.setLocation(45, 40);
        subtitle.setSize(200, 30);
        panel.add(subtitle);

        JLabel subtitle2 = new JLabel("<html><p align=center>(v2.1) Now Supporting Fractions!</p></html>");
        subtitle2.setFont(new Font("Serif", 1, 13));
        subtitle2.setLocation(55, 60);
        subtitle2.setSize(200, 30);
        panel.add(subtitle2);

        JLabel expoSub = new JLabel("<html><p align=center>(v3.0) Now Supporting Exponents + Interface Redesign!</p></html>");
        expoSub.setFont(new Font("Serif", 1, 13));
        expoSub.setLocation(35, 90);
        expoSub.setSize(200, 30);
        panel.add(expoSub);

        JButton close = new JButton("Done");
        close.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        close.setLocation(100, 180);
        close.setSize(80, 30);
        close.setMnemonic(68);
        panel.add(close);
    }
}