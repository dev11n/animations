package anims;

public class Animation {

    private long animationStart;
    private double duration;
    private double animationFromValue;
    private double animationToValue;
    private double lastValue;

    private Easing easing = Easings.NONE;

    public void animate(double value, double duration, boolean safe) {
        animate(value, duration, Easings.NONE, safe);
    }

    public void animate(double value, double duration, Easing easing) {
        animate(value, duration, easing, false);
    }

    public void animate(double value, double duration, Easing easing, boolean safe) {
        if(safe && isAlive()) return;

        setValue(getValue());
        setAnimationToValue(value);
        setAnimationStart(System.currentTimeMillis());
        setDuration(duration * 1000);
        setEasing(easing);
    }

    public boolean update() {
        double part = (double) (System.currentTimeMillis() - animationStart) / duration;
        double value;
        if(isAlive()) {
            part = this.easing.ease(part);
            value = animationFromValue + (animationToValue - animationFromValue) * part;
        } else {
            this.animationStart = 0;
            value = this.animationToValue;
        }
        this.lastValue = value;
        return isAlive();
    }

    public boolean isDone() {
        return !isAlive();
    }

    public boolean isAlive() {
        double part = (double) (System.currentTimeMillis() - animationStart) / duration;
        return part < 1.0;
    }

    public double getAnimationFromValue() {
        return animationFromValue;
    }

    public double getAnimationToValue() {
        return animationToValue;
    }

    public double getTarget() {
        return getAnimationToValue();
    }

    public double getDuration() {
        return duration;
    }

    public Easing getEasing() {
        return easing;
    }

    public long getAnimationStart() {
        return animationStart;
    }

    public double getValue() {
        return this.lastValue;
    }

    public void setAnimationFromValue(double animationFromValue) {
        this.animationFromValue = animationFromValue;
    }

    public void setAnimationToValue(double animationToValue) {
        this.animationToValue = animationToValue;
    }

    public void setValue(double value) {
        setAnimationFromValue(value);
        setAnimationToValue(value);
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setAnimationStart(long animationStart) {
        this.animationStart = animationStart;
    }

    public void setEasing(Easing easing) {
        this.easing = easing;
    }
}
