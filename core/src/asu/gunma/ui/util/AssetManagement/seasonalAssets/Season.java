package asu.gunma.ui.util.AssetManagement.seasonalAssets;

import com.badlogic.gdx.graphics.Color;

import java.text.SimpleDateFormat;
import java.util.Date;

abstract public class Season {
    public static Season currentSeason = Season.getSeason();

    public static Color backgroundColor = currentSeason.backgroundColor;

    public static Season getSeason() {
        Date currentDate = new Date();
        SimpleDateFormat formatMonth = new SimpleDateFormat("MM");
        SimpleDateFormat formatDay = new SimpleDateFormat("dd");

        String monthString = formatMonth.format(currentDate);
        String dayString = formatDay.format(currentDate);

        int month = Integer.parseInt(monthString);
        int day = Integer.parseInt(dayString);

        if ((month == 12 && day >= 21) || month == 1 || month == 2 || (month == 3 && day < 20)) {
            return new Winter();
        } else if (month == 3 || month == 4 || month == 5 || (month == 6 && day < 21)) {
            return new Spring();
        } else if (month == 6 || month == 7 || month == 8 || (month == 9 && day < 23)) {
            return new Summer();
        }
        return new Fall();
    }
}
