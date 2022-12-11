- Для запуска тестов должны быть установлены программы DBeaver Community, Node.js.

- Для запуска симулятора банковских сервисов, в gate-simulator выполнить npm install, потом npm start.
- Создайте подключение к СУБД PostgreSQL со следующими параметрами:
    - URL `jdbc:postgresql://localhost:5432/postgres`
    - пользователь `postgres`
    - пароль `1`
- Для создания базы данных приложения выполните - create database aqa_shop.

- Запустите приложение - java -jar aqa-shop.jar на порту 8080.
- Запустите тесты - ShopTest.java - run.
