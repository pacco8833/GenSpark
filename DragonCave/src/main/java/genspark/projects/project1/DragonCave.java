package genspark.projects.project1;

public final class DragonCave {

    private final User you;

    DragonCave() {
        you = new User();
    }

    public void start() {
        intro();
        chooseCave();
        continueChooser();
    }
    
    public void end() {
        you.endInput();
    }

    /* get user's name */
    private void intro() {
        System.out.println(DragonText.getIntro());
        System.out.println("What is your name, adventurer?");

        try {
            you.setName();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            you.setName("Adventurer");
        } finally {
            System.out.println();
        }
    }

    private void chooseCave() {
        System.out.printf("Your move, %s%n%n", you.getName());
        System.out.println("Type and enter '1' to choose cave 1");
        System.out.println("Type and enter '2' to choose cave 2");

        int input = you.getInput();
        String result = caveDecision(input);
        System.out.println(result);
    }

    /* chooses what will happen after choosing a cave */
    public String caveDecision(int input) {
        System.out.println();
        switch (input) {
            case 1 -> {
                return DragonText.wrongCave;
            }
            case 2 -> {
                return DragonText.rightCave;
            }
            default->{
                // the user entered some other number, run the initial msg again.
                System.out.println("Cave '" + input + "' does not exist!");
                chooseCave();
            }
        }
        return "";
    }

    private void continueChooser() {
        System.out.printf("Your move, %s%n", you.getName());
        System.out.println("Do You continue?" + " Type and enter '1'");
        System.out.println("Do You turn back?" + " Type and enter '2'");

        int input = you.getInput();
        String result = lifeDecision(input);
        System.out.println(result);
    }

    /* chooses what will happen after continue */
    public String lifeDecision(int input) {
        switch (input) {
            case 1 -> {
                return DragonText.getDeath();
            }
            case 2 -> {
                return DragonText.survive;
            }
            default-> {
                // the user entered some other number, run the initial msg again.
                System.out.println("Choice '" + input + "' does not exist!");
                continueChooser();
            }
        }
        return "";
    }
}