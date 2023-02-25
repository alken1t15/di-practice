package car;

/*

Задача "Автомобиль" (самый начальный уровень)

Что будете использовать:
- интерфейс
- класс-реализация интерфейса
- создать объект на основе класса и вызвать необходимые методы
- оператор System.out.println для вывода информации в консоль


#### Текст задачи:

Требуется создать, завести и остановить автомобиль.

Сущность Car:
    - свойство "name": название авто - String
    - метод "drive": ехать - выводит в консоль текст "drive"
    - метод "stop": остановиться - выводит в консоль текст "stop"

Под сущностью подразумевается важный смысловой объект, который участвует в задаче (интерфейс + класс-реализация, либо просто отдельный класс без интерфейса - но так не рекомендуется).

Какие конструкторы создавать в классе (пустые, с параметрами) - на ваше усмотрение.

Обязательно должен быть создан интерфейс для Car, чтобы код был более расширяемым и соответствовал принципам ООП (абстракция-реализация)

#### Запуск

В методе main создаем объект Car (который реализовывает соотв. интерфейс) и указываем название авто.

После этого вызываем 2 метода: drive и stop.

Каждый метод должен просто выводить информацию в консоль с помощью System.out.println.

Для запуска проекта - правой кнопкой на файле, где есть метод main, затем Run

Пример вывода в консоль после выполнения программы:
```
Tesla drive
Tesla stop
```


*/

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {

    public static void main(String[] args) {

        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        // главная разница в том, что car - это бин из DI контейнера, а не просто Java объект
        // не создаем Car вручную, за нас это делает DI контейнер
        // В этом проекте пока нет внедрения через @Inject, т.к. только один объект
        Car car = container.select(Car.class).get();
        car.setName("Tesla");

        car.drive();
        car.stop();
        
        container.shutdown();
    }


}