package peragore.Gui;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

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

    String back1 = null;
    String back2 = null;
    String back3 = null;
    String back4 = null;

    String fly1 = null;
    String fly2 = null;
    String fly3 = null;
    String fly4 = null;

    String breast1 = null;
    String breast2 = null;
    String breast3 = null;
    String breast4 = null;

    String free1 = null;
    String free2 = null;
    String free3 = null;
    String free4 = null;

    String[] xmlNameArray = new String[4];
    String[] xmlBackArray = new String[4];
    String[] xmlBreastArray = new String[4];
    String[] xmlFlyArray = new String[4];
    String[] xmlFreeArray = new String[4];

    int parsedBack1;
    int parsedBack2;
    int parsedBack3;
    int parsedBack4;

    public RelaySolverDg() {
        initUI();
    }

    public final void initUI() {
        setTitle("Relay Order Solver");
        setSize(600, 330);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        final JPanel panel = new JPanel();
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
        final JTextField swimmer1Name = new JTextField("");
        swimmer1Name.setLocation(20, 40);
        swimmer1Name.setSize(90, 20);

        final JTextField swimmer2Name = new JTextField("");
        swimmer2Name.setLocation(20, 70);
        swimmer2Name.setSize(90, 20);

        final JTextField swimmer3Name = new JTextField("");
        swimmer3Name.setLocation(20, 100);
        swimmer3Name.setSize(90, 20);

        final JTextField swimmer4Name = new JTextField("");
        swimmer4Name.setLocation(20, 130);
        swimmer4Name.setSize(90, 20);


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
        swimmerFourBack.setLocation(130, 130);
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
        swimmerFourBreast.setLocation(240, 130);
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
        swimmerFourFree.setLocation(460, 130);
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

        JButton xmlWriterButton = new JButton("Save");
        xmlWriterButton.setLocation(240, 250);
        xmlWriterButton.setSize(90, 30);
        xmlWriterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RelaySolverXMLEngine xmlWriter = new RelaySolverXMLEngine();
                xmlWriter.writeXML(swimmer1Name.getText(), swimmerOneBack.getText(), swimmerOneBreast.getText(), swimmerOneFly.getText(), swimmerOneFree.getText(),
                        swimmer2Name.getText(), swimmerTwoBack.getText(), swimmerTwoBreast.getText(), swimmerTwoFly.getText(), swimmerTwoFree.getText(),
                        swimmer3Name.getText(), swimmerThreeBack.getText(), swimmerThreeBreast.getText(), swimmerThreeFly.getText(), swimmerThreeFree.getText(),
                        swimmer4Name.getText(), swimmerFourBack.getText(), swimmerFourBreast.getText(), swimmerFourFly.getText(), swimmerFourFree.getText());
            }
        });

        JButton openButton = new JButton("Open");
        openButton.setLocation(140, 250);
        openButton.setSize(90, 30);
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileOpen = new JFileChooser(new File("."));
                FileFilter filter = new FileNameExtensionFilter("xml files", "xml");
                fileOpen.addChoosableFileFilter(filter);
                int ret = fileOpen.showDialog(panel, "Open file");

                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileOpen.getSelectedFile();
                    String text = readFile(file);
                    RelaySolverXMLEngine xmlEngine = new RelaySolverXMLEngine();
                    System.out.println(file.getPath());

                    SAXBuilder builder = new SAXBuilder();
                    File xmlFile = new File(file.getPath());

                    try {
                        Document doc = (Document) builder.build(xmlFile);
                        Element rootNode = doc.getRootElement();
                        List list = rootNode.getChildren("Swimmer");
                        for (int i = 0; i < list.size(); i++) {
                            Element node = (Element) list.get(i);
                            xmlNameArray[i] = node.getChildText("Name");
                            xmlBackArray[i] = node.getChildText("Backstroke");
                            xmlBreastArray[i] = node.getChildText("Breast_Stroke");
                            xmlFlyArray[i] = node.getChildText("Butterfly");
                            xmlFreeArray[i] = node.getChildText("Freestyle");
                        }

                        swimmer1Name.setText(xmlNameArray[0]);
                        swimmer2Name.setText(xmlNameArray[1]);
                        swimmer3Name.setText(xmlNameArray[2]);
                        swimmer4Name.setText(xmlNameArray[3]);

                        swimmerOneBack.setText(xmlBackArray[0]);
                        swimmerTwoBack.setText(xmlBackArray[1]);
                        swimmerThreeBack.setText(xmlBackArray[2]);
                        swimmerFourBack.setText(xmlBackArray[3]);

                        swimmerOneBreast.setText(xmlBreastArray[0]);
                        swimmerTwoBreast.setText(xmlBreastArray[1]);
                        swimmerThreeBreast.setText(xmlBreastArray[2]);
                        swimmerFourBreast.setText(xmlBreastArray[3]);

                        swimmerOneFly.setText(xmlFlyArray[0]);
                        swimmerTwoFly.setText(xmlFlyArray[1]);
                        swimmerThreeFly.setText(xmlFlyArray[2]);
                        swimmerFourFly.setText(xmlFlyArray[3]);

                        swimmerOneFree.setText(xmlFreeArray[0]);
                        swimmerTwoFree.setText(xmlFreeArray[1]);
                        swimmerThreeFree.setText(xmlFreeArray[2]);
                        swimmerFourFree.setText(xmlFreeArray[3]);

                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
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
                String[] back1Array;
                String[] back2Array;
                String[] back3Array;
                String[] back4Array;
                TreeSet backTS = new TreeSet();
                TreeSet flyTS = new TreeSet();
                TreeSet breastTS = new TreeSet();
                TreeSet freeTS = new TreeSet();

                name1 = swimmer1Name.getText();
                name2 = swimmer2Name.getText();
                name3 = swimmer3Name.getText();
                name4 = swimmer4Name.getText();

                back1 = swimmerOneBack.getText();
                back2 = swimmerTwoBack.getText();
                back3 = swimmerThreeBack.getText();
                back4 = swimmerFourBack.getText();

                back1Array = back1.split(":");
                back2Array = back2.split(":");
                back3Array = back3.split(":");
                back4Array = back4.split(":");
                parsedBack1 = (Integer.parseInt(back1Array[0]) * 100) + (Integer.parseInt(back1Array[1]) * 10) + Integer.parseInt(back1Array[2]);
                parsedBack2 = (Integer.parseInt(back2Array[0]) * 100) + (Integer.parseInt(back2Array[1]) * 10) + Integer.parseInt(back2Array[2]);
                parsedBack3 = (Integer.parseInt(back3Array[0]) * 100) + (Integer.parseInt(back3Array[1]) * 10) + Integer.parseInt(back3Array[2]);
                parsedBack4 = (Integer.parseInt(back4Array[0]) * 100) + (Integer.parseInt(back4Array[1]) * 10) + Integer.parseInt(back4Array[2]);


                fly1 = swimmerOneFly.getText();
                fly2 = swimmerTwoFly.getText();
                fly3 = swimmerThreeFly.getText();
                fly4 = swimmerFourFly.getText();


                /**************************
                 * finalOrder[0] = name1;
                 * finalOrder[1] = name2;
                 * finalOrder[2] = name3;
                 * finalOrder[3] = name4;
                 **************************/
                System.out.println(backTS.first());
                answerArea.setText(finalOrder[0] + ", " + finalOrder[1] + ", " + finalOrder[2] + ", " + finalOrder[3]);
            }
        });


        panel.add(nameLabel);
        panel.add(backLabel);
        panel.add(breastLabel);
        panel.add(flyLabel);
        panel.add(freeLabel);
        panel.add(answerLabel);

        panel.add(swimmer1Name);
        panel.add(swimmer2Name);
        panel.add(swimmer3Name);
        panel.add(swimmer4Name);

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
        panel.add(xmlWriterButton);
        panel.add(openButton);

    }

    public String readFile(File file) {
        StringBuffer fileBuffer = null;
        String fileString = null;
        String line = null;

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            fileBuffer = new StringBuffer();

            while ((line = bufferedReader.readLine()) != null) {
                fileBuffer.append(line).append(System.getProperty("line.separator"));
            }

            fileReader.close();
            fileString = fileBuffer.toString();
        } catch (IOException ex) {
            return null;
        }

        return fileString;
    }


}
