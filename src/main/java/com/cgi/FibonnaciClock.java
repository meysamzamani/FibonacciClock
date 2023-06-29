package com.cgi;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class FibonnaciClock {

    final static int[] fibonacci = {5,3,2,1,1};
    static boolean[] hoursFlag = new boolean[5];
    static boolean[] minutesFlag = new boolean[5];

    static int tempHour;
    static int tempMinute;

    static int currentHour = 0;
    static int currentMinute = 0;


    public static void main( String[] args ) {

        Calendar calendar = Calendar.getInstance();
        tempHour = calendar.get(Calendar.HOUR);
        tempMinute = calendar.get(Calendar.MINUTE);

        if (tempHour == 0) {
            tempHour = 12;
        }

        while (tempMinute % 5 != 0) {
            tempMinute--;
        }

        currentHour = tempHour;
        currentMinute = tempMinute;

        tempMinute = tempMinute / 5;

        calculateColor();
    }

    public static void calculateColor() {

        for (int i = 0; i < 5; i++) {
            if (tempHour - fibonacci[i] >= 0) {
                tempHour = tempHour - fibonacci[i];
                hoursFlag[i] = true;
            }
            if (tempMinute - fibonacci[i] >= 0) {
                tempMinute = tempMinute - fibonacci[i];
                minutesFlag[i] = true;
            }
        }

        showTime();
    }

    public static void showTime() {

        int[] redColor = new int[5];
        int[] greenColor = new int[5];
        int[] blueColor = new int[5];

        StringBuilder stringBuilderRedColor = new StringBuilder();
        StringBuilder stringBuilderGreenColor = new StringBuilder();
        StringBuilder stringBuilderBlueColor = new StringBuilder();

        for (int i = 0; i < 5; i++) {

            if (hoursFlag[i] && minutesFlag[i]) {
                blueColor[i] = 1;
                stringBuilderBlueColor.append(fibonacci[i]);
                stringBuilderBlueColor.append(" ");
            } else if (hoursFlag[i]) {
                redColor[i] = 1;
                stringBuilderRedColor.append(fibonacci[i]);
                stringBuilderRedColor.append(" ");
            } else if (minutesFlag[i]) {
                greenColor[i] = 1;
                stringBuilderGreenColor.append(fibonacci[i]);
                stringBuilderGreenColor.append(" ");
            }
        }

        JFrame frame = new JFrame("FibonacciClock");
        frame.setSize(400, 200);
        frame.setTitle("Fibonacci Clock");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Time");
        label.setText(currentHour + ":" + currentMinute);
        panel.add(label);

        JLabel label2 = new JLabel("Color");
        label2.setText("R " + stringBuilderRedColor.toString() + " | G " + stringBuilderGreenColor + " | B " + stringBuilderBlueColor);
        panel.add(label2);

        frame.add(panel);

        frame.setVisible(true);

    }
}
