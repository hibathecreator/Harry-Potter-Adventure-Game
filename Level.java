import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Level {
    private static boolean gameOn = true;
    private static int level;
    private final static String[][] answers = { { "a", "d", "c", "a", "c" }, { "c", "b", "c", "a", "a" },
            { "d", "a", "a", "b", "d" },
            { "b", "d", "c", "d", "a" }, { "d", "d", "a", "a", "b" }, { "b", "a", "c", "b", "a" },
            { "c", "b", "d", "d", "c" } };

    private final static String[][] questions = { {
            "\nWhat spell cast/extinguish a light?\na- Lumos/Nox\nb- Nox/Glisseo\nc- Wingardium Leviosa/Lumos\nd- Defodio/Protego",
            "\nWhat spell is used to levitate objects?\na- Riddikulus\nb- Accio\nc- Alohomora\nd- Wingardium Leviosa",
            "\nWhat incancation creates an invisible shield?\na- Lumos\nb- Oppugno\nc- Protego\nd- Expelliamis ",
            "\nWhat spells disarms the opponent?\na- Expelliamis\nb- Stupefy\nc- Expecto Patronum\nd- Protego",
            "\nWhat item causes the victim's skin to break out in boils?\na-Mandrake\nb-Venemous Tentacula\nc-Bulbadox Powder\nd-Amortentia Potion" },
            { "\nWhat spell unlocks doors?\na-Evenesco\nb-Petrificus Totalus\nc-Alohomora\nd-Geminio",
                    "\nWhat spell summons objects?\na- Periculum\nb- Accio\nc- Expecto Patronum\nd- Lumos",
                    "\nWhat spell is used to do cleaning?\na -Lumos\nb- Salvio Hexia\nc- Scourgify\nd- Episkey",
                    "\nWhat spell can be used to heal minor injuries?\na- Episkey\nb- Protego\nc- Impervius\nd- Scourgify",
                    "\nWhat magical plant, when matured, has a cry that can be fatal to any person who hears it?\na-Mandrake\nb-Venemous Tentacula\nc-Instant Darkness Powder\nd-Amorentia Potion" },
            { "\nWhat spell is used to repair objects?\na- Vera Verto\nb- Stupefy\nc- Descendo\nd- Reparo",
                    "\nWhat spell will protect you from death eaters?\na- Expecto patronum\nb- Wingardium Leviosa\nc- Sectumsempra\nd- Aguamenti",
                    "\nWhat spell stuns the target?\na- Stupefy\nb- Alohomora\nc- Reducto\nd- Accio",
                    "\nWhat spell confuses the opponent?\na- Avada Kedavra\nb- Confundo\nc- Sectumsempra\nd- Expelliamis",
                    "\nWhat potion can cause an explosion, when released from the bottle, and harm anything in its vicinity?\na-Bulbadox powder\nb-Instant Darkness Powder\nc-Draught of Living Death\nd-Exploding Potion" },
            { "\nWhat spell detonates the target in a small explosion?\na- Immobulus\nb- Bombarda\nc- Confringo \nd- Langlock",
                    "\nWhat spell wraps the opponent in ropes?\na- Salvio Hexia\nb- Incarcerous\nc- Confundo\nd- Defodio",
                    "\nWhat spell is used to paralyze the opponent?\na- Engorgio\nb- Levicorpus\nc- Petrificus Totalus\nd- Muffliato",
                    "\nWhat incantation causes a rip or tear in objects?\na- Reducto\nb- Oppugno\nc- Impedimenta\nd- Diffindo",
                    "\nWhat magical plant uses its vines to grab and strangle its prey\na-Venemous Tentacula\nb-Mandrake\nc-Bulbadox Powder\nd-Amortentia Potion" },

            { "\nWhat spell starts a fire?\na- Colloportus\nb- Descendo\nc- Episkey\nd- Incendio",
                    "\nWhat spell is used to defeat a Boggart?\na- Imperio\nb- Alarte Ascendare\nc- Waddiwasi\nd- Riddikulus",
                    "\nWhat spell can be used to create a bubble of silence around the caster?\na- Muffliato\nb- Expelliamis\nc- Stupefy\nd- Accio",
                    "\nWhat spell is used to shrink items?\na- Reducio\nb- Confundo\nc-Salvio Hexia\nd-Lumos",
                    "\nWhat item clouds the view of the opponent and causes them to accidently attack themselves?\na-Draught of Living Death\nb-Instant Darkness Powder\nc-Venemous Tentacula\nd-Exploding Potion"
            },

            { "\nWhat spell allows better sight during bad weather conditions when wearing glasses?\na- Expecto Patronum\nb- Impervius\nc- Protego\nd- Glisseo",
                    "\nWhat spell is used to hinder the movement of the target by slowing/stopping them?\na- Impediment\nb- Stupefy\nc- Protego\nd- Levicorpus",
                    "\nWhat spell is used to hoist the opponent into the air by their ankle? What is its counter spell?\na- Immobulus/Liberacorpus\nb- Fianto Duri/Reducio\nc- Levicorpus/Liberacorpus\nd- Diffindo/Levicorpus",
                    "\nWhat spell causes the victim to buckle with laughter?\na- Stupefy\nb- Rictusempra\nc- Levicorpus\nd- Impediment",
                    "\nWhat item causes the opponent to fall asleep?\na-Draught of Living Death\nb-Amortentia Potion\nc-Mandrake\nd-Bulbadox Powder"
            },
            { "\nWhat spell can be used to erase the opponent's memories?\na- Periculum\nb- Evanesco\nc- Obliviate\nd- Expelliamis",
                    "\nWhat spell deeply cuts the opponent and causes haemorrhaging?\na- Petrificus Totalus\nb- Sectumsempra\nc- Avada Kedavra\nd- Colloportus",
                    "\nWhat are the three forbidden spells?\na- Avada Kedavra, Crucio, Expecto Patronum\nb- Avada Kedavra, Imperio, Bombarda\nc- Crucio, Stupefy, Expelliamis\nd- Imperio, Crucio, Avada Kedavra",
                    "\nWhat spells are used to cast a protective barrier around an area?\na- Muffliato/ Salvio Hexio\nb- Protego/Stupefy\nc- Protego Totalum/Bombarda\nd- Salvio Hexia/Protego Totalum",
                    "\nWhat potion causes the opponent to get distracted and temporarily prevents them from casting a spell?\na-Instant Darkness Powder\nb-Exploding Potion\nc-Amortentia Potion\nd-Bulbadox Powder"
            } };
    private static Enemy enemy = new Enemy();
    private static Player player = new Player();
    private static int helps = 3;

    public Level() {
    }

    public static void attackStage() {
        System.out.println(
                "\n--------------------------------------------------------------------------------------------------------------------------------------------\n");
        enemy = new Enemy(level, player.getStrength());
        System.out.println(enemy);
        while (enemy.getHealth() > 0 && player.getHealth() > 0 && gameOn) {
            enemy.attack(player);
            if (player.getHealth() > 0 && gameOn) {
                player.attack(enemy);
            }
        }
        if (player.getHealth() <= 0) {
            lose(false, true);
        } else if (enemy.getHealth() <= 0) {
            win();
        }
    }

    public static void run(int l) {
        level = l;
        int numIncorrect = 0;
        if (level == 0) {
            System.out.println(
                    "\n=============================================================================================================================================\n");
            System.out.println(
                    "\nToday, you have embarked on your journey to become a powerful witch/wizard. There will be challenges ahead but if you work hard and persevere, you will succeed. Good luck!\n");
        }
        System.out.println(
                "If you get stuck, type \"help\" to see the Spells and Potions Guide again. You can only use this command three times throughout the game so use it wisely!");
        for (int q = 0; q < questions[level].length; q++) {
            String userAnswer = null;
            System.out.println(questions[level][q]);
            Scanner s1 = new Scanner(System.in);
            System.out.print("\nAnswer: ");
            userAnswer = s1.nextLine();
            while (!(userAnswer.matches("[A-Da-d]") && userAnswer.length() == 1)) {
                if (!userAnswer.equals("help")) {
                    System.out.println("\nInvalid input");
                } else {
                    if (helps > 0) {
                        System.out.println("\nSpells Guide\n" + "Lumos - used to cast a light\n"
                                + "Nox - used to extinguish a light"
                                + "Expelliamus - disarms the opponent\n" + "Stupefy - stuns the opponent\n"
                                + "Alahamora - used to unlock doors\n"
                                + "Wingardium Leviosa - used to levitate objects\n"
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
                                + "Reducio - shrinks objects\n"
                                + "Mufliato- creates a bubble of silence around the user\n"
                                + "Obliviate - erases the victim's memories\n"
                                + "Sectumsempra - deeply cuts opponent and causes haemorrhaging\n"
                                + "Riddikulus - used to defeat Boggart\n"
                                + "Unforgivable curses - Avada Kedavra(kills opponent), Crucio(tortures opponent), Imperius(controls opponent against their will)\n"
                                + "\nPotions Guide\n"
                                + "Bulbadox Powder - causes the victim's skin to break out in boils\n"
                                + "Mandrake- when matured, this magical plant's cry can be fatal to any person who hears it\n"
                                + "Exploding Potion - causes an explosion when released from the bottle and harms anything in its vicinity\n"
                                + "Venemous Tentacula - a magical plant with vines that tries to grab and strangle its prey\n"
                                + "Instant Darkness Powder - clouds the view of the opponent and causes them to accidentally attack themselves\n"
                                + "Draught of Living Death - causes the opponent to fall asleep\n"
                                + "Amortentia Potion - distracts the opponent and temporarily prevents them from casting a spell\n");
                        System.out.println(questions[level][q]);
                        helps -= 1;
                    } else {
                        System.out.println(
                                "You have already used the \"help\" option three times. Try your best and make a guess.");
                    }
                }
                s1 = new Scanner(System.in);
                System.out.print("\nAnswer: ");
                userAnswer = s1.nextLine();
            }

            if (userAnswer.equals(answers[level][q])) {
                player.setKnowledge(player.getKnowledge() + 15);
                System.out.println("\nCorrect!");
            } else {
                System.out.println("\nIncorrect. The correct answer is " + answers[level][q]);
                numIncorrect += 1;
            }
        }
        if (numIncorrect > 2) {
            System.out.println("\nYou got too many questions wrong!");
            lose(true, false);

        } else {
            attackStage();
        }

    }

    public static void lose(boolean failedQuiz, boolean lostBattle) {
        System.out.println(
                "\n=============================================================================================================================================\n");

        System.out.println("\nUnfortunately, you did not pass the level. Please try again.\n");
        player.setHealth(100);
        System.out.println("Level: " + (level + 1));
        player.setTries(player.getTries() - 1);
        player.setItemsInUse(player.getCurrentItems());
        player.resetTries();
        player.setHealUsed(false);
        player.showStats();
        if (player.getTries() >= 0 && gameOn) {
            if (failedQuiz) {
                run(level);
            } else if (lostBattle) {
                attackStage();
            }
        } else {
            gameOn = false;
            gameOver();
        }
    }

    public static void win() {
        level += 1;
        if (level == 7) {
            gameOn = false;
            gameOver();
        } else {
            System.out.println(
                    "\n=============================================================================================================================================\n");
            System.out.println(
                    "\nCongratulations, you cleared the level! You have completed another year in the wizarding world.\n");

            player.setStrength(player.getStrength() + 100 - (player.getTries() * 10));
            Random r1 = new Random();
            ArrayList<String> spells = player.getAvaliableSpells();
            int random = r1.nextInt(spells.size());
            String newSpell = spells.get(random);
            player.getSpells().add(newSpell);
            player.getAvaliableSpells().remove(newSpell);
            String[] items = player.getAvaliableItems();
            int j = 0;
            String newItem;
            if ((level + 1) < items.length) {
                newItem = items[level + 1];
            } else {
                newItem = items[j];
                j++;
            }
            for (int i = level; i < items.length - 1; i++) {
                items[i] = items[i + 1];
            }
            player.getCurrentItems().add(newItem);
            player.setItemsInUse(player.getCurrentItems());
            player.setHealUsed(false);
            System.out.println("You learned a new spell - " + newSpell);
            System.out.println("A new item was added to your inventory - " + newItem);
            player.setHealth(100);
            player.showStats();
            player.resetTries();
            enemy.setHealth(100);
            System.out.println("\nLevel: " + (level + 1));
            run(level);
        }
    }

    public static void gameOver() {
        System.out.println(
                "\n=============================================================================================================================================\n");
        if (player.getKnowledge() >= 150 && player.getStrength() >= 400 && player.getTries() >= 0) {
            System.out.println(
                    "\nYou acquired a sufficient amount of knowledge and strength to become a capable witch/wizard. Congratulations, you won! :)\n");
        } else if (player.getKnowledge() >= 150 && player.getStrength() < 400) {
            System.out.println(
                    "\nA good sorcerer needs a healthy balance of both magical and intellectual prowess. You are very wise and made the right decisions along the way but you do not have the strength"
                            + " needed to become a witch/wizard. You lose :(\n");
        } else if (player.getKnowledge() < 150 && player.getStrength() >= 400) {
            System.out.println(
                    "\nA good sorcerer needs a healthy balance of both magical and intellectual prowess. You are strong but not wise enough to be a witch/wizard since you did not answer "
                            + "enough of the questions correctly. You lose :(\n");
        } else if (player.getTries() <= 0) {
            System.out.println("You ran out of tries! You lose :(\n");
        } else {
            System.out.println(
                    "\nYou failed to acquire the necessary knowledge or strength required to be a true sorcerer. You knowledge points are based on how many questions you answered correctly"
                            + " and the strength points are based on how many tries you took to defeat your enemy. You lose :(\n");
        }

    }

    public static Player getPlayer() {
        return player;
    }

    public static Enemy getEnemy() {
        return enemy;
    }

    public static int getLevel() {
        return level;
    }

}