import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.lang.Thread;

public class Player {
    private final int maxStrength = Integer.MAX_VALUE;
    private static double health = 100;
    private static int knowledge = 0;
    private static int strength = 0;
    private static ArrayList<String> spells = new ArrayList<String>();
    private ArrayList<Integer> timesSpellsUsed = new ArrayList<Integer>();
    private static Map<Integer, Integer> spellsPower = new HashMap<Integer, Integer>();
    private static Map<Integer, String> spellsDescription = new HashMap<Integer, String>();
    private static Map<Integer, Integer> spellsRemaining = new HashMap<Integer, Integer>();
    private static Inventory inventory;
    private static ArrayList<String> avaliableSpells = new ArrayList<String>();
    private static String[] avaliableItems = { "Bulbadox powder", "Mandrake", "Exploding Potion", "Venomous Tentacula",
            "Instant Darkness Powder", "Draught of Living Death", "Amortentia Potion" };
    private ArrayList<String> currentItems = new ArrayList<String>();
    private static int tries = 3;
    private boolean healUsed = false;

    public Player() {
        spells.add("Expelliamus");
        spells.add("Stupefy");
        currentItems.add("Bulbadox powder");
        currentItems.add("Mandrake");
        avaliableSpells.add("Petrificus Totalus");
        avaliableSpells.add("Confundo");
        avaliableSpells.add("Impediment");
        avaliableSpells.add("Levicorpus");
        avaliableSpells.add("Rictusempra");
        avaliableSpells.add("Sectumsempra");
        inventory = new Inventory();
        spellsPower.put(0, (int) (Math.random() * 19 + 25));
        spellsPower.put(1, (int) (Math.random() * 19 + 25));
        spellsPower.put(2, (int) (Math.random() * 19 + 25));
        spellsPower.put(3, (int) (Math.random() * 19 + 25));
        spellsPower.put(4, (int) (Math.random() * 19 + 25));
        spellsPower.put(5, (int) (Math.random() * 19 + 25));
        spellsPower.put(6, (int) (Math.random() * 19 + 25));
        spellsPower.put(7, (int) (Math.random() * 19 + 25));
        spellsDescription.put(0, "disarms the opponent");
        spellsDescription.put(1, "stuns the opponent");
        spellsDescription.put(2, "paralyzes the opponent");
        spellsDescription.put(3, "confuses the opponent");
        spellsDescription.put(4, "slows/stops the opponent");
        spellsDescription.put(5, "hangs the opponent upside down by their ankle");
        spellsDescription.put(6, "causes the opponent to buckle with laughter");
        spellsDescription.put(7, "inflicts deep cuts on the opponent");
        for (int i = 0; i < 8; i++) {
            int rand = (int) (Math.random() * 3 + 2);
            timesSpellsUsed.add(rand);
            spellsRemaining.put(i, (int) rand);
        }
    }

    public void resetTries() {
        for (int i = 0; i < spellsRemaining.size(); i++) {
            spellsRemaining.replace(i, timesSpellsUsed.get(i));
        }
    }

    public void attack(Enemy enemy) {
        System.out.println("Select one of the options below to attack the enemy\n0 : Use item");
        for (int s = 0; s < spells.size(); s++) {
            if (spellsRemaining.get(s) != 0) {
                System.out.println(s + 1 + " : " + spells.get(s));
            } else {
                continue;
            }
        }
        System.out.println("-1 : spells guide");
        System.out.println("-2 : items guide");
        if (!healUsed) {
            System.out.println("-3 : heal");
        }
        checkInput(enemy);
    }

    public void attack(String item, Enemy enemy) {
        inventory.useItem(item);
        int damage = inventory.getPower(item);
        enemy.setHealth(enemy.getHealth() - damage);
        System.out.println("\nThe enemy lost " + damage + " health points!\n");
        System.out.println("Enemy Health: " + enemy.getHealth() + "\n");
    }

    public void checkInput(Enemy enemy) {
        int userAttack = -4;
        Scanner s1 = new Scanner(System.in);
        System.out.print("\nAttack: ");

        while (!s1.hasNextInt()) {
            System.out.println("Invalid input");
            s1 = new Scanner(System.in);
            System.out.println("\nAnswer: ");
        }

        userAttack = s1.nextInt();

        if (userAttack != 0 && strength < maxStrength && userAttack != -1 && userAttack != -2
                && userAttack != -3) {
            if (spellsRemaining.get(userAttack - 1) > 0) {
                int damage = (strength / 15) + spellsPower.get(userAttack - 1) - (enemy.getStrength() / 20);
                enemy.setHealth(enemy.getHealth() - damage);
                System.out.println("\n" + spells.get(userAttack - 1) + "!");
                System.out.println("\nThe enemy lost " + damage + " health points\n");
                System.out.println("Enemy Health: " + enemy.getHealth() + "\n");
                spellsRemaining.replace(userAttack - 1, spellsRemaining.get(userAttack - 1) - 1);
            } else {
                System.out.println(
                        "\nYou have already used up the attacks for this spell. Please use a different spell or item.");
                checkInput(enemy);
            }
        } else if (userAttack == 0) {
            ArrayList<String> items = inventory.getItemsInUse();
            if (items.size() == 0) {
                System.out.println("\nNo items avaliable\n");
            } else {
                for (int i = 0; i < items.size(); i++) {
                    System.out.println(i + 1 + " : " + items.get(i));
                }
                System.out.println("0: Quit");
                Scanner s2 = new Scanner(System.in);
                System.out.print("\nItem: ");
                while (!(s2.hasNextInt())) {
                    s2 = new Scanner(System.in);
                    System.out.print("\nItem:  ");
                }
                int item = s2.nextInt();
                if (item == 0) {
                    attack(enemy);
                } else {
                    boolean validItem = item - 1 < items.size();
                    while (!validItem) {
                        System.out.println("Invalid input. Please try again.\n");
                        s2 = new Scanner(System.in);
                        System.out.print("Item: ");
                        item = s2.nextInt();
                        validItem = item - 1 < items.size();
                    }
                    attack(items.get(item - 1), enemy);
                }
            }
        } else if (userAttack == -1) {
            String description = null;

            for (int s = 0; s < spells.size(); s++) {
                int damage = (strength / 15) + spellsPower.get(s) - (enemy.getStrength() / 20);
                description = "\n" + spells.get(s) + " -- " + spellsDescription.get(s) + " --  attack power: "
                        + damage + " -- attacks remaining: " + spellsRemaining.get(s);
                System.out.println(description);
            }
            checkInput(enemy);
        } else if (userAttack == -2) {
            for (int i = 0; i < inventory.getItemsInUse().size(); i++) {
                String inventoryDescription = null;
                String item = inventory.getItemsInUse().get(i);
                inventoryDescription = "\n" + item + " -- " + inventory.getDescription(item) + " -- attack power: "
                        + inventory.getPower(item);
                System.out.println(inventoryDescription);
            }
            checkInput(enemy);
        } else if (userAttack == -3) {
            healUsed = true;
            health += 50;
            System.out.println("\nHealing...\n");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("\nYour health increased by 50 points!\n");
            System.out.println("Player health: " + health + "\n");
        } else {
            System.out.println("\nInvalid input");
            checkInput(enemy);
        }
    }

    public void addItem(String item) {
        inventory.getItemsInUse().add(item);

    }

    public void setItemsInUse(ArrayList<String> ls) {
        inventory.setItemsInUse(ls);
    }

    public void showStats() {
        System.out.println("Health: " + health);
        System.out.println("Strength: " + strength);
        System.out.println("Knowledge: " + knowledge);
        String itemOut = "Items: ";
        if (inventory.getItemsInUse().size() == 0) {
            itemOut += "None\n";
        } else {
            for (String i : inventory.getItemsInUse()) {
                itemOut += i + ", ";
            }
        }
        System.out.println(itemOut);
        System.out.println("Tries remaining: " + tries + "\n");
    }

    public void setKnowledge(int i) {
        knowledge = i;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public void setStrength(int s) {
        strength = s;
    }

    public int getStrength() {
        return strength;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double i) {
        health = i;
    }

    public ArrayList<String> getSpells() {
        return spells;
    }

    public ArrayList<String> getItems() {
        return inventory.getItemsInUse();
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int t) {
        tries = t;
    }

    public ArrayList<String> getAvaliableSpells() {
        return avaliableSpells;
    }

    public void setAvaliableSpells(ArrayList<String> ls) {
        avaliableSpells = ls;
    }

    public String[] getAvaliableItems() {
        return avaliableItems;
    }

    public void setCurrentItems(ArrayList<String> ls) {
        currentItems = ls;
    }

    public ArrayList<String> getCurrentItems() {
        return currentItems;
    }

    public void setHealUsed(boolean b) {
        healUsed = b;
    }

}