������� �� ����� "���������� ��� ������� �� Java" �� https://stepic.org/. 
https://stepik.org/course/186/info (����� 2).

������:
�������� � ������ ����� resources.TestResource

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

�������� ResourceServer, ������� ����� ��������� ������ �� TestResource.
������� ResourceServer � JMX � ������:
Admin:type=ResourceServerController
������� ���������� "name" � "age" ���������� ��� ������ �� jmx �������.

�������� �������, ������� ����� ������������ ������� �� /resources
��� ��������� POST ������� � ���������� path=path_to_resource
��������� ������ TestResource �� ���������� � ��������� ����� � �������� ������ � ResourceService

����� ������, �������� name � age ������ ���� �������� �� JMX.