package anims;

/*

               (CRINGE)
          Writed in 01.12.21.

      I can say big thanks for:
             ~ DelfikPro

    It's basically rewrited by me.

    Basically i did it for me, but yeee!

*/

public class DAnimation {

    private long animationStart;
    private long animationEnd;
    private double animationFromValue;
    private double animationToValue;

    public double getValue() {
        double path = (double) (System.currentTimeMillis() - animationStart) / (animationEnd - animationStart);
        if (path >= 1.0) {
            return animationToValue;
        } else {
            double value = (animationToValue - animationFromValue) * path + animationFromValue;
            return value;
        }
    }

    public void setValue(int value) {
        animationFromValue = value;
        animationToValue = value;
    }

    public void animate(double duration, double valueTo) {
        double path = (double) (System.currentTimeMillis() - animationStart) / (animationEnd - animationStart);
        animationStart = System.currentTimeMillis();
        animationEnd = (long) (System.currentTimeMillis() + duration);
        if(!(path >= 1)) {
            animationFromValue = (animationToValue - animationFromValue) * path + animationFromValue;
        } else {
            animationFromValue = animationToValue;
        }
        animationToValue = valueTo;
    }

    public boolean isDone() {
        double path = (double) (System.currentTimeMillis() - animationStart) / (animationEnd - animationStart);
        return path >= 1.0;
    }

    public boolean isAlive() {
        double path = (double) (System.currentTimeMillis() - animationStart) / (animationEnd - animationStart);
        return path < 1.0;
    }

}