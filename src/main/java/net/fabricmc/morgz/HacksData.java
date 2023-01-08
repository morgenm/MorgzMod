//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.fabricmc.morgz;

public class HacksData {
    private static HacksData INSTANCE;
    private boolean xrayEnabled = false;
    private boolean fullbrightEnabled = false;
    private boolean fullbrightManuallyEnabled = false;

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
    }

    public boolean getXrayEnabled() {
        return this.xrayEnabled;
    }

    public void toggleFullbrightManuallyEnabled() {
        this.fullbrightEnabled = !this.fullbrightEnabled;
        this.fullbrightManuallyEnabled = !this.fullbrightManuallyEnabled;
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
}
