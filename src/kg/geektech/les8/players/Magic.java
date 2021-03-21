package kg.geektech.les8.players;

import kg.geektech.les8.game.RPG_Game;

public class Magic extends Hero {
    public Magic(int health, int damage) {
        super(health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int medicsRandomDamage = RPG_Game.random.nextInt(4) + 1;

        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && this.getHealth() > 0)
                boss.setHealth(boss.getHealth() - medicsRandomDamage);
        }
        System.out.println("Mage increase damage for: " + (heroes.length * medicsRandomDamage));
    }
}
