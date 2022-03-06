package genspark.projects.project1;

import java.util.Random;

final class DragonText {

    private static final Random rand = new Random();

    private static final String[] intros = {
            """

...You have entered a land full of dragons.
Many travellers have come to this land in search of the infamous dragons' treasure.
Will you be the adventurer to find the correct dragon's cave,
...or will you perish like many adventurers before you?
""",

            """

Welcome to Dragon Cave, Adventurer.
You've been called here to capture the infamous treasure of Scorch,the middle child of the three Elder Dragons.
Your mission is 'simply' to retrieve the treasure, not to kill the dragon.
In fact, contact with the Dragon altogether is discouraged, you likely would not survive."""};

    private static final String[] deaths = {
            """

Yeah, you died.
Nothing you did wrong, I mean sometimes the hero of the story dies.
You got eaten... It was gruesome. You did put up a fight though!
Let's be real though, it was a dragon; You didn't stand a chance.
I mean think about it, you just fought a dragon so, that's a cool death.
""",
            """

While retreating for the cave entrance, you're surrounded suddenly by dozens of tiny dragons.
As they begin to close in, one approaches you faster than the others, and immediately nips at your leg!
As you block your face to shield yourself from the attack,
the dragons see through your defense and aim for your legs...
your arms..
..and finally the rest of your body until you are diminished to fire-breathing bird food.
"""};

    static String

            wrongCave = """

            This is a creepy cave, man.
            It's real dark and Spooky.
            The chilling, rocky cave seems to be getting more and more narrow as you continue.
            As you descend further into the depths of the cave, it gets darker and darker.
            """,

    rightCave = """

            This is a sweet cave, man.
            As you enter the cave, the sunlight beams and splits beautifully through the rocks above.
            You find it extremely easy to navigate through the tunnels.
            Water streams from a small waterfall across the chasm.
            You can tell that others have been here, all obstacles are moved from your path.
            """,

    survive = """

            You decide to take a break and relax next to a completely not suspicious wall.
            As you lean your body weight on the wall, it slides back revealing a hidden room!
            You enter the room greeted figure who looks like Barney had a child with something from Dragon Tales.
            You slay the dragon anyway since that's what you planned to do...
            Finally, You collect your treasure and decide you need counselling.
            """;

    public static String getDeath() {
        int randomNum = rand.nextInt(2);
        return deaths[randomNum];
    }

    public static String getIntro() {
        int randomNum = rand.nextInt(2);
        return intros[randomNum];
    }
}