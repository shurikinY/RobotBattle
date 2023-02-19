
public class RobotBattle {
    public static void main(String[] args) {

        IronRobot goodRobot = new IronRobot("Bender");
        IronRobot badRobot = new IronRobot("Roberto");

        Battle battle = new Battle(goodRobot,badRobot);
        battle.start();
        battle.printResult();

        System.out.println("add new comment");
        System.out.println("add another comment");

    }
}
