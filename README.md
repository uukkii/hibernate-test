## Домашнее задание к занятию 8.4: ORM, Hibernate
### Задача DAO слой c Hibernate

**v. 1.0**

Задание реализовано.

К проекту подключены необходимые зависимости: `spring-boot-starter-data-jpa`,
`spring-boot-starter-web`, а также драйвер `mysql-connector-java` и зависимость `lombok`.

Приложение имеет следующую структуру:

- Класс **HibernateApiApplication.java** является точной входа в программу;
- Класс *Person.java** пакета `ru.netology.hibernatetest.entity` представляет собой сериализированную сущность таблицы.
  В качестве **primary keys** используются три поля: _**name**_, _**surname**_ и _**age**_.
  Также там указаны аннотации:

```
  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @Table(name = "persons")
```

- Класс **Service.java** пакета `ru.netology.hibernatetest.service` содержит в себе
  аннотацию сервиса приложения и метод получения всех лиц, проживающих в определенном городе
  _getPersonsByCity(String city)_ класса **Repository**;
- Класс **Controller.java** пакета `ru.netology.hibernatetest.controller` содержит
  в себе аннотацию контроллера, Get-маппинг по адресу `/persons/by-city` с телом ответа,
  получающего параметр _**city**_ _(поле city_of_living таблицы persons)_ через метод класса **Service** _
  getPersonsByCity(String city)_
- Класс **Repository.java** пакета `ru.netology.hibernatetest.repository` содержит
  аннотацию репозитория, метод _getPersonsByCity(String city)_ для получения списка лиц, проживающих в определенном
  городе.
  Данный метод, используя _EntityManager_, создает SQL-запрос `select p from Person p where p.city_of_living = :city`.
  В качестве параметра _**city**_ передается переданное в метод значение. Возвращается список после фильтрации.

- В `/src/main/resources` также находится файл настроек Spring с указанными параметрами запуска:

```
  spring.datasource.url=jdbc:mysql://localhost:3306/mysql
  spring.datasource.username=root
  spring.datasource.password=mysql
  spring.sql.init.continue-on-error=true

  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
```
