План автоматизации тестирование - 

Для запуска тестов необходимо осуществить:

Для сборки Docker образа симулятора банковских сервисов запустите скрипт gate-simulator\build.cmd
Для старта симулятора банковских сервисов запустите скрипт docker-compose\gate-simulator\start.cmd
Для старта СУБД PostgreSQL запустите скрипт docker-compose\postgresql\start.cmd, для старта СУБД MySQL запустите скрипт docker-compose\mysql\start.cmd
Для старта приложения с использованием СУБД PostgreSQL скопируйте файл application-postgres.properties в application.properties и запустите скрипт start-app.cmd. Для старта приложения с использованием СУБД MySQL скопируйте файл application-mysql.properties в application.properties и запустите скрипт start-app.cmd 5.Для старта UI-тестов запустите скрипт start-test.cmd


Отчётные документы по итогам автоматизированного тестирования - 

Отчётные документы по итогам автоматизации - 

 
