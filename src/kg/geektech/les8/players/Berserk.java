package kg.geektech.les8.players;

import kg.geektech.les8.game.RPG_Game;

import java.util.Random;

public class Berserk extends Hero {
    public Berserk(int health, int damage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0 && this.getHealth() > 0) {
            int berserkerDamage = boss.getDamage() / 3;
            boss.setHealth(boss.getHealth() - berserkerDamage);
            System.out.println("Berserker's additional damage: " + berserkerDamage);
        }
    }
}
