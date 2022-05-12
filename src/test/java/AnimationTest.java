import ru.hogoshi.Animation;
import ru.hogoshi.util.Easings;

public class AnimationTest {

    private static final Animation xPos = new Animation();

    public static void main(String[] args) {
        // Animate call
        xPos.animate(30.0, 0.5, Easings.QUINT_BOTH, false);
    }

    // Ur render method
    public static void render() {
        // Updating animation value
        xPos.update();

        // Example:
        // Gui.drawRect(xPos.getValue(), 20, xPos.getValue() + 100, 40, -1);
        // Will render animated rectangle with width 100 and animating position from 0 to 30 with 0.5 seconds duration
    }

}