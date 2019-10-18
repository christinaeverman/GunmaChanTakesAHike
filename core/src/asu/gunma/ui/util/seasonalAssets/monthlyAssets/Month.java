package asu.gunma.ui.util.seasonalAssets.monthlyAssets;

import com.badlogic.gdx.graphics.Color;

import java.text.SimpleDateFormat;
import java.util.Date;

import asu.gunma.ui.util.seasonalAssets.Fall;
import asu.gunma.ui.util.seasonalAssets.Season;
import asu.gunma.ui.util.seasonalAssets.Spring;
import asu.gunma.ui.util.seasonalAssets.Summer;
import asu.gunma.ui.util.seasonalAssets.Winter;

abstract public class Month {
    public String grassImage;
    public Color backgroundColor;

    public Season season;

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public static Month getMonth() {
        Date currentDate = new Date();
        SimpleDateFormat formatMonth = new SimpleDateFormat("MM");
        SimpleDateFormat formatDay = new SimpleDateFormat("dd");

        String monthString = formatMonth.format(currentDate);
        String dayString = formatDay.format(currentDate);

        int month = Integer.parseInt(monthString);
        int day = Integer.parseInt(dayString);

        return new October(new Fall());

//        if (month == 1) {
//            return new January(new Winter());
//        } else if (month == 2) {
//            return new February(new Winter());
//        } else if (month == 3 && day < 20) {
//            return new March(new Winter());
//        } else if (month == 3) {
//            return new March(new Spring());
//        } else if (month == 4) {
//            return new April(new Spring());
//        } else if (month == 5) {
//            return new May(new Spring());
//        } else if (month == 6 && day < 21) {
//            return new June(new Spring());
//        } else if (month == 6) {
//            return new June(new Summer());
//        } else if (month == 7) {
//            return new July(new Summer());
//        } else if (month == 8) {
//            return new August(new Summer());
//        } else if (month == 9 && day < 23) {
//            return new September(new Summer());
//        } else if (month == 9) {
//            return new September(new Fall());
//        } else if (month == 10) {
//            return new October(new Fall());
//        } else if (month == 11) {
//            return new November(new Fall());
//        } else if (month == 12 && day < 21) {
//            return new December(new Fall());
//        } else {
//            return new December(new Winter());
//        }
    }


}
