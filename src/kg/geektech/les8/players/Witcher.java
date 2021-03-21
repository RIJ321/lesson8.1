package kg.geektech.les8.players;

import kg.geektech.les8.game.RPG_Game;

public class Witcher extends Hero {
    public Witcher(int health, int damage) {
        super(health, damage, SuperAbility.SACRIFICE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int randomHero = RPG_Game.random.nextInt(heroes.length);
        for (int i = 0; i < 1; i++) {

            if (heroes[randomHero].getHealth() < 100 && this.getHealth() > 0 && this.getHealth() != 0 ) {
                heroes[randomHero].setHealth(heroes[randomHero].getHealth() + this.getHealth());
                System.out.println("                                                       Wither is sacrificed for: " + heroes[randomHero].getClass().getSimpleName()
                        + " +" + this.getHealth());
                this.setHealth(0);
                break;
            }
        }
    }
}
