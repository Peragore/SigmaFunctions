package peragore.Gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * Created with IntelliJ IDEA.
 * User: Philip
 * Date: 6/15/13
 * Time: 8:09 PM
 * To change this template use File | Settings | File Templates.
 */
class SigmaDg extends JFrame {
    static double input1 = 0;
    static double input2 = 0;
    static double iterateInput = 1;
    static double output;
    static int iterateStart = 1;
    static double iterateEnd = 1;
    static String parsedPoly[] = new String[4];
    static String coeffPoly[] = new String[4];
    static String fracPoly[] = new String[4];
    static String exponentPoly[] = new String[4];
    private BufferedImage sigma;

    public SigmaDg() {
        initUI();
    }

    public final void initUI() {

        setTitle("Sigma Function Solver");
        setSize(320, 330);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(2);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        final JTextField areaNumber1 = new JTextField("1");
        areaNumber1.setLocation(120, 10);
        areaNumber1.setSize(100, 30);
        areaNumber1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input1 = Double.parseDouble(areaNumber1.getText());
            }
        });

        JLabel iterateNumber = new JLabel("Iterate Number");
        iterateNumber.setLocation(10, 60);
        iterateNumber.setSize(110, 30);
        iterateNumber.setToolTipText("Number of times to add the second number to the sum of the first and second number");

        final JTextField areaIterate = new JTextField("1");
        areaIterate.setLocation(120, 60);
        areaIterate.setSize(100, 30);
        areaIterate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iterateInput = Double.parseDouble(areaIterate.getText());
            }
        });


        JLabel number1 = new JLabel("Start Number");
        number1.setLocation(10, 10);
        number1.setSize(80, 30);
        number1.setToolTipText("Pretty Self-Explanatory, eh?");
        number1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (iterateInput - iterateStart <= 0) {
                    areaIterate.setText(Double.toString(iterateStart + 1));
                }
            }
        });


        JLabel answerNumber = new JLabel("Answer");
        answerNumber.setLocation(10, 170);
        answerNumber.setSize(110, 30);
        answerNumber.setToolTipText("If you can't figure out what this is for.....");

        final JTextField areaAnswer = new JTextField("Answer");
        areaAnswer.setLocation(120, 179);
        areaAnswer.setSize(130, 30);
        areaAnswer.setEditable(false);

        JLabel polynomialNumber = new JLabel("Polynomial");
        polynomialNumber.setLocation(10, 120);
        polynomialNumber.setSize(110, 30);
        polynomialNumber.setToolTipText("Place to Polynomial to be solved here in ax + c format");

        final JTextField areaPolynomial = new JTextField("Polynomial Here");
        areaPolynomial.setLocation(120, 120);
        areaPolynomial.setSize(100, 30);
        areaPolynomial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String poly = areaPolynomial.getText();
                String fixedPoly = poly.replace("-", "+-");
                parsedPoly = fixedPoly.split("\\+");
                coeffPoly = parsedPoly[0].split("x");
                if (coeffPoly.length == 2) {
                    if (coeffPoly[1].contains("^")) {
                        exponentPoly = coeffPoly[1].split("\\^");

                    } else {
                        exponentPoly[0] = "1";
                    }
                }
                System.out.println(exponentPoly[1]);
                //System.out.println(Double.parseDouble(parsedPoly[1]));
            }
        });

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(25, 230, 80, 30);
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                input1 = 0;
                input2 = 0;
                iterateInput = 1;
                areaIterate.setText("1");
                areaNumber1.setText("1");
                areaAnswer.setText("Answer");
                areaPolynomial.setText("Polynomial Here");

            }
        });
        resetButton.setMnemonic(KeyEvent.VK_R);


        JButton iterateButton = new JButton("Iterate");
        iterateButton.setBounds(115, 230, 80, 30);
        iterateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iterateInput = Double.parseDouble(areaIterate.getText());

                input1 = Double.parseDouble(areaNumber1.getText());
                iterateStart = Integer.parseInt(areaNumber1.getText());

                String poly = areaPolynomial.getText();
                String fixedPoly = poly.replace("-", "+-");
                parsedPoly = fixedPoly.split("\\+");
                coeffPoly = parsedPoly[0].split("x");
                double itCount = 0;
                double coefficient = 0;
                if (!coeffPoly[0].contains("/")) {
                    coefficient = Double.parseDouble(coeffPoly[0]);
                } else {
                    fracPoly = coeffPoly[0].split("/");
                    coefficient = Double.parseDouble(fracPoly[0]) / Double.parseDouble(fracPoly[1]);
                }
                double secondNumber = 0;
                if (parsedPoly.length == 2) {
                    secondNumber = Double.parseDouble(parsedPoly[1]);
                } else secondNumber = 0;

                if (coeffPoly.length == 2) {
                    if (coeffPoly[1].contains("^")) {
                        exponentPoly = coeffPoly[1].split("\\^");

                    } else {
                        exponentPoly[0] = "1";
                    }
                }
                double exponent = 1;
                if (exponentPoly.length == 2) {
                    exponent = Double.parseDouble(exponentPoly[1]);
                } else exponent = 1;
                double loopCount = iterateStart;
                double itInput = iterateInput + 1;
                for (int i = iterateStart; i < itInput; i++) {

                    itCount += ((coefficient * Math.pow(loopCount, exponent)) + secondNumber);  //Double.parseDouble(parsedPoly[1]));
                    //itCount += loopCount - 2;
                    loopCount += 1;
                }
                areaAnswer.setText(Double.toString(itCount));
            }
        });
        iterateButton.setMnemonic(KeyEvent.VK_I);

        JButton returnButon = new JButton("Return");
        returnButon.setBounds(205, 230, 80, 30);
        returnButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                main.setVisible(true);
                dispose();
            }
        });
        returnButon.setMnemonic(KeyEvent.VK_R);

        panel.add(resetButton);
        panel.add(iterateButton);
        panel.add(number1);
        panel.add(iterateNumber);
        panel.add(answerNumber);
        panel.add(polynomialNumber);
        panel.add(areaNumber1);
        panel.add(areaIterate);
        panel.add(areaAnswer);
        panel.add(areaPolynomial);
        panel.add(returnButon);
        // pack();

        resetButton.setToolTipText("Resets the numbers to be calculated to 0");
        iterateButton.setToolTipText("Adds the second number to the first number, and then adds those together for a set number of times as sepcified by the iterate number button");
    }
}
