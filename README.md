# InnovationCredit
# Выпускной проект МТС
- Разработка сервиса "ОФОРМЛЕНИЕ КРЕДИТА"

# бизнес требования
• Клиент должен иметь возможность получить тарифы и условия кредита
• Клиент должен иметь возможность подать заявку на кредит
• Клиент должен иметь возможность получить статус заявки на кредит
• Клиент должен иметь возможность удалить заявку на кредит

# Нефункциональные требования
• создать структуры базы данных использовав liquibase с миграция в формате .yaml
• выпоонять запросы через JdbcTemplate
• обработка ошибки с помощью ExceptionHandler
• следить за стабильностью сервисов с помощью Circuit Breaker

# Используемые технологии
- java 19
- spring boot
- liquibase
- ExceptionHandler
- jdbc template
- sheduler
- maven
- lombok
- docker
- postgresSQL

 - Метод получения тарифов
    - GET loan-service/getTariffs


- Метод подачи заявки на кредит
    - POST loan-service/order
    - Входящие данные { "userId": {userId}, "tariffId": {tariffId} }


- Метод получения статуса заявки
    - GET loan-service/getStatusOrder?orderId={orderId}


- Метод удаления заявки
    - DELETE loan-service/deleteOrder
    - Входящие данные { "userId": {userId}, "orderId": {orderId} }

# Как запустить проект?
1) Для запуска проекта Вам необходимо установить Docker на устройство с официального сайта (https://www.docker.com/)
2) В заранее выбранную папку необходимо склонировать проект
   - Clone with SSH: git@github.com:Verunya1/InnovationCredit.git
   - Clone with HTTPS: https://github.com/Verunya1/InnovationCredit.git
4) В терминале прописать команду docker run --name habr-pg-13.3 -p 5432:5432 -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=password -e POSTGRES_DB=habrdb -d postgres:13.3



  
