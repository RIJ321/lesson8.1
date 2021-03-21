package kg.geektech.les8.players;

import kg.geektech.les8.game.RPG_Game;

public class Medic extends Hero {
    private int healPoints;

    public Medic(int health, int damage, int healPoints) {
        super(health, damage, SuperAbility.HEAL);
        this.healPoints = healPoints;
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && this != heroes[i] && heroes[i].getHealth() != 0
                    && heroes[i].getSuperAbility() != SuperAbility.SACRIFICE) {
                heroes[i].setHealth(heroes[i].getHealth() + healPoints);

            }
        }
        System.out.println("Healed: " + healPoints);
    }
}
