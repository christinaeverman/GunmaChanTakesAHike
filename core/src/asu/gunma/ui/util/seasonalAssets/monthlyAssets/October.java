package asu.gunma.ui.util.seasonalAssets.monthlyAssets;

import asu.gunma.ui.util.seasonalAssets.Season;
import asu.gunma.ui.util.seasonalAssets.Spring;

import com.badlogic.gdx.graphics.Color;

public class October extends Month {
    private Season season;

    public Color _backgroundColor = backgroundColor = season.backgroundColor;

    public October(Season s) {
        season = s;
    }
}
