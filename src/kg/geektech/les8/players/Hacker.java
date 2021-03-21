package kg.geektech.les8.players;

import kg.geektech.les8.game.RPG_Game;

public class Hacker extends Hero {


    public Hacker(int health, int damage) {
        super(health, damage, SuperAbility.HACKER);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int partHealth = RPG_Game.random.nextInt(this.getDamage());
        int randomHero = RPG_Game.random.nextInt(heroes.length);

        for (int i = 1; i < this.getDamage(); i++) {
            if (RPG_Game.hackersChoice % 2 == 0 && this.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - partHealth);
                heroes[randomHero].setHealth(heroes[randomHero].getHealth() + partHealth);
                System.out.println("\nHacker gave health to: " + heroes[randomHero].getClass().getSimpleName()
                        + " +" + partHealth);
                break;
            }
        }
    }
}
