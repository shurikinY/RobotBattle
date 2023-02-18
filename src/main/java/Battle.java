
public class Battle {

    private static int ROUND_COUNT = 0;
    private final AbstractRobot firstRobot;
    private final AbstractRobot secondRobot;

    private AbstractRobot firstRobotMove;
    private AbstractRobot secondRobotMove;

    public Battle(AbstractRobot firstRobot, AbstractRobot secondRobot) {
        this.firstRobot = firstRobot;
        this.secondRobot = secondRobot;
        firstRobotMove = firstRobot;
        secondRobotMove = secondRobot;
    }

    public void start() {
        determineWhoGoesFirst();
        while (firstRobotMove.getHealth() > 0 && secondRobotMove.getHealth() > 0) {
            doMove(firstRobotMove, secondRobotMove);
            System.out.println(firstRobotMove.getStatus() + " - " + secondRobotMove.getStatus());
            if (secondRobotMove.getHealth() > 0) {
                doMove(secondRobotMove, firstRobotMove);
                System.out.println(firstRobotMove.getStatus() + " - " + secondRobotMove.getStatus());
            }
        }
    }

    private void determineWhoGoesFirst() {
        int number = RandomNumbers.getRandomNumber(1, 2);
        AbstractRobot robot;
        if (number == 2) {
            robot = firstRobotMove;
            firstRobotMove = secondRobotMove;
            secondRobotMove = robot;
        }
    }

    private void doMove(AbstractRobot firstRobot, AbstractRobot secondRobot) {
        BodyPart attacked = firstRobot.attack();
        BodyPart defended = secondRobot.defense();
        System.out.printf("%s атаковал робота %s, атакована %s, защищена %s\n",
                firstRobot.getName(), secondRobot.getName(), attacked, defended);
        ROUND_COUNT++;
    }

    public void printResult() {
        System.out.println("\nBattle result:");
        System.out.println("Round quantity: " + ROUND_COUNT);
        System.out.println(firstRobot.getStatus());
        System.out.println(secondRobot.getStatus());
        System.out.println();
    }
}
