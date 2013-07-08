package peragore.Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created with IntelliJ IDEA.
 * User: Philip
 * Date: 5/18/13
 * Time: 10:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main extends JFrame {



    public Main() {
        initUI();
    }

    private final void initUI() {
        setTitle("Math Utilities");
        setSize(320, 330);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JMenuBar menuBar = new JMenuBar();

        JMenuItem about = new JMenuItem("About");
        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AboutDg ad = new AboutDg();

                ad.setVisible(true);
            }
        });
        about.setMnemonic(KeyEvent.VK_A);
        menuBar.add(about);
        setJMenuBar(menuBar);

        JButton sigmaFunctions = new JButton("Sigma Functions");
        sigmaFunctions.setBounds(80, 60, 150, 30);
        sigmaFunctions.setMnemonic(KeyEvent.VK_S);
        sigmaFunctions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SigmaDg sd = new SigmaDg();
                dispose();
                sd.setVisible(true);
            }
        });

        JButton factorer = new JButton("Factor Polynomials");
        factorer.setBounds(80, 100, 150, 30);
        factorer.setMnemonic(KeyEvent.VK_F);
        factorer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factorDg fd = new factorDg();
                dispose();
                fd.setVisible(true);
            }
        });

        JButton diceRoller = new JButton("Dice Roller");
        diceRoller.setBounds(80, 140, 150, 30);
        diceRoller.setMnemonic(KeyEvent.VK_D);
        diceRoller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DiceRollerDg diceRollerDg = new DiceRollerDg();
                dispose();
                diceRollerDg.setVisible(true);
            }
        });

        JButton relaySolver = new JButton("Relay Solver");
        relaySolver.setBounds(80, 180, 150, 30);
        relaySolver.setMnemonic(KeyEvent.VK_D);
        relaySolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RelaySolverDg relaySolverDg = new RelaySolverDg();
                dispose();
                relaySolverDg.setVisible(true);
            }
        });

        panel.add(sigmaFunctions);
        panel.add(factorer);
        panel.add(diceRoller);
        panel.add(relaySolver);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Main main = new Main();
                main.setVisible(true);
            }
        });
    }
}
