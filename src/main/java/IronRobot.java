
public class IronRobot extends AbstractRobot {

    private static final long HEALTH = 45;
    private static final int BASIC_DAMAGE = 11;
    private static final String MODEL_NAME = "Iron robot";

    public IronRobot(String name) {
        super(name,HEALTH,BASIC_DAMAGE);
    }

    @Override
    public String getStatus() {
        return MODEL_NAME + " " + getName() + ",  " + getHealth();
    }
}
