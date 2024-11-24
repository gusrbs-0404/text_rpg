package date;

public class PlayerItem {
    private String name;
    private int attackPower;
    private int defensePower;
    private boolean isEquipped;

    public PlayerItem(String name, int attackPower, int defensePower) {
        this.name = name;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.isEquipped = false;
    }

    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public boolean isEquipped() {
        return isEquipped;
    }

    public void setEquipped(boolean equipped) {
        this.isEquipped = equipped;
    }
}

