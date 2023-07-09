package com.meysamzamani;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        int currentHour = calendar.get(Calendar.HOUR);
        int currentMinute = calendar.get(Calendar.MINUTE);

        currentMinute = currentMinute - Math.floorMod(currentMinute, 5);

        FibonacciClock fibonacciClock = new FibonacciClock(currentHour, currentMinute);

        JFrame frame = new JFrame("FibonacciClock");
        frame.setSize(400, 200);
        frame.setTitle("Fibonacci Clock");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Time");
        label.setText(currentHour + ":" + currentMinute);
        panel.add(label);

        JLabel label2 = new JLabel("Color");
        label2.setText(fibonacciClock.calculateRGBColors());
        panel.add(label2);

        frame.add(panel);

        frame.setVisible(true);
    }
}
