Для запуска тестов необходимо осуществить:
1. Для сборки Docker образа симулятора банковских сервисов запустите скрипт `gate-simulator\build.cmd`
2. Для старта симулятора банковских сервисов запустите скрипт `docker-compose\gate-simulator\start.cmd`
3. Для старта СУБД PostgreSQL запустите скрипт `docker-compose\postgresql\start.cmd`, для старта СУБД MySQL
   запустите скрипт `docker-compose\mysql\start.cmd`
4. Для старта приложения с использованием СУБД PostgreSQL
  скопируйте файл `application-postgres.properties` в `application.properties` и
  запустите скрипт `start-app.cmd`.
     Для старта приложения с использованием СУБД MySQL
  скопируйте файл `application-mysql.properties` в `application.properties` и
  запустите скрипт `start-app.cmd`
5.Для старта UI-тестов запустите скрипт `start-test.cmd`