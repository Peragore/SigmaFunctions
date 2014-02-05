package peragore.Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: Philip
 * Date: 2/1/14
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class ServerDG extends JFrame {

    Socket myClient = null;
    DataOutputStream os = null;
    DataInputStream is = null;
    static String serverInput = null;

    InputStreamReader ISR = new InputStreamReader(System.in);
    BufferedReader BR;
    String builtString = null;
    static boolean isRunning = false;
    static boolean isConnecting = false;
    String[] ipSocketAddress;

    static JTextField inputField = null;
    static JTextField outPut = null;
    static JTextField ipField = null;
    static JTextField statusField = null;

    public ServerDG() {
        initUI();
    }

    public void initUI() {
        setTitle("Server Stuff");
        setSize(320, 330);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(2);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);


        inputField = new JTextField();
        inputField.setBounds(20, 10, 110, 30);

        outPut = new JTextField();
        outPut.setBounds(140, 10, 110, 30);
        outPut.setEditable(false);

        ipField = new JTextField();
        ipField.setBounds(20, 150, 110, 30);

        statusField = new JTextField("Disconnected");
        statusField.setBounds(140, 150, 110, 30);


        JButton connectButton = new JButton("Connect");
        connectButton.setBounds(180, 50, 110, 30);
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connect();
            }
        });

        JButton disconnectButton = new JButton("Disconnect");
        disconnectButton.setBounds(180, 90, 110, 30);
        disconnectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myClient != null && os != null && is != null) {
                    disconnect();
                }
            }
        });

        JButton sendButton = new JButton("Send to Server");
        sendButton.setLocation(20, 50);
        sendButton.setSize(150, 30);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    os.flush();
                    serverInput = "@" + inputField.getText() + "@";
                    os.writeChars(serverInput);

                } catch (IOException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });
        JButton receiveButton = new JButton("Receive");
        receiveButton.setBounds(20, 90, 150, 30);
        receiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                receive();
            }
        });


        panel.add(sendButton);
        panel.add(inputField);
        panel.add(outPut);
        panel.add(connectButton);
        panel.add(disconnectButton);
        panel.add(receiveButton);
        panel.add(ipField);
        panel.add(statusField);
    }

    public String charStringBuilder(final char charArray) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                isRunning = true;
                boolean runBuilder = true;
                for (int i = 0; i < 500; i++) {
                    System.out.println(charArray);
                    /*if (valueOfCharArray == "@"){
                        runBuilder = false;
                        break;
                    }*/

                    if (!runBuilder) {
                        break;
                    }
                    builtString = builtString + charArray;
                    try {
                        Thread.sleep(1L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                    isRunning = false;
                }
            }
        });
        if (!isRunning) {
            thread.start();
        }
        return builtString;
    }

    public void connect() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                isConnecting = true;
                System.out.println(ipField.getText());
                if (!ipField.getText().contains(":")) {
                    ipSocketAddress = new String[2];
                    ipSocketAddress[0] = "192.168.0.103";
                    ipSocketAddress[1] = "3373";
                    System.out.println(ipSocketAddress[0] + ":" + ipSocketAddress[1]);
                } else if (ipField.getText().contains(":")) {
                    ipSocketAddress = ipField.getText().split(":");
                    System.out.println(ipSocketAddress[0] + ":" + ipSocketAddress[1]);
                }
                try {
                    myClient = new Socket(ipSocketAddress[0], Integer.parseInt(ipSocketAddress[1]));
                    os = new DataOutputStream(myClient.getOutputStream());
                    is = new DataInputStream(myClient.getInputStream());
                    BR = new BufferedReader(new InputStreamReader(myClient.getInputStream(), "UTF-16"));
                    statusField.setText("Connected");
                } catch (IOException ex) {
                    statusField.setText("Connection Failed");
                    System.out.println("Connection Failed");
                }
                isConnecting = false;
            }
        });
        if (!isConnecting) {
            thread.start();
        }
    }

    public void disconnect() {
        try {
            myClient.close();
            os.close();
            is.close();
            System.out.println("Disconnected");
            statusField.setText("Disconnected");
        } catch (IOException e1) {
            e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void receive() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                isRunning = true;
                System.out.println("Receiving");
                String character = null;
                try {
                    character = BR.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(character);
                //if (character != null){
                character = String.valueOf(character);
                character = character.replace("\0", "");
                character = character.replace("@", "");
                //}
                System.out.println(character);
                double characterDouble = Double.parseDouble(character);
                System.out.println(characterDouble + 5);


                //disconnect();


                //Iasso's IP: 209.249.85.70:3373
                isRunning = false;
            }
        });

        if (!isRunning) {
            thread.start();
        }

    }


}
