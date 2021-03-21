package kg.geektech.les8.players;

import kg.geektech.les8.game.RPG_Game;

public class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            int coefficient = RPG_Game.random.nextInt(3) + 2; //2,3,4
            int fullDamage = this.getDamage() * coefficient;
            boss.setHealth(boss.getHealth() - fullDamage);
            System.out.println("Warrior hits critically: " +
                    ((this.getDamage() * coefficient) - this.getDamage()));
        }
    }
}
