<h1 align="center">Java Animations</h1>
<h3 align="center">Тута будет 2 языка - русский и английский.</h3>
<h3 align="center">There will be 2 langs - russian and english.</h3>

# RU
И так, довольно мало в сети есть "помощников" для создания анимаций. Я сам довольно долго искал, и нашел, и немножечко проникся идеей помочь людям и закрыть вопрос с анимациями раз и навсегда.
Логика анимаций была взята отсюда: https://github.com/delfikpro/cristalix-client-sdk/blob/stable/ui-engine/src/main/kotlin/ru/cristalix/uiengine/eventloop/Animation.kt

Перейдем к сути.

### Как мне использовать это?
Для начала, вам нужно импортировать проекта как библиотеку, если вы используете градле или мавен, если нет - просто скачайте и закиньте в сурсы вашего проекта.
Если же вы используете мавен или градле, то вот небольшой кусок для того, что бы закинуть как библиотеку.
## Gradle
```gradle
repositories {
	maven { url 'https://jitpack.io' }
}
dependencies {
	implementation 'com.github.xHogoshi:Animations:2.0.1'
}
```
## Maven
```xml
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>

<dependency>
    <groupId>com.github.xHogoshi</groupId>
    <artifactId>Animations</artifactId>
    <version>2.0</version>
</dependency>
```

### Создание
Далее, вам требуется создать поле с нужной вам анимацией. На данный момент имеются разные костыли для этого:

• Animation - Обычная анимация 
```java
private Animation linearAnimation = new Animation();
```

• V2Animation - Анимация какой-то позиции. Пример: V2(x, y)
```java
private V2Animation V2Animation = new V2Animation();
```

• ColorAnimation - Анимация цвета. Пример: Color(red, green, blue, alpha)
```java
private ColorAnimation colorAnimation = new ColorAnimation();
```

• QuadAnimation - Анимация, имеющая две V2Animation, в основном для анимации каких-либо примитивов (Прямоугольника, квадрата)
```java
private QuadAnimation rectAnimation = new QuadAnimation();
```

### Использование
После создания поля вам требуется анимацию в каком-то цикличном методе ее апдейтить (обновлять). Это сделано в связи с тем, что в анимациях используются изинги, но об этом чуть позже.

#### Апдейт Анимации

```java
animation.update();
```

#### Анимация

Далее, разумеется, вам нужно ее как-то анимировать. Теперь тут все зависит строго от типа вашей анимации. Да-да, именно о которых мы говорили выше.
Попрошу заметить, что длительность указывать нужно в секундах. К примеру, вместо 500 миллисекунд вам прийдется указать 0.5 или .5
Под safe подразумевается то, будет ли анимация анимироваться если она уже анимируется на данный момент. (Сделано для того, что бы анимация не лагала, если вы вызываете animate где-то по 5000 раз в секунду). Если вам не нужно оно, можете использовать false, либо же не указывать как аргумент.
Под easing подразумевается то, какой будет анимация. Подсмотреть изинг вы можете тут: https://easings.net/

• Animation
```java
animation.animate(значение, длительность, Easing, safe);
```

• V2Animation
```java
animation.animate(new V2(x, y), длительность, Easing, safe);
```

• ColorAnimation
```java
animation.animate(new Color(red, green, blue), длительность, safe); // Изинги у цвета не поддерживаются по той причине, что некоторые могут выйти за 255, что приведет к ошибке.
```

• QuadAnimation
```java
animation.animate(new V2(x, y), new V2(x, y), длительность, Easing, safe);
```

### Получение информации из анимации

#### Получение текущего значения анимации
Animation, V2Animation
```java
animation.getValue()
```
QuadAnimation
```java
animation.getValue1() // возращает в2 с первой позицией
animation.getValue2() // возращает в2 с второй позоцией
```
ColorAnimation
```java
animation.getColor()
```

#### Установка текущего значения (Без анимации)
```java
animation.setValue(значение);
```

#### Получение значения, к которому анимация стремится
```java
animation.getTarget()
```

## спасибо за прочтение, надеюсь я не зря это писал, мдям.

# EN
So, there are quite a few "assistants" in the network for animations. Coz of that i searched for quite a long time myself, and found something. Got a little imbued with the idea of helping people and closing the issue with animations once and for all.
Anims logic from here: https://github.com/delfikpro/cristalix-client-sdk/blob/stable/ui-engine/src/main/kotlin/ru/cristalix/uiengine/eventloop/Animation.kt

Let's get to the point.

### How to use that?
For start, if u are using gradle or maven u need import this project as library, otherwise - just download it and move to your src folder.
If you are using maven or gradle, then, here's a small peace to use this project as library.
## Gradle
```gradle
repositories {
	maven { url 'https://jitpack.io' }
}
dependencies {
	implementation 'com.github.xHogoshi:Animations:2.0.1'
}
```
## Maven
```xml
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>

<dependency>
    <groupId>com.github.xHogoshi</groupId>
    <artifactId>Animations</artifactId>
    <version>2.0</version>
</dependency>
```

### Creating
Next, u need to create a field with the animation u need. At this moment there are different crutches for this:

• Animation - Linear Animation
```java
private Animation linearAnimation = new Animation();
```

• V2Animation - Position animation. Example: V2(x, y)
```java
private V2Animation V2Animation = new V2Animation();
```

• ColorAnimation - Color animation. Example: Color(red, green, blue, alpha)
```java
private ColorAnimation colorAnimation = new ColorAnimation();
```

• QuadAnimation - Animation, which contains two V2Animations, mainly u will need this only for primitive figures (Quad, Rectangle)
```java
private QuadAnimation rectAnimation = new QuadAnimation();
```

### Usage
After creating the field, u need to update the animation in some cyclic method. This is done due to the fact that easings is using in these animations, but more on that later.

#### Animation Update

```java
animation.update();
```

#### Animate

Next, of course, u need to animate it somehow. Now evrthing depends strictly on the type of ur animation. Ye-ye, exactly what we talked bout above.
Please note that the duration should be specified in seconds. For example: Instead of 500 millis, u will have to specify 0.5 or .5.
"Safe" means whether the animation will be animated if it is already being animated at the moment. (This is done so that the animation does not lag if you call animate somewhere 5000 times per second). If u dont need it, u can use false, or just dont specify it as an arg.
All easings u can find at https://easings.net/ , just use Easings.EASING. For example: Easings.NONE if u need just animation.

• Animation
```java
animation.animate(value, duration, Easing, safe);
```

• V2Animation
```java
animation.animate(new V2(x, y), duration, Easing, safe);
```

• ColorAnimation
```java
animation.animate(new Color(red, green, blue), duration, safe); // The easings are not supported for colorAnimation coz some animations can be higher that 255, and that will throw exception. 
```

• QuadAnimation
```java
animation.animate(/*firstPos */ new V2(x, y), /*secondPos */new V2(x, y), duration, Easing, safe);
```

### Getting info bout Animation

#### Getting current value
Animation, V2Animation
```java
animation.getValue()
```
QuadAnimation
```java
animation.getValue1() // Returns V2 with firstPos
animation.getValue2() // Returns V2 with secondPos
```
ColorAnimation
```java
animation.getColor()
```

#### Setting current value (without any animation)
```java
animation.setValue(value);
```

#### Getting value, which returns animation's target value
```java
animation.getTarget()
```

## tysm for reading this, im literally hope that u enjoyed this and I didn't waste any time translating this into English.
