
public abstract class AbstractRobot implements Attackable, Defensable {

    private static BodyPart attackedBodyPart;
    private final String name;
    private long health;
    private final int base_damage;

    public AbstractRobot(String name, long health, int base_damage) {
        this.name = name;
        this.health = health;
        this.base_damage = base_damage;
    }

    public String getName() {
        return name;
    }

    public long getHealth() {
        return health;
    }

    public BodyPart attack() {
        int hitProbability = RandomNumbers.getRandomNumber(1, 100);

        if (BodyPart.ARM.isHit(hitProbability)) {
            attackedBodyPart = BodyPart.ARM;
        } else if (BodyPart.LEG.isHit(hitProbability)) {
            attackedBodyPart = BodyPart.LEG;
        } else if (BodyPart.CHEST.isHit(hitProbability)) {
            attackedBodyPart = BodyPart.CHEST;
        } else if (BodyPart.HEAD.isHit(hitProbability)) {
            attackedBodyPart = BodyPart.HEAD;
        } else if (BodyPart.EYE.isHit(hitProbability)) {
            attackedBodyPart = BodyPart.EYE;
        } else {
            attackedBodyPart = BodyPart.EMPTY;
        }
        return attackedBodyPart;
    }

    public BodyPart defense() {
        BodyPart defendedBodyPart;

        int defenseProbability = RandomNumbers.getRandomNumber(1, 100);
        if (BodyPart.ARM.isHit(defenseProbability)) {
            defendedBodyPart = BodyPart.ARM;
        } else if (BodyPart.LEG.isHit(defenseProbability)) {
            defendedBodyPart = BodyPart.LEG;
        } else if (BodyPart.CHEST.isHit(defenseProbability)) {
            defendedBodyPart = BodyPart.CHEST;
        } else if (BodyPart.HEAD.isHit(defenseProbability)) {
            defendedBodyPart = BodyPart.HEAD;
        } else if (BodyPart.EYE.isHit(defenseProbability)) {
            defendedBodyPart = BodyPart.EYE;
        } else {
            defendedBodyPart = BodyPart.EMPTY;
        }

        if (!attackedBodyPart.equals(defendedBodyPart)) {
            decreaseHealth();
        }

        attackedBodyPart = BodyPart.EMPTY;
        return defendedBodyPart;
    }

    private void decreaseHealth(){
        health = Math.max(health - Math.round(attackedBodyPart.getDamageCoefficient() * this.base_damage), 0);
    }

    public abstract String getStatus();
}
