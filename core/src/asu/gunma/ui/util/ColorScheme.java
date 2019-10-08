package asu.gunma.ui.util;

import com.badlogic.gdx.graphics.Color;
import java.util.*;
import java.text.SimpleDateFormat;

public class ColorScheme {
    private int month;
    private int day;

    private static final List<Color> springColors = Collections.unmodifiableList(
        new ArrayList<Color>() {{
                add(Color.BLUE);
                add(Color.LIME);
        }}
    );

    private static final List<Color> summerColors = Collections.unmodifiableList(
            new ArrayList<Color>() {{
                add(Color.BLUE);
                add(Color.LIME);
            }}
    );

    private static final List<Color> fallColors = Collections.unmodifiableList(
            new ArrayList<Color>() {{
                add(Color.BLUE);
                add(Color.LIME);
            }}
    );

    private static final List<Color> winterColors = Collections.unmodifiableList(
            new ArrayList<Color>() {{
                add(Color.BLUE);
                add(Color.LIME);
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
