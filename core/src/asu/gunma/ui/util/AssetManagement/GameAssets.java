package asu.gunma.ui.util.AssetManagement;

import java.util.Locale;
import java.util.ResourceBundle;

public class GameAssets {
    // Localization assets
    public String localeString = "jp";
    private Locale locale;
    private ResourceBundle bundle;
    public ResourceBundle getResourceBundle() {
        locale = new Locale(localeString);
        bundle = MyResources.getBundle("asu.gunma.ui.util.AssetManagement.MyResources", locale);
        return bundle;
    }
    public void setLocale(String lang) {
        localeString = lang;
    }
}
