package ru.hogoshi;

import ru.hogoshi.util.Easing;
import ru.hogoshi.util.Easings;

/**
 * Main class
 */
public class Animation {

    /**
     * System.currentTimeMillis() from last animation start
     */
    private long start;
    /**
     * Last/Current animate method duration
     */
    private double duration;
    /**
     * Value from which animation is started
     */
    private double fromValue;
    /**
     * Value to which animation goes
     */
    private double toValue;
    /**
     * Returns current animation value (better usage: getValue())
     */
    private double value;

    /**
     * Animation type
     */
    private Easing easing = Easings.NONE;

    /**
     * Main method, use to animate value to something.
     * @param valueTo toValue, value to which animation will go
     * @param duration duration, with which animation will animate
     */
    public boolean animate(double valueTo, double duration) {
        return animate(valueTo, duration, Easings.NONE, false);
    }

    /**
     * Main method, use to animate value to something.
     * @param valueTo toValue, value to which animation will go
     * @param duration duration, with which animation will animate
     * @param safe means will it update when animation isAlive or with the same targetValue
     */
    public boolean animate(double valueTo, double duration, boolean safe) {
        return animate(valueTo, duration, Easings.NONE, safe);
    }

    /**
     * Main method, use to animate value to something
     * @param valueTo toValue, value to which animation will go
     * @param duration duration, with which animation will animate
     * @param easing animation type, like formula for animation
     * @param safe means will it update when animation isAlive or with the same targetValue
     * @return returns method performed
     */
    public boolean animate(double valueTo, double duration, Easing easing, boolean safe) {
        if(safe && (valueTo == getFromValue() || valueTo == getValue())) return false;

        setToValue(value);
        setFromValue(getValue());
        setStart(System.currentTimeMillis());
        setDuration(duration * 1000);
        setEasing(easing);

        return true;
    }

    /**
     * Important method, use to update value. WARNING: IF U WILL NOT UPDATE, ANIMATION WILL NOT WORKS
     * @return returns if animation isAlive()
     */
    public boolean update() {
        double part = calculatePart();
        double foundVal;
        if(isAlive()) {
            part = this.easing.ease(part);
            foundVal = interpolate(getFromValue(), getToValue(), part);
        } else {
            setStart(0);
            foundVal = getToValue();
        }
        setValue(foundVal);
        return isAlive();
    }

    /**
     * Use if u want check if animation is animating
     * @return returns if animation is animating
     */
    public boolean isAlive() {
        return !isDone();
    }

    /**
     * Use if u want check if animation is not animating
     * @return returns if animation is animating
     */
    public boolean isDone() {
        return calculatePart() >= 1.0;
    }

    /**
     * Use if u want to get the current part of animation (from 0.0 to 1.0, like 0% and 100%)
     * @return returns animation part
     */
    public double calculatePart() {
        return (double) (System.currentTimeMillis() - getStart()) / getDuration();
    }

    /**
     * Basic interpolation formula
     */
    public double interpolate(double start, double end, double pct) {
        return start + (end - start) * pct;
    }

    /**
     * Basic back interpolation formula (idk why its here, why not?)
     */
    public double normalize(double start, double end, double value) {
        return (end - start) / (value - start);
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getFromValue() {
        return fromValue;
    }

    public void setFromValue(double fromValue) {
        this.fromValue = fromValue;
    }

    public double getToValue() {
        return toValue;
    }

    public void setToValue(double toValue) {
        this.toValue = toValue;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Easing getEasing() {
        return easing;
    }

    public void setEasing(Easing easing) {
        this.easing = easing;
    }
}