package peragore.Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Philip
 * Date: 7/7/13
 * Time: 10:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class RelaySolverDg extends JFrame {
    String name1 = null;
    String name2 = null;
    String name3 = null;
    String name4 = null;
    
    public RelaySolverDg() {
        initUI();
    }

    public final void initUI() {
        setTitle("Relay Order Solver");
        setSize(600, 330);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setLocation(20, 10);
        nameLabel.setSize(100, 30);

        JLabel backLabel = new JLabel("Back Time");
        backLabel.setLocation(130, 10);
        backLabel.setSize(100, 30);

        JLabel breastLabel = new JLabel("Breast Time");
        breastLabel.setLocation(240, 10);
        breastLabel.setSize(100, 30);

        JLabel flyLabel = new JLabel("Fly Time");
        flyLabel.setLocation(350, 10);
        flyLabel.setSize(100, 30);

        JLabel freeLabel = new JLabel("Free Time");
        freeLabel.setLocation(460, 10);
        freeLabel.setSize(100, 30);

        JLabel answerLabel = new JLabel("Swim Order");
        answerLabel.setLocation(20, 200);
        answerLabel.setSize(100, 30);

        final JTextField answerArea = new JTextField();
        answerArea.setLocation(110, 200);
        answerArea.setSize(150, 30);
        answerArea.setEditable(false);

        //Names
        final JTextField swimmerOneName = new JTextField("");
        swimmerOneName.setLocation(20, 40);
        swimmerOneName.setSize(90, 20);

        final JTextField swimmerTwoName = new JTextField("");
        swimmerTwoName.setLocation(20, 70);
        swimmerTwoName.setSize(90, 20);

        final JTextField swimmerThreeName = new JTextField("");
        swimmerThreeName.setLocation(20, 100);
        swimmerThreeName.setSize(90, 20);

        final JTextField swimmerFourName = new JTextField("");
        swimmerFourName.setLocation(20, 130);
        swimmerFourName.setSize(90, 20);


        //Backstroke
        final JTextField swimmerOneBack = new JTextField("");
        swimmerOneBack.setLocation(130, 40);
        swimmerOneBack.setSize(90, 20);

        final JTextField swimmerTwoBack = new JTextField("");
        swimmerTwoBack.setLocation(130, 70);
        swimmerTwoBack.setSize(90, 20);

        final JTextField swimmerThreeBack = new JTextField("");
        swimmerThreeBack.setLocation(130, 100);
        swimmerThreeBack.setSize(90, 20);

        final JTextField swimmerFourBack = new JTextField("");
        swimmerFourBack. setLocation(130, 130);
        swimmerFourBack.setSize(90, 20);


        //BreastStroke
        final JTextField swimmerOneBreast = new JTextField("");
        swimmerOneBreast.setLocation(240, 40);
        swimmerOneBreast.setSize(90, 20);

        final JTextField swimmerTwoBreast = new JTextField("");
        swimmerTwoBreast.setLocation(240, 70);
        swimmerTwoBreast.setSize(90, 20);

        final JTextField swimmerThreeBreast = new JTextField("");
        swimmerThreeBreast.setLocation(240, 100);
        swimmerThreeBreast.setSize(90, 20);

        final JTextField swimmerFourBreast = new JTextField("");
        swimmerFourBreast. setLocation(240, 130);
        swimmerFourBreast.setSize(90, 20);


        //Butterfly
        final JTextField swimmerOneFly = new JTextField("");
        swimmerOneFly.setLocation(350, 40);
        swimmerOneFly.setSize(90, 20);

        final JTextField swimmerTwoFly = new JTextField("");
        swimmerTwoFly.setLocation(350, 70);
        swimmerTwoFly.setSize(90, 20);

        final JTextField swimmerThreeFly = new JTextField("");
        swimmerThreeFly.setLocation(350, 100);
        swimmerThreeFly.setSize(90, 20);

        final JTextField swimmerFourFly = new JTextField("");
        swimmerFourFly.setLocation(350, 130);
        swimmerFourFly.setSize(90, 20);


        //FreeStyle
        final JTextField swimmerOneFree = new JTextField("");
        swimmerOneFree.setLocation(460, 40);
        swimmerOneFree.setSize(90, 20);

        final JTextField swimmerTwoFree = new JTextField("");
        swimmerTwoFree.setLocation(460, 70);
        swimmerTwoFree.setSize(90, 20);

        final JTextField swimmerThreeFree = new JTextField("");
        swimmerThreeFree.setLocation(460, 100);
        swimmerThreeFree.setSize(90, 20);

        final JTextField swimmerFourFree = new JTextField("");
        swimmerFourFree. setLocation(460, 130);
        swimmerFourFree.setSize(90, 20);

        JButton returnButton = new JButton("Return");
        returnButton.setLocation(475, 250);
        returnButton.setSize(90, 30);
        returnButton.setMnemonic(KeyEvent.VK_R);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                main.setVisible(true);
                dispose();
            }
        });

        JButton solveButton = new JButton("Solve");
        solveButton.setLocation(350, 250);
        solveButton.setSize(90, 30);
        solveButton.setMnemonic(KeyEvent.VK_S);
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] finalOrder = new String[4];
                name1 = swimmerOneName.getText();
                name2 = swimmerTwoName.getText();
                name3 = swimmerThreeName.getText();
                name4 = swimmerFourName.getText();
                /**************************
                 * finalOrder[0] = name1;
                 * finalOrder[1] = name2;
                 * finalOrder[2] = name3;
                 * finalOrder[3] = name4;
                 **************************/

                answerArea.setText(finalOrder[0] + ", " + finalOrder[1] + ", " + finalOrder[2] + ", " + finalOrder[3]);
            }
        });
        
        panel.add(nameLabel);
        panel.add(backLabel);
        panel.add(breastLabel);
        panel.add(flyLabel);
        panel.add(freeLabel);
        panel.add(answerLabel);

        panel.add(swimmerOneName);
        panel.add(swimmerTwoName);
        panel.add(swimmerThreeName);
        panel.add(swimmerFourName);

        panel.add(swimmerOneBack);
        panel.add(swimmerTwoBack);
        panel.add(swimmerThreeBack);
        panel.add(swimmerFourBack);

        panel.add(swimmerOneFly);
        panel.add(swimmerTwoFly);
        panel.add(swimmerThreeFly);
        panel.add(swimmerFourFly);

        panel.add(swimmerOneBreast);
        panel.add(swimmerTwoBreast);
        panel.add(swimmerThreeBreast);
        panel.add(swimmerFourBreast);

        panel.add(swimmerOneFree);
        panel.add(swimmerTwoFree);
        panel.add(swimmerThreeFree);
        panel.add(swimmerFourFree);

        panel.add(answerArea);

        //buttons
        panel.add(returnButton);
        panel.add(solveButton);

    }
}
