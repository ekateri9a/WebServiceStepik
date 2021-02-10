«адани€ по курсу "–азработка веб сервиса на Java" на https://stepic.org/. 
https://stepik.org/course/186/info (часть 2).

«адача:
ƒобавить в сервер класс resources.TestResource

public class TestResource {
    private String name;
    private int age;

    public TestResource(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public TestResource() {
        this.name = "";
        this.age = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

Ќаписать ResourceServer, который будет содержать ссылку на TestResource.
¬ывести ResourceServer в JMX с именем:
Admin:type=ResourceServerController
—делать переменные "name" и "age" доступными дл€ чтени€ из jmx клиента.

Ќаписать сервлет, который будет обрабатывать запросы на /resources
ѕри получении POST запроса с параметром path=path_to_resource
прочитает ресурс TestResource из указанного в параметре файла и сохранит ссылку в ResourceService

ѕосле чтени€, значени€ name и age должны быть доступны по JMX.