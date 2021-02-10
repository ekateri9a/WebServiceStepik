������� �� ����� "���������� ��� ������� �� Java" �� https://stepic.org/. 
https://stepik.org/course/146/info (����� 1).
https://stepik.org/course/186/info (����� 2).

������:
����� ������ (���������� ������� 2)
�������� ������ � ����� ����������:
SignUpServlet ��� ��������� �������� �� signup �
SignInServlet ��� ��������� �������� �� signin

�������� ������ ������� POST ������� � �����������
login
password

��� ��������� POST ������� �� signup ������� SignUpServlet ����� ��������� ����� � ������ � AccountService.
����� ����� ����������� � ����� ������� ��������� ������������������.
��� ��������� POST ������� �� signin, ����� �����������, SignInServlet ���������,
�����/������ ������������. ���� ������������ ��� ���������������, ����� ��������

Status code (200)
� ����� ��������:
Authorized: login

���� ���:
Status code (401)
����� ��������:
Unauthorized

����� ������ (������ � �����)
��� ����������� ������������ AccountService ������ ������������ ���� ������.
��� ����� ����������� ���� H2 ��� ������ � ��� �� ����������, ��� � src

            String url = "jdbc:h2:./h2db";
            String name = "test";
            String pass = "test";

            JdbcDataSource ds = new JdbcDataSource();
            ds.setURL(url);
            ds.setUser(name);
            ds.setPassword(pass);

��� �������� ������ ������������ ����������� ������� users:
create table if not exists users (id bigint auto_increment, login varchar(256), password varchar(256), primary key (id));
������ ������ ��������� ������� ��� ������ ���� ��� �� ����������.

��� ��������� ������� �� signup ������� ������ ���������� � DBService � �������� ����� � ������ � �������.

����������� �������:
1. ��������� ������
2. ��������� �� ������ ������ �� ����������� (signup)
3. ������������� ������
4. ��������� ������ �� ����������� (signin)