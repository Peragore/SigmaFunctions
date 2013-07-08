package peragore.Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Philip
 * Date: 6/18/13
 * Time: 7:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class DiceRollerDg extends JFrame {
    static String diceInput;
    static int[] output;
    public DiceRollerDg() {
        initUI();
    }

    private final void initUI() {
        //sets dimensions for the new window. GUI's are fun, what can I say?
        setTitle("Dice Roller");
        setSize(320, 330);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel outputLabel = new JLabel("Roll: ");
        outputLabel.setLocation(10, 60);
        outputLabel.setSize(100, 30);

        final JTextField areaOutput= new JTextField();
        areaOutput.setLocation(130, 60);
        areaOutput.setSize(150, 30);
        areaOutput.setEditable(false);

        JLabel input = new JLabel("Input");
        input.setLocation(10, 10);
        input.setSize(110, 30);

        //to the logic. The user inputs the number of nice and type in _d__ format.
        // The program then, after splitting the data into number of dice and type of die, rolls the dice concurrently,
        // and feeds it into an array, which is then converted into a string, and stripping it of it's ugly brackets,
        //set as the text of the answer window. Pretty straight forward, eh?

        final JTextField areaInput = new JTextField();
        areaInput.setLocation(130, 10);
        areaInput.setSize(100, 30);
        areaInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = 0;
                String[] parsedInput;
                diceInput = areaInput.getText();
                parsedInput = diceInput.split("d");
                output = new int[Integer.parseInt(parsedInput[0])];


                for (int i = 1; i < Double.parseDouble(parsedInput[0]) + 1; i++) {
                    output[a] = (int)(Math.random()*Double.parseDouble(parsedInput[1]));
                    a += 1;
                }
                String outputString = Arrays.toString(output);
                String fixedOutputString = outputString.replace("[", "").replace("]", "");
                areaOutput.setText(fixedOutputString);
            }
        });


        JButton returnButton = new JButton("Return");
        returnButton.setBounds(205, 230, 80, 30);
        returnButton.setMnemonic(KeyEvent.VK_R);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                main.setVisible(true);
                dispose();
            }
        });
        panel.add(input);
        panel.add(areaInput);
        panel.add(returnButton);
        panel.add(outputLabel);
        panel.add(areaOutput);
    }
}
