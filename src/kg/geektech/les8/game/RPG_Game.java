package kg.geektech.les8.game;

import kg.geektech.les8.players.*;

import java.util.Random;

public class RPG_Game {
    private static int roundNumber = 0;
    public static Random random = new Random();
    public static int hackersChoice;

    public static void start() {
        Boss boss = new Boss(3800, 50);

        Warrior warrior = new Warrior(250, 20);
        Medic doc = new Medic(220, 10, 15);
        Magic magic = new Magic(270, 25);
        Berserk berserk = new Berserk(260, 15);
        Medic assistant = new Medic(265, 15, 5);
        Thor thor = new Thor(250, 15);
        Tank tank = new Tank(400, 10);
        Hacker hacker = new Hacker(260, 20);
        Shaman youh = new Shaman(300, 20);
        Witcher witcher = new Witcher(270, 0);

        Hero[] heroes = {magic, warrior, berserk, doc, assistant, witcher,youh, hacker, thor, tank};
        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        System.out.println("\n" + ++roundNumber + " --- ROUND"); // pre-increment
        if (boss.getHealth() > 0) {
            bossHits(boss, heroes);
        }
        heroesHit(boss, heroes);
        hackersChoice++;
        heroesApplySuperPower(boss, heroes);
        printStatistics(boss, heroes);

    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesApplySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperAbility(boss, heroes);
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0
                    && heroes[i].getSuperAbility() != SuperAbility.CRITICAL_DAMAGE
                    && heroes[i].getSuperAbility() != SuperAbility.SOUL_DAMAGE) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    public static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("\n+++++++++++++++++++++");
        System.out.println("Boss health: " + boss.getHealth() + "  [" +
                boss.getDamage() + "]\n");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() +
                    " health: " + heroes[i].getHealth() + "  [" +
                    heroes[i].getDamage() + "]");
        }
    }
}
