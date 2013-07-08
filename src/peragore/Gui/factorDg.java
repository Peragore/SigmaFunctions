package peragore.Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Philip
 * Date: 6/15/13
 * Time: 8:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class factorDg extends JFrame{
    static String[] parsedPoly;
    static String[] squaredCoeffString;
    static String[] coeffString;
    static String constantString;
    static double squaredCoeff = 0;
    static double coeff = 0;
    static double constant = 0;
    static double[] firstFactorArray = new double[50];
    static double[] secondFactorArray = new double[50];

    public factorDg() {
        initUI();
    }

    public final void initUI(){
        setTitle("Polynomial Factorer");
        setSize(320, 330);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(2);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

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

        JLabel polyLabel = new JLabel("Polynomial");
        polyLabel.setLocation(10, 10);
        polyLabel.setSize(100, 30);

        JLabel answerLabel = new JLabel("Answer");
        answerLabel.setLocation(10, 50);
        answerLabel.setSize(100, 30);

        final JTextField areaAnswer = new JTextField();
        areaAnswer.setLocation(120, 50);
        areaAnswer.setSize(100, 30);

        final JTextField areaPoly = new JTextField("Polynomial Here");
        areaPoly.setLocation(120, 10);
        areaPoly.setSize(100, 30);
        areaPoly.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double GCF = 0;
                double quadConstantResult = 0;
                int factorArrayPosition = 0;
                double firstFactor = 0;
                double secondFactor = 0;
                double coeffFactor1[] = new double[2];
                double coeffFactor2[] = new double[2];
                double finalCoeff = 1;
                double finalConstant = 1;
                String firstFactorString = "null";
                String secondFactorString = "null";
                String firstPosNeg = "+";
                String secondPosNeg = "+";
                int a = 0;
                String poly = areaPoly.getText();
                String fixedPoly = poly.replace("-", "+-");
                parsedPoly = fixedPoly.split("\\+");
                squaredCoeffString = parsedPoly[0].split("x");

                if (parsedPoly.length > 1) coeffString = parsedPoly[1].split("x");

                if (parsedPoly.length > 2) constantString = parsedPoly[2];

                if (squaredCoeffString.length > 0) {
                    squaredCoeff = Double.parseDouble(squaredCoeffString[0]);
                } else squaredCoeff = 1;
                if (coeffString.length > 0) {
                    coeff = Double.parseDouble(coeffString[0]);
                } else coeff = 1;
                constant = Double.parseDouble(constantString);

                /*for (int i = 1; i < 101; i++) {
                    if (squaredCoeff % i == 0 && coeff % i == 0 && constant % i == 0) GCF = i;
                }

                if (GCF != 0) {
                    squaredCoeff = squaredCoeff / GCF;
                    coeff = coeff / GCF;
                    constant = constant  /  GCF;
                } */

                quadConstantResult = squaredCoeff * constant;
                for (int i = 1; i < 101; i++) {
                    if (quadConstantResult % i == 0) {

                        firstFactorArray[a] = i;
                        secondFactorArray[a] = quadConstantResult/i;
                        a += 1;
                    }
                }
                for (int i = 1; i <= (firstFactorArray.length - 1); i++){
                    if (firstFactorArray[i] + secondFactorArray[i] == coeff){
                        factorArrayPosition = i;
                    }
                }
                firstFactor = firstFactorArray[factorArrayPosition];
                secondFactor = secondFactorArray[factorArrayPosition];

                if (firstFactor * secondFactor != constant) areaAnswer.setText("Not Factorable");
                if (firstFactor < 0) firstPosNeg = "";
                if (firstFactor > 0) firstPosNeg = "+";
                if (secondFactor < 0) secondPosNeg = "";
                if (secondFactor > 0) secondPosNeg = "+";
                if (squaredCoeff == 1 && firstFactor + secondFactor == constant) {
                    firstFactorString = "(x" + firstPosNeg + firstFactor + ")";
                    secondFactorString = "(x" + secondPosNeg + secondFactor + ")";
                    areaAnswer.setText(firstFactorString + secondFactorString);
                } else {
                    coeffFactor1[0] = squaredCoeff;
                    coeffFactor1[1] = firstFactor;
                    coeffFactor2[0] = secondFactor;
                    coeffFactor2[1] = constant;

                    for (int i = 2; i < 101; i++){
                        if (coeffFactor1[0] % i == 0 && coeffFactor1[1] % i == 0 ){
                            finalCoeff = i;
                        }


                        if (coeffFactor2[0] % i == 0 && coeffFactor2[1] % i == 0){
                            finalConstant = i;
                            coeffFactor2[0] = coeffFactor2[0]/finalConstant;
                            coeffFactor2[1] = coeffFactor2[1]/finalConstant;
                        }
                    }
                        if (finalConstant < 0) firstPosNeg = "";
                        if (finalConstant > 0) firstPosNeg = "+";
                        if (coeffFactor2[1] < 0) secondPosNeg = "";
                        if (coeffFactor2[1] > 0) secondPosNeg = "+";
                        firstFactorString = "(" + finalCoeff + "x" + firstPosNeg + finalConstant + ")";
                        secondFactorString = "(" + Double.toString(coeffFactor2[0]) + "x" + secondPosNeg + Double.toString(coeffFactor2[1]) + ")";

                        if (finalConstant * coeffFactor2[1] == constant) {
                            areaAnswer.setText(firstFactorString + secondFactorString);
                        } else areaAnswer.setText("Not Factorable");

                }
                System.out.println(coeff);
                System.out.println(finalCoeff);
                System.out.println(finalConstant);
                System.out.println(coeffFactor1[0] + " " + coeffFactor1[1]);
                System.out.println(coeffFactor2[0] + " " + coeffFactor2[1]);
            }
        });




        panel.add(returnButon);
        panel.add(areaPoly);
        panel.add(polyLabel);
        panel.add(answerLabel);
        panel.add(areaAnswer);
    }
}
