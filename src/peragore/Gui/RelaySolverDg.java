package peragore.Gui;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Philip
 * Date: 7/7/13
 * Time: 10:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class RelaySolverDg extends JFrame {
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
        //this is a test

        JTextField swimmerOneName = new JTextField("");
        swimmerOneName.setLocation(20, 40);
        swimmerOneName.setSize(90, 20);

        JTextField swimmerTwoName = new JTextField("");
        swimmerTwoName.setLocation(20, 70);
        swimmerTwoName.setSize(90, 20);

        JTextField swimmerThreeName = new JTextField("");
        swimmerThreeName.setLocation(20, 100);
        swimmerThreeName.setSize(90, 20);

        JTextField swimmerFourName = new JTextField("");
        swimmerFourName.setLocation(20, 130);
        swimmerFourName.setSize(90, 20);

        JTextField swimmerOneButter = new JTextField("");
        swimmerOneButter.setLocation(110, 40);

        JTextField swimmerTwoButter = new JTextField("");

        JTextField swimmerThreeButter = new JTextField("");

        JTextField swimmerFourButter = new JTextField("");

        JTextField swimmerOneBack = new JTextField("");

        JTextField swimmerTwoBack = new JTextField("");

        JTextField swimmerThreeBack = new JTextField("");

        JTextField swimmerFourBack = new JTextField("");

        JTextField swimmerOneBreast = new JTextField("");

        JTextField swimmerTwoBreast = new JTextField("");

        JTextField swimmerThreeBreast = new JTextField("");

        JTextField swimmerFourBreast = new JTextField("");

        JTextField swimmerOneFree = new JTextField("");

        JTextField swimmerTwoFree = new JTextField("");

        JTextField swimmerThreeFree = new JTextField("");

        JTextField swimmerFourFree = new JTextField("");


        panel.add(nameLabel);
        panel.add(backLabel);
        panel.add(breastLabel);
        panel.add(flyLabel);
        panel.add(freeLabel);
        panel.add(swimmerOneName);
        panel.add(swimmerTwoName);
        panel.add(swimmerThreeName);
        panel.add(swimmerFourName);
        panel.add(swimmerOneBack);
        panel.add(swimmerTwoBack);
        panel.add(swimmerThreeBack);
        panel.add(swimmerFourBack);
        panel.add(swimmerOneButter);
        panel.add(swimmerTwoButter);
        panel.add(swimmerThreeButter);
        panel.add(swimmerFourButter);
        panel.add(swimmerOneBreast);
        panel.add(swimmerTwoBreast);
        panel.add(swimmerThreeBreast);
        panel.add(swimmerFourBreast);
        panel.add(swimmerOneFree);
        panel.add(swimmerTwoFree);
        panel.add(swimmerThreeFree);
        panel.add(swimmerFourFree);

    }
}
