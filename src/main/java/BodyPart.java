
import java.util.Objects;

public final class BodyPart {
    final static BodyPart ARM = new BodyPart("рука", new Range(1, 20), 1);
    final static BodyPart LEG = new BodyPart("нога", new Range(21, 40), 1);
    final static BodyPart CHEST = new BodyPart("грудь", new Range(41, 70), 0.9);
    final static BodyPart HEAD = new BodyPart("голова", new Range(71, 80), 1.5);
    final static BodyPart EYE = new BodyPart("глаз", new Range(81, 85), 2);

    final static BodyPart EMPTY = new BodyPart("мимо", new Range(86, 100), 0);

    private final String bodyPart;
    private final Range range;
    private final double damageCoefficient;

    private BodyPart(String bodyPart, Range range, double damageCoefficient) {
        this.bodyPart = bodyPart;
        this.range = range;
        this.damageCoefficient = damageCoefficient;
    }

    private static class Range{
        private final int low;
        private final int high;

        public Range(int low, int high) {
            this.low = low;
            this.high = high;
        }

    }

    public boolean isHit(int value){
        return value >= this.range.low && value <= this.range.high ;
    }

    public double getDamageCoefficient(){
        return damageCoefficient;
    }

    @Override
    public String toString() {
        return this.bodyPart;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject){
            return true;
        }

        if (otherObject == null || this.getClass() != otherObject.getClass()){
            return false;
        }

        BodyPart otherBodyPart = (BodyPart) otherObject;

        return Objects.equals(bodyPart,otherBodyPart.bodyPart);
    }

    @Override
    public int hashCode() {
        return bodyPart.hashCode();
    }
}
