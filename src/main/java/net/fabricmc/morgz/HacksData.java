// Singleton containing info about what hacks are enabled/disabled

package net.fabricmc.morgz;

public class HacksData {
    private static  HacksData INSTANCE;
    private boolean xrayEnabled = false;

    private HacksData() {

    }

    public static HacksData getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new HacksData();
        }
        return INSTANCE;
    }

    public void toggleXrayEnabled() {
        xrayEnabled = !xrayEnabled;
    }

    public boolean getXrayEnabled() {
        return xrayEnabled;
    }
}
