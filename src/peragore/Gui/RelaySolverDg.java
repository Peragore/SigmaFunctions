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


        //Backstroke
        JTextField swimmerOneBack = new JTextField("");
        swimmerOneBack.setLocation(130, 40);
        swimmerOneBack.setSize(90, 20);

        JTextField swimmerTwoBack = new JTextField("");
        swimmerTwoBack.setLocation(130, 70);
        swimmerTwoBack.setSize(90, 20);

        JTextField swimmerThreeBack = new JTextField("");
        swimmerThreeBack.setLocation(130, 100);
        swimmerThreeBack.setSize(90, 20);

        JTextField swimmerFourBack = new JTextField("");
        swimmerFourBack. setLocation(130, 130);
        swimmerFourBack.setSize(90, 20);


        //BreastStroke
        JTextField swimmerOneBreast = new JTextField("");
        swimmerOneBreast.setLocation(240, 40);
        swimmerOneBreast.setSize(90, 20);

        JTextField swimmerTwoBreast = new JTextField("");
        swimmerTwoBreast.setLocation(240, 70);
        swimmerTwoBreast.setSize(90, 20);

        JTextField swimmerThreeBreast = new JTextField("");
        swimmerThreeBreast.setLocation(240, 100);
        swimmerThreeBreast.setSize(90, 20);

        JTextField swimmerFourBreast = new JTextField("");
        swimmerFourBreast. setLocation(240, 130);
        swimmerFourBreast.setSize(90, 20);


        //Butterfly
        JTextField swimmerOneFly = new JTextField("");
        swimmerOneFly.setLocation(350, 40);
        swimmerOneFly.setSize(90, 20);

        JTextField swimmerTwoFly = new JTextField("");
        swimmerTwoFly.setLocation(350, 70);
        swimmerTwoFly.setSize(90, 20);

        JTextField swimmerThreeFly = new JTextField("");
        swimmerThreeFly.setLocation(350, 100);
        swimmerThreeFly.setSize(90, 20);

        JTextField swimmerFourFly = new JTextField("");
        swimmerFourFly.setLocation(350, 130);
        swimmerFourFly.setSize(90, 20);


        //FreeStyle
        JTextField swimmerOneFree = new JTextField("");
        swimmerOneFree.setLocation(460, 40);
        swimmerOneFree.setSize(90, 20);

        JTextField swimmerTwoFree = new JTextField("");
        swimmerTwoFree.setLocation(460, 70);
        swimmerTwoFree.setSize(90, 20);

        JTextField swimmerThreeFree = new JTextField("");
        swimmerThreeFree.setLocation(460, 100);
        swimmerThreeFree.setSize(90, 20);

        JTextField swimmerFourFree = new JTextField("");
        swimmerFourFree. setLocation(460, 130);
        swimmerFourFree.setSize(90, 20);


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

    }
}
