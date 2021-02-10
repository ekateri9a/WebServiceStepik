«адани€ по курсу "–азработка веб сервиса на Java" на https://stepic.org/. 
https://stepik.org/course/146/info (часть 1).
https://stepik.org/course/186/info (часть 2).

«адача:
„асть перва€ (аналогично заданию 2)
Ќаписать сервер с двум€ сервлетами:
SignUpServlet дл€ обработки запросов на signup и
SignInServlet дл€ обработки запросов на signin

—ервлеты должны слушать POST запросы с параметрами
login
password

ѕри получении POST запроса на signup сервлет SignUpServlet должн запомнить логин и пароль в AccountService.
ѕосле этого польователь с таким логином считаетс€ зарегистрированным.
ѕри получении POST запроса на signin, после регистрации, SignInServlet провер€ет,
логин/пароль пользовател€. ≈сли пользователь уже зарегистрирован, север отвечает

Status code (200)
и текст страницы:
Authorized: login

если нет:
Status code (401)
текст страницы:
Unauthorized

„асть втора€ (работа с базой)
ƒл€ запоминани€ пользовател€ AccountService должен использовать базу данных.
ƒл€ теста используйте базу H2 над файлом в той же директории, что и src

            String url = "jdbc:h2:./h2db";
            String name = "test";
            String pass = "test";

            JdbcDataSource ds = new JdbcDataSource();
            ds.setURL(url);
            ds.setUser(name);
            ds.setPassword(pass);

ƒл€ хранени€ данных пользовател€ используйте таблицу users:
create table if not exists users (id bigint auto_increment, login varchar(256), password varchar(256), primary key (id));
—ервер должен создавать таблицу при старте если она не существует.

ѕри получении запроса на signup сервлет должен обратитьс€ к DBService и записать логин и пароль в таблицу.

“естирующа€ система:
1. запускает сервер
2. присылает на сервер запрос на регистрацию (signup)
3. перезапускает сервер
4. присылает запрос на авторизацию (signin)