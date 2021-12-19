import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int input = 0;
        System.out.println(
                "\nMagical World Adventure Game\n\nWelcome to the land of magic! Select an option below to get started\n1-Help\n2-Spells and Potions Guide[READ ME]\n3-Get Started");
        Scanner s1 = new Scanner(System.in);
        System.out.print("\nEnter 1, 2, or 3: ");
        if (s1.hasNextInt()) {
            input = s1.nextInt();
        }
        while (input != 3) {
            evaluateInput(input);
            Scanner s2 = new Scanner(System.in);
            System.out.print("Enter 1, 2, or 3: ");
            if (s2.hasNextInt()) {
                input = s2.nextInt();
            }
        }
        evaluateInput(input);
    }

    public static void evaluateInput(int input) {
        if (input == 1) {
            System.out.println(
                    "\nBackstory-\nEvil forces threaten the peace of the wizarding world. As a young witch/wizard, you must hone your skills to become powerful and wise sorcerer so you can battle and defeat enemies who threaten your land. \n\n"
                            +
                            "Knowledge Test-\nEach year/level, you will test your knowledge by answering some questions about spells to test your intellectual prowess. The number of questions you get correct will determine how many knowledge points you gain. You must answer at least 3 of the 5 questions correctly to proceed. if you get stuck, type \"help\" where it says \"Answer: \" to get access to the Spells and Potions Guide again. "
                            +
                            "You can only use this command three times throughout the entire game so make sure to read over the guide carefully each time you use it. If you fail to get three or more questions right, you can use one of your three lives to try again.\n\nStrength Test-\nAfter you have passed the knowledge test, you will battle an evil witch/wizard using the spells and items you have. You can only use spells a limited number of times and you can find this information, along with more details about the"
                            +
                            "function and power of the spell, using the spells guide which will be made avaliable to you throughout the battle. You can only use items once and you learn more about each item, its effects, and power using the items guide which you will also have access during the battle."
                            +
                            "Every time you pass a level, you will recieve a new spell and item that you can use to battle your enenmy. During each battle, you can heal yourself once to regain 50 health points. If you are unable to defeat your opponent, you can use a life to redo the battle.You only have three lives throughout the entire game(seven levels) and if you use them all up, you lose.\n\n"
                            +
                            "Tips: if you are new to the game, remember to read through the guide which will have the information you need to answer the questions correctly. Also, when you get a new opponent, use the spells and items guide to see how much power each spell/item before you attack. This will greatly increase your chances of winning.\n");
        } else if (input == 2) {
            System.out.println("\nSpells Guide\n" + "Lumos - used to cast a light\n"
                    + "Nox - used to extinguish a light\n"
                    + "Expelliamus - disarms the opponent\n" + "Stupefy - stuns the opponent\n"
                    + "Alahamora - used to unlock doors\n" + "Wingardium Leviosa - used to levitate objects\n"
                    + "Reparo - used to repair objects\n" + "Pertificus Totalus - paralyzes the opponent\n"
                    + "Diffindo - rips/tears objects\n" + "Confundo- confuses the opponent\n"
                    + "Bombarda - detonates the target in a small explosion\n"
                    + "Defedio - wraps the opponent in ropes\n"
                    + "Expecto Patronum - will cast a patronous and protect you from death eaters\n"
                    + "Accio - used to summon objects\n" + "Incendio- used to start a fire\n"
                    + "Scourgify - used to do cleaning\n" + "Episkey- used to heal minor injuries\n"
                    + "Protego - used to create a protective, temporary shield\n"
                    + "Salvio Hexia/Protego Totalum - used to cast a protective barrier\n"
                    + "Impediment - used to hinder the movement of opponent by slowing/stopping them\n"
                    + "Rictumsempra - causes a victim to buckle with laughter\n"
                    + "Levicorpus - hoists the opponent in the air by their ankle\n"
                    + "Liberacorpus - counter spell for levicorpus\n"
                    + "Impervius - allows the user better sight during bad weather conditions when user is wearing glasses\n"
                    + "Reducio - shrinks objects\n" + "Mufliato- creates a bubble of silence around the user\n"
                    + "Obliviate - erases the victim's memories\n"
                    + "Sectumsempra - deeply cuts opponent and causes haemorrhaging\n"
                    + "Riddikulus - used to defeat Boggart\n"
                    + "Unforgivable curses - Avada Kedavra(kills opponent), Crucio(tortures opponent), Imperius(controls opponent against their will)\n"
                    + "\nItems Guide\n" + "Bulbadox Powder - causes the victim's skin to break out in boils\n"
                    + "Mandrake- when matured, this magical plant's cry can be fatal to any person who hears it\n"
                    + "Exploding Potion - causes an explosion when released from the bottle and harms anything in its vicinity\n"
                    + "Venemous Tentacula - a magical plant with vines that tries to grab and strangle its prey\n"
                    + "Instant Darkness Powder - clouds the view of the opponent and causes them to accidentally attack themselves\n"
                    + "Draught of Living Death - causes the opponent to fall asleep\n"
                    + "Amortentia Potion - distracts the opponent and temporarily prevents them from casting a spell\n");
        } else if (input == 3) {
            Level.run(0);
        } else {
            System.out.println("Invalid input");
        }
    }

}
