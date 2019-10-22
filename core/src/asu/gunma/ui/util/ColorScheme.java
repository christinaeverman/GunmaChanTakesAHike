package asu.gunma.ui.util;

import com.badlogic.gdx.graphics.Color;
import java.util.*;
import java.text.SimpleDateFormat;

public class ColorScheme {
    private int month;
    private int day;

    private static final List<Color> springColors = Collections.unmodifiableList(
            new ArrayList<Color>() {{
                add(new Color(0x97bfad01));
                add(new Color(0xffc4b201));
                add(new Color(0xff907c01));
                add(new Color(0xd8395701));
                add(new Color(0x69495201));
            }}
    );

    private static final List<Color> summerColors = Collections.unmodifiableList(
            new ArrayList<Color>() {{
                add(new Color(0x17304201));
                add(new Color(0x23637701));
                add(new Color(0xcfdfda01));
                add(new Color(0x7bad3e01));
                add(new Color(0x4a6b2f01));
            }}
    );

    private static final List<Color> fallColors = Collections.unmodifiableList(
            new ArrayList<Color>() {{
                add(new Color(0xd94c2c01));
                add(new Color(0xed861f01));
                add(new Color(0xf4d36001));
                add(new Color(0xa8ce6801));
                add(new Color(0x1b431401));
            }}
    );

    private static final List<Color> winterColors = Collections.unmodifiableList(
            new ArrayList<Color>() {{
                add(new Color(0x822b3e01));
                add(new Color(0xea223f01));
                add(new Color(0x686c5801));
                add(new Color(0x003e2f01));
                add(new Color(0x253a4901));
            }}
    );

    public ColorScheme() {
        Date currentDate = new Date();
        SimpleDateFormat formatMonth = new SimpleDateFormat("MM");
        SimpleDateFormat formatDay = new SimpleDateFormat("dd");

        String monthString = formatMonth.format(currentDate);
        String dayString = formatDay.format(currentDate);

        month = Integer.parseInt(monthString);
        day = Integer.parseInt(dayString);
    }

    /// Returns a list of colors for the current season.
    public List<Color> getSeasonalColorScheme() {
        if ((month == 12 && day >= 21) || month == 1 || month == 2 || (month == 3 && day < 20)) {
            return winterColors;
        } else if ((month == 3 && day >= 20) || month == 4 || month == 5 || (month == 6 && day < 21)) {
            return springColors;
        } else if ((month == 6 && day >= 21) || month == 7 || month == 8 || (month == 9 && day < 23)) {
            return summerColors;
        }
        return fallColors;
    }

    /// Returns path to seasonal grass image asset.
    public String getSeasonalGround() {
        if ((month == 12 && day >= 21) || month == 1 || month == 2 || (month == 3 && day < 20)) {
            return "background/grassx2_w.png";
        } else if ((month == 3 && day >= 20) || month == 4 || month == 5 || (month == 6 && day < 21)) {
            return "background/grassx2.png";
        } else if ((month == 6 && day >= 21) || month == 7 || month == 8 || (month == 9 && day < 23)) {
            return "background/grassx2.png";
        }
        return "background/grassx2.png";
    }

    public Color getColor1() {
        List<Color> colorScheme = getSeasonalColorScheme();
        return colorScheme.get(0);
    }

    public Color getColor2() {
        List<Color> colorScheme = getSeasonalColorScheme();
        return colorScheme.get(1);
    }

    public Color getColor3() {
        List<Color> colorScheme = getSeasonalColorScheme();
        return colorScheme.get(2);
    }

    public Color getColor4() {
        List<Color> colorScheme = getSeasonalColorScheme();
        return colorScheme.get(3);
    }

    public Color getColor5() {
        List<Color> colorScheme = getSeasonalColorScheme();
        return colorScheme.get(4);
    }
}