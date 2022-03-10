package anims;

public class QuadAnimation {

    private final V2Animation pos1 = new V2Animation();
    private final V2Animation pos2 = new V2Animation();

    public void animate(V2 V1, V2 V2, double duration, boolean safe) {
        animate(V1, V2, duration, Easings.NONE, safe);
    }

    public void animate(V2 V1, V2 V2, double duration) {
        animate(V1, V2, duration, Easings.NONE);
    }

    public void animate(V2 V1, V2 V2, double duration, Easing easing) {
        animate(V1, V2, duration, easing, false);
    }

    public void animate(V2 V1, V2 V2, double duration, Easing easing, boolean safe) {
        getPos1().animate(new V2(V1.getX(), V1.getY()), duration, easing, safe);
        getPos2().animate(new V2(V2.getX(), V2.getY()), duration, easing, safe);
    }

    public V2Animation getPos1() {
        return pos1;
    }

    public V2Animation getPos2() {
        return pos2;
    }

    public boolean isAlive() {
        return getPos1().isAlive() && getPos2().isAlive();
    }

    public void update() {
        getPos1().update();
        getPos2().update();
    }
    
    public V2 getValue1() {
        return getPos1().getValue();
    }
    
    public V2 getValue2() {
        return getPos2().getValue();
    }
    
}
