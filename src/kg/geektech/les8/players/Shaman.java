package kg.geektech.les8.players;

import kg.geektech.les8.game.RPG_Game;

public class Shaman extends Hero {
    public Shaman(int health, int damage) {
        super(health, damage, SuperAbility.SOUL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int soulKnightHit = RPG_Game.random.nextInt(this.getDamage());
        int hitsPossibility = RPG_Game.random.nextInt(15);

        if (this.getHealth() > 0 && hitsPossibility == 2) {
            boss.setHealth(boss.getDamage() - soulKnightHit);
            System.out.println("                                        Soul knight hits: +" + soulKnightHit);
        }
    }
}











