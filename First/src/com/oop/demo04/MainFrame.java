package com.oop.demo04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

//计时器
public class MainFrame {


    private JFrame frame;
    private JTextField date_text;
    private JTextField hour_text;
    private JTextField minute_text;
    private JTextField second_text;
    JButton stop_button;
    JButton start_button;
    boolean isSwi = false;
    private int second = 1;
    private int minute = 1;
    private int hour = 1;
    private JLabel lblNewLabel;
    private JLabel label;




    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame window = new MainFrame();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Create the application.
     */
    public MainFrame() {
        initialize();
    }


    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("简单计时器");
        ImageIcon icon = new ImageIcon("img/jsq.png");
        frame.setIconImage(icon.getImage());
        frame.getContentPane().setFont(new Font("宋体", Font.PLAIN, 29));
        frame.setBounds(100, 100, 632, 414);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        date_text = new JTextField();
        date_text.setBounds(206, 38, 203, 38);
        frame.getContentPane().add(date_text);
        date_text.setColumns(10);
        TimeThread timeThread = new TimeThread();
        timeThread.start();

        hour_text = new JTextField();
        hour_text.setBounds(73, 157, 100, 57);
        frame.getContentPane().add(hour_text);
        hour_text.setColumns(10);

        minute_text = new JTextField();
        minute_text.setBounds(266, 157, 100, 57);
        frame.getContentPane().add(minute_text);
        minute_text.setColumns(10);

        second_text = new JTextField();
        second_text.setBounds(469, 157, 100, 57);
        frame.getContentPane().add(second_text);
        second_text.setColumns(10);

        start_button = new JButton("计时开始");
        start_button.setBounds(143, 281, 113, 49);
        frame.getContentPane().add(start_button);
        start_button.addActionListener(new BtListener());

        stop_button = new JButton("暂停计时");
        stop_button.setBounds(368, 281, 113, 49);
        frame.getContentPane().add(stop_button);

        lblNewLabel = new JLabel(":");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 29));
        lblNewLabel.setBounds(206, 157, 45, 57);
        frame.getContentPane().add(lblNewLabel);

        label = new JLabel(":");
        label.setFont(new Font("宋体", Font.PLAIN, 29));
        label.setBounds(402, 157, 38, 57);
        frame.getContentPane().add(label);
        stop_button.addActionListener(new StopListener());
    }

    public class BtListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            String res = e.getActionCommand();

            if(res.equals("计时开始")) {
                isSwi = true;
                start_button.setText("计时结束");
                DateThread dateThread = new DateThread();
                dateThread.start();
            }else {
                isSwi = false;
                start_button.setText("计时开始");
                second = 0;
                hour = 0;
                minute = 0;
                second_text.setText("" + second);
                minute_text.setText("" + minute);
                hour_text.setText("" + hour);
            }
        }
    }

    public class StopListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            String res = e.getActionCommand();
            if(res.equals("暂停计时")) {
                stop_button.setText("继续计时");
                isSwi = false;
            }else {
                stop_button.setText("暂停计时");
                isSwi = true;
                DateThread dateThread = new DateThread();
                dateThread.start();


            }
        }

    }

    public class DateThread extends Thread {

        public void run() {


            while(isSwi) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                second_text.setText("" + second++);
                if(second_text.getText().equals("60")) {
                    second = 0;
                    minute_text.setText("" + minute ++);
                    second_text.setText("" + second++);
                    if(minute_text.getText().equals("60")) {
                        second = 0;
                        minute = 0;
                        hour_text.setText("" + hour++);
                    }
                }
            }
        }
    }

    public class TimeThread extends Thread {

        public void run() {


            while(true) {
                date_text.setText("              " + new Date().toLocaleString());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}