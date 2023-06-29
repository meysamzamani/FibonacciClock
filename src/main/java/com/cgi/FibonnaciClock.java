package com.cgi;

public class FibonnaciClock {

    private final static int[] fibonacci = {5,3,2,1,1};
    private boolean[] hoursFlag = new boolean[5];
    private boolean[] minutesFlag = new boolean[5];

    private int tempHour;
    private int tempMinute;

    public FibonnaciClock(int hour, int minute) {

        tempHour = hour;
        tempMinute = minute;

        if (tempHour == 0) {
            tempHour = 12;
        }

        while (tempMinute % 5 != 0) {
            tempMinute--;
        }

        tempMinute = tempMinute / 5;
    }

    public String calculateColor() {

        StringBuilder blueColor = new StringBuilder();
        StringBuilder redColor = new StringBuilder();
        StringBuilder greenColor = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            if (tempHour - fibonacci[i] >= 0) {
                tempHour = tempHour - fibonacci[i];
                hoursFlag[i] = true;
            }
            if (tempMinute - fibonacci[i] >= 0) {
                tempMinute = tempMinute - fibonacci[i];
                minutesFlag[i] = true;
            }

            if (hoursFlag[i] && minutesFlag[i]) {
                blueColor.append(fibonacci[i]);
                blueColor.append(" ");
            } else if (hoursFlag[i]) {
                redColor.append(fibonacci[i]);
                redColor.append(" ");
            } else if (minutesFlag[i]) {
                greenColor.append(fibonacci[i]);
                greenColor.append(" ");
            }
        }

        return "R " + redColor + " | G "+ greenColor + " | B " + blueColor;
    }

}
