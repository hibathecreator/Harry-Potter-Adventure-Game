
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Enemy {
    private double health = 100;
    private String name;
    private int strength;
    private final static String[] attacks = { "Crucio", "Expelliamus", "Stupefy", "Petrificus Totalus", "Confundo",
            "Impediment", "Bombarda", "Rictumsempra", "Sectumsempra" };
    private final static String[] enemies = { "Pettigrew", "Crouch Jr.", "Umbridge", "Greyback", "Lucius", "Bellatrix",
            "Voldermort" };
    private final static String[] evilQuotes = { "Prepare to die!", "You will not make it out of this alive!",
            "I will destroy you!!!", "Don't mess around with me", "I told you not to pick a fight with me...",
            "Prepare your last words", "Filthy Mudblood!! I WILL KILL YOU!!!" };
    private final static String[] scenarios = {
            "You are wandering through the forest searching for a sopophorous bean, a common ingredient in potion making, when you hear someone apparate behind you! ",
            "You are in your study reading through \" History of Magic\" by Bathilda Bagshot when someone breaks through the window and lands on your desk! ",
            "You are playing Quidditch with your younger sister. You pass the quaffle ball to your sister who throws it towards the hoop. But somone catches it! You fly closer to get a better look... ",
            "You are practicing wand movement for \"Accio\" when you hear a voice. A spell flys by you ear, hits your dummy, and blows it up into pieces! You turn around quickly and see an enemy! ",
            "You are in the kitchen making Sticky Toffee Pudding for your friend Hermione who is going to arrive any second. You hear the doorbell ring but when you open the door, you don't see Hermione... ",
            "You are at Flourish and Boltt's, a stationary store, in Diagon Alley, buying some quills, parchment, and \"Care of Magical Creatures\" when you hear commotion at the front of the store. You run towards the see someone will the cashier! ",
            "You get tired of waiting around and decide to put your skills to the test. You attack an enemy base where five muggles are being held hostage and defeat the death eaters guarding the entrance. But just as you are about to untie the muggles, you turn around and see an enemy! "
    };
    private static ArrayList<String> quotes = new ArrayList<String>(Arrays.asList(evilQuotes));
    private static ArrayList<String> levelScenarios = new ArrayList<String>(Arrays.asList(scenarios));

    public Enemy(int level, int playerStrength) {
        name = enemies[level];
        strength = 25 + (level + 1) * playerStrength / 8;
        health = 100;
    }

    public Enemy() {
    }

    public Enemy(String name, int strength) {
        this.name = name;
        health = 100;
        this.strength = strength;
        if (Arrays.asList(attacks).contains(name)) {
            this.name = name;
            strength = (Arrays.asList(enemies).indexOf(name) + 1) * 10;
        }
        health = 100;
    }

    public String toString() {
        String quote = quotes.get(Level.getLevel());
        String scenario = levelScenarios.get(Level.getLevel());
        return scenario + "\n" + name
                + " has appeared!\n\nThe opponent's battle strength is " + strength + " points.\n\n" + name + ": \""
                + quote + "\" \n";
    }

    public void attack(Player player) {
        Random r1 = new Random();
        String attack = attacks[r1.nextInt(attacks.length - 1)];
        double damage = (strength / 10) + (Arrays.asList(attacks).indexOf(attack) + 1) * 5
                - (player.getStrength() / 10);
        double playerDamage = damage + (strength / 30) - (player.getStrength() / 58);
        player.setHealth(player.getHealth() - playerDamage);
        System.out.println(name + " attacks you with " + attack + "\n");
        System.out.println("You lost " + playerDamage + " health points!\n");
        System.out.println("Player health: " + player.getHealth() + "\n");
        if (health < 0) {
            Level.win();
        } else if (player.getHealth() < 0) {
            Level.lose(false, true);
        }
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double h) {
        health = h;
    }

    public int getStrength() {
        return strength;
    }
}