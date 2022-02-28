
<h1></h1>
<h1 align="center">Java Animations</h1>
<h3></h3>

## What is this?
Animations is java util which can you help animate with some animation types.
<h1></h1>

## What i can do with it?
You can use some default animations which contains util, like:
#### • NONE (Linear Animation);
#### • Quad In, Quad Out, Quad InOut (Both);
#### • Elastic In, Elastic Out, Elastic InOut (Both);
#### • Expo In, Expo Out, Expo InOut (Both);
#### • Back In, Back Out, Back InOut (Both);
#### • Bounce In, Bounce Out, Bounce InOut (Both);
#### • Quart In, Quart Out, Quart InOut (Both);
#### • Circ In, Circ Out, Circ InOut (Both);
#### • Quint In, Quint Out, Quint InOut (Both);
#### • Cubic In, Cubic Out, Cubic InOut (Both);
#### • Sine In, Sine Out, Sine InOut (Both);
## Also you can add your animation types with math, but mainly it have all animations from https://easings.net/

## How to use it?
To start using you need import this repo as library or just download it and move to your src folder.
### Gradle Import (Probably now doesn't works)
## sry im too lazy, just download it :\

### Maven Import (Probably now doesn't works)
## sry im too lazy, just download it :\

### Next you need initialize animation as variable.
Example:
```java
Animation yourAnimation = new Animation();
```

### After that you need update animation in your render method. ( If you can't or don't need easings, just instead Animation use DAnimation and you don't need any update methods )
Example:
```java
yourAnimation.update();
```

### Next you need animate this animation with duration in millis. ( This method only gives animation target, not updating it!! )
Example:
```java
yourAnimation.animate(value, duration, easing);

// For Example real use
yourAnimation.animate(100, 1500, Easing.BACK_BOTH); // It will animate animation to 100 value and animating 1500 millis or 1,5 second with Back Both easing. All easings: https://easings.net/
```

### All ready!!! Now only little things.
#### How to get value from animation?
```java
yourAnimation.getValue()
```
#### How to set Value without animation?
```java
yourAnimation.setValue(value);
```
#### How to check if animation is animating or done?
```java
yourAnimation.isDone() // Checks if animation is done
yourAnimation.isAlive() // Checks if animation is alive
```

<h1></h1>

### For now it haven't any beazier algorithm for custom animations. It's only Math.

### I'm think this animations will help you. There about 30 animation types (Include Linear).

<h1></h1>
<h1 align="center">Thanks for reading.</h1>
