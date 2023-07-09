package com.meysamzamani;

public class FibonacciClock {

    private final static int[] fibonacci = {5,3,2,1,1};
    private int tempHour;
    private int tempMinute;

    public FibonacciClock(int hour, int minute) {

        tempHour = hour;
        tempMinute = minute;

        if (tempHour == 0) {
            tempHour = 12;
        }

        tempMinute = tempMinute / 5;
    }

    public String calculateRGBColors() {

        StringBuilder blueColor = new StringBuilder();
        StringBuilder redColor = new StringBuilder();
        StringBuilder greenColor = new StringBuilder();
        boolean hoursFlag;
        boolean minutesFlag;

        for (int i = 0; i < 5; i++) {

            hoursFlag = false;
            minutesFlag = false;

            if (tempHour - fibonacci[i] >= 0) {
                tempHour = tempHour - fibonacci[i];
                hoursFlag = true;
            }
            if (tempMinute - fibonacci[i] >= 0) {
                tempMinute = tempMinute - fibonacci[i];
                minutesFlag = true;
            }

            if (hoursFlag && minutesFlag) {
                blueColor.append(fibonacci[i]);
                blueColor.append(" ");
            } else if (hoursFlag) {
                redColor.append(fibonacci[i]);
                redColor.append(" ");
            } else if (minutesFlag) {
                greenColor.append(fibonacci[i]);
                greenColor.append(" ");
            }
        }

        return "R " + redColor + " | G "+ greenColor + " | B " + blueColor;
    }

}
