
<h1></h1>
<h1 align="center">Анимашки на джаве (RUS)</h1>
<h3></h3>
80% кода взято отсюда: https://github.com/delfikpro/cristalix-client-sdk/blob/stable/ui-engine/src/main/kotlin/ru/cristalix/uiengine/eventloop/Animation.kt (Говорю про основной класс - Animation.class)
Я лишь переписал это на жаве, убрал зависимость анимашки от позиции элемента и немношко улучшил. к сожалению, далеко не каждый человек может найти это, да и вцелом анимашки, поэтому я решил создать репо по этому поводу.

## Что это?
Это - помощник для ваших анимашек, ваша мечта. На данный момент я не особо на них зациклен, поэтому делайте выводы сами, и тут могут быть проблемы.

## Что же я смогу сделать с этим?
Вы сможете использовать стандартные анимашки которые предоставляет сам ютил:
#### • NONE (Линейная);
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
## Вы так-же можете добавить ваши анимашки, уникальные или улучшить что-то, но мне хватало всегда этих. Что бы понять как каждая из вышеперечисленных выглядит, я закреплю этот сайтик тут https://easings.net/

## Как-же все таки это использовать?
Для начала, вам нужно собстенно закинуть в ваш проект этот весь ютил, используя грабли, мавен, ну или просто скачайте и закиньте :)
### Импорт для граблей
```gradle
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}

dependencies {
	implementation 'com.github.xHogoshi:Animations:2.0'
}
```

### Импорт для мавена
```maven
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

### После того, как вы закинули анимашки в свой проект вам нужно создать поле с самой анимацией. Их несколько:
#### • Анимация цвета (ColorAnimation.class) - С ней вы очень легко можете анимировать цвет. (Изинги не поддерживаются в связи тем, что если ваше значение больше 255 в java.awt.Color'e вы словите краш.
#### • Анимация позиции (V2Animation.class) - С этой анимашкой вы сможете анимировать 2 оси - x и y.
#### • Анимация квадрата (QuadAnimation.class) - С этой анимашкой вы сможете использовать 2 анимации позиции - pos1 и pos2. Что бы не создавать по 20 полей с V2 анимацией я решил сделать это.
#### • Обычная анимация (Animation.class) - Э ну просто анимация.
И так, вернемся. Вам нужно создать поле: (Если вы используете другие анимашки, просто смените поле на анимашку вашей задачи, к примеру Animation меняете на ColorAnimation)
```java
Animation yourAnimation = new Animation();
```

### После, вам нужно апдейтить эту анимацию. В связи с тем, что данные анимации используют изинги, вам прийдется вместе с рендером вашего элемента апдейтить анимашку, ну ничего страшного :>
Пример:
```java
yourAnimation.update();
```

### Далее, когда вы убедились, что вы апдейтите анимашку, вам нужно ее анимировать (разумеется, за этим вы сюда и пришли)
### Примечание: аргумент safe отвечает за то, что ваша анимашка не будет лагать если вы будете вызывать animate без каких-либо проверок типа if(animation.isDone()), тоесть если анимашка завершилась.
### Ещё одно примечание: duration измеряется в секундах, да, раньше в милисекундах, но я так подумал, что вам мешает юзать к примеру вместо 500 (в милисекундах) 0.5? кароче так проще...
Пример:
```java
// Если ваша анимация - обычная
yourAnimation.animate(value, duration, easing, safe);
// Если ваша анимация - цвет
yourAnimation.animate(new Color(red, green, blue, alpha), duration, safe);
// Если ваша анимация - позиция
yourAnimation.animate(new V2(x, y), duration, easing, safe);
// Если ваша анимация - квад / quadAnimation
yourAnimation.animate(new V2(x1, y1), new V2(x2, y2), duration, easing, safe);
```

### Всё готово! Но, надо же как то получать какую-то информацию из анимации? Как же?
#### Получение значения анимации:
```java
yourAnimation.getValue()
```
#### Как установить значение анимашке без анимации (я гений да)?
```java
yourAnimation.setValue(value);
```
#### Как я могу проверить, завершилась или анимируется анимашка?
```java
yourAnimation.isDone() // Проверяет если завершена
yourAnimation.isAlive() // Проверяет если живая
```
#### Как я могу получить значение, к которому анимашка стремится?
```java
yourAnimation.getTarget()
```

<h1></h1>

### На данный момент тут нету каких-либо алгоритмов безье, но если вы 8y.o. talent то закиньте мне в дс реализацию(мнелень), могу запушить. (Hogoshi#1706)

### Я считаю, что эти анимашки - самые лучшие в своем роде. С ними очень легко работать, а сделать новую анимашку - делать нечего.
### Примечание: На данный момент я не проверял все ли до единой проверочки работает, я боюсь, что я где-то поднасрал, и если так есть - Hogoshi#1706

<h1 align="center">Спасибо за прочтение.</h1>
<h1 align="center">If u not from ru, use translator, sry, im too lazy to translate this.</h1>
