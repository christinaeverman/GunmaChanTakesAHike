package asu.gunma.ui.util;

import com.badlogic.gdx.graphics.Color;
import java.util.*;
import java.text.SimpleDateFormat;

public class ColorScheme {
    private int month;
    private int day;

    private static final List<Color> springColors = Collections.unmodifiableList(
        new ArrayList<Color>() {{
                add(new Color(151, 191, 173, 1));
                add(new Color(255, 196, 178, 1));
                add(new Color(255, 144, 124, 1));
                add(new Color(216, 57, 87, 1));
                add(new Color(105, 73, 82, 1));
        }}
    );

    private static final List<Color> summerColors = Collections.unmodifiableList(
            new ArrayList<Color>() {{
                add(new Color(23, 48, 66, 1));
                add(new Color(35, 99, 119, 1));
                add(new Color(207, 223, 218, 1));
                add(new Color(123, 173, 62, 1));
                add(new Color(74, 107, 47, 1));
            }}
    );

    private static final List<Color> fallColors = Collections.unmodifiableList(
            new ArrayList<Color>() {{
                add(new Color(217, 76, 44, 1));
                add(new Color(237, 134, 31, 1));
                add(new Color(244, 211, 96, 1));
                add(new Color(168, 206, 104, 1));
                add(new Color(27, 67, 20, 1));
            }}
    );

    private static final List<Color> winterColors = Collections.unmodifiableList(
            new ArrayList<Color>() {{
                add(new Color(130, 43, 62, 1));
                add(new Color(234, 34, 63, 1));
                add(new Color(104, 108, 88, 1));
                add(new Color(0, 62, 47, 1));
                add(new Color(37, 58, 73, 1));
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

    public List<Color> getSeasonalColorScheme() {
        if ((month == 12 && day >= 21) || month == 1 || month == 2 || (month == 3 && day < 20)) {
            return springColors;
        } else if ((month == 3 && day >= 20) || month == 4 || month == 5 || (month == 6 && day < 21)) {
            return summerColors;
        } else if ((month == 6 && day >= 21) || month == 7 || month == 8 || (month == 9 && day < 23)) {
            return fallColors;
        }
        return winterColors;
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
