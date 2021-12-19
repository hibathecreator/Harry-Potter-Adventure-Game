import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private static ArrayList<String> itemsInUse = new ArrayList<String>();
    private static Map<String, String> itemsDescription = new HashMap<String, String>();
    private static Map<String, Integer> itemsPower = new HashMap<String, Integer>();
    private static String[] avaliableItems = { "Bulbadox powder", "Mandrake", "Exploding Potion", "Venomous Tentacula",
            "Instant Darkness Powder", "Draught of Living Death", "Amortentia Potion" };

    public Inventory() {
        itemsInUse.add("Bulbadox powder");
        itemsInUse.add("Mandrake");
        itemsDescription.put("Bulbadox powder", "Causes the victim's skin to break out in boils");
        itemsDescription.put("Mandrake", "When matured, its cry can be fatal to any person who hears it");
        itemsDescription.put("Exploding Potion",
                "Causes an explosion when released from the bottle, harming those in the vicinity");
        itemsDescription.put("Venomous Tentacula",
                "a magical plant with vines that tries to grab and strangle its prey");
        itemsDescription.put("Instant Darkness Powder",
                "Clouds the view of the opponent, causing them to accidently attack themselves");
        itemsDescription.put("Draught of Living Death", "Causes the opponent to fall asleep");
        itemsDescription.put("Amortentia Potion",
                "distracts the opponent and temporarily prevents them from casting a spell");
        itemsPower.put("Bulbadox powder", (int) (Math.random() * 19 + 20));
        itemsPower.put("Mandrake", (int) (Math.random() * 19 + 20));
        itemsPower.put("Exploding Potion", (int) (Math.random() * 19 + 20));
        itemsPower.put("Venomous Tentacula", (int) (Math.random() * 19 + 20));
        itemsPower.put("Instant Darkness Powder", (int) (Math.random() * 19 + 20));
        itemsPower.put("Draught of Living Death", (int) (Math.random() * 19 + 20));
        itemsPower.put("Amortentia Potion", (int) (Math.random() * 19 + 20));
    }

    public ArrayList<String> getItemsInUse() {
        return itemsInUse;
    }

    public void setItemsInUse(ArrayList<String> ls) {
        itemsInUse = ls;
    }

    public static void addItem(String name) {
        for (String key : itemsDescription.keySet()) {
            if (key.equals(name)) {
                itemsInUse.add(name);
            }
        }
    }

    public String getDescription(String name) {
        String description = itemsDescription.get(name);
        return description;
    }

    public int getPower(String name) {
        int power = itemsPower.get(name);
        return power;
    }

    public void useItem(String name) {
        if (itemsInUse.contains(name)) {
            System.out.println("You used " + name + "!");
            System.out.println("Item description: " + getDescription(name));
            getItemsInUse().remove(name);
            System.out.println("Items in inventory: ");
            if (getItemsInUse().size() > 0) {
                for (String i : getItemsInUse()) {
                    System.out.print(i + ", ");
                }
                System.out.println("\n");
            } else {
                System.out.println("None");
            }
        }
    }

    public String[] getAvaliableItems() {
        return avaliableItems;
    }

}