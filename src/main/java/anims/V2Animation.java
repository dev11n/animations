package anims;

public class V2Animation {

    private final Animation xPos = new Animation();
    private final Animation yPos = new Animation();

    public void animate(V2 V2, double duration, boolean safe) {
        animate(V2, duration, Easings.NONE, safe);
    }

    public void animate(V2 V2, double duration, Easing easing) {
        animate(V2, duration, easing, false);
    }

    public void animate(V2 V2, double duration, Easing easing, boolean safe) {
        xPos.animate(V2.getX(), duration, easing, safe);
        yPos.animate(V2.getY(), duration, easing, safe);
    }

    public void update() {
        xPos.update();
        yPos.update();
    }

    public Animation getXPos() {
        return xPos;
    }

    public Animation getYPos() {
        return yPos;
    }

    public boolean isAlive() {
        return getXPos().isAlive() && getYPos().isAlive();
    }
    
    public V2 getValue() {
        return new V2(xPos.getValue(), yPos.getValue());
    }
}
