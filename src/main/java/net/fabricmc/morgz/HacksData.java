//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.fabricmc.morgz;

import java.util.Vector;

public class HacksData {
    private static HacksData INSTANCE;
    private boolean xrayEnabled = false;
    private boolean fullbrightEnabled = false;
    private boolean fullbrightManuallyEnabled = false;

    // Right now just used to write enabled hacks to screen. Later maybe replace with Hack class
    private static Vector<String> enabledHacks = new Vector<String>();

    private HacksData() {
    }

    public static HacksData getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HacksData();
        }

        return INSTANCE;
    }

    public void toggleXrayEnabled() {
        this.xrayEnabled = !this.xrayEnabled;

        if(xrayEnabled) {
            enabledHacks.addElement("Xray");
        }
        else {
            enabledHacks.removeElement("Xray");
        }
    }

    public boolean getXrayEnabled() {
        return this.xrayEnabled;
    }

    public void toggleFullbrightManuallyEnabled() {
        this.fullbrightEnabled = !this.fullbrightEnabled;
        this.fullbrightManuallyEnabled = !this.fullbrightManuallyEnabled;

        if(fullbrightManuallyEnabled) {
            enabledHacks.addElement("Fullbright");
        }
        else {
            enabledHacks.removeElement("Fullbright");
        }
    }

    public void enableFullbrightXray() {
        this.fullbrightEnabled = true;
    }

    public void disableFullbrightXray() {
        this.fullbrightEnabled = false;
    }

    public boolean getFullbrightEnabled() {
        return this.fullbrightEnabled;
    }

    public boolean getFullbrightManuallyEnabled() {
        return this.fullbrightManuallyEnabled;
    }

    static public Vector<String> getEnabledHacksNames() {
        return enabledHacks;
    }
}
