package kg.geektech.les8.players;

import kg.geektech.les8.game.RPG_Game;

import java.util.Random;

public class Thor extends Hero{
    public Thor(int health, int damage) {
        super(health, damage, SuperAbility.CAN_STUN);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int thorsPossibility = RPG_Game.random.nextInt(4);

        for (int i = 0; i < heroes.length; i++) {
            if (thorsPossibility == 1) {
                heroes[i].setHealth(heroes[i].getHealth() + boss.getDamage());
            }
        } if (thorsPossibility == 1) {
            System.out.println("Thor stunning. " + thorsPossibility);
        }

    }
}
