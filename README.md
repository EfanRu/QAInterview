# AQAInterview 
### For interview aqa engineers.

This is the first sample of the pen. Ideally, this project should be deployed via ansible playbook in the cloud, but so far there is no need and interest in the project, I do it with my hands, and then I turn off the server so as not to spend money in the cloud.

Web interview is conducted in [SeleniumDevTest.java](src%2Ftest%2Fjava%2FSeleniumDevTest.java) . Here are the connection tests with selenium.dev with local chrome and selenoid on server, as well as one simple but broken test for selenium.dev. A broken task will show us how people think and debug problems. The tasks are given in the annotations to the test.

DB interview is conducted in [DBTest.java](src%2Ftest%2Fjava%2FDBTest.java) . Here are connection tests with remote DB and task with select with like and select with join tables. For simplicity and use of native work with the database, the simplest implementation has been made. No one bothers to use Database tools for example DBeaver. Ideally, need write Hibernate test.

To do list [toDo.md](toDo.md)

# Requirements / Default properties
- Selenoid work with docker image chrome ver 116.0
- Link to selenoid on host in application.properties
- In DB connection for user aqa approved only select
- docker applications (selenoid & selenoid-ui) need set up always on run server [howInstallServer.md](installServerGuid%2FhowInstallServer.md)

# English disclaimer
The entire text is written in English because most of the answers on the web are only in English.
The text of the tasks can be translated through a translator, beacause the entire English text was written is this way :)

# Questions for interview example:
Вопросы к техническому собеседованию:
	HTTP/HTTPS & REST:
		normal:
			- Из чего состоит http request? Какие его части являются обязательными?
			- Из чего состоит http response? Какие его части являются обязательными?
			- Чем отличается HTTP от HTTPS?
			- Что означают сотни в кодах состояний? 404? 403? 503?
			- Что такое REST?
			- Что такое микросервисы?
		hard:
			- Какой TCP порт у http запроса, а какой у https?
			- Можно ли в http сделать свой метод, например Akcio?
			- Как работают брокеры очередей и зачем они нужны?
			
	Java core:
		normal:
			- Что такое static и что он означает?
			- Когда лучше использовать абстрактный класс, а когда интерфейс на примере автотестирования?
			- Чем полезен и как можно в автотестах использовать вложенный класс?
			- Какие структуры данных есть в java? Какие примеры их использования вы можете привести в автотестах?
		hard:
			- Какие проблемы при многопоточном запуске автотестов?
			- Что думаешь о инициализации переменных значением null?
			- Что такое heap и stack память в java? Какая разница между ними?
			- Что делать если автотесты начинают падать из-за java.lang.OutOfMemoryError: Java heap space?
			- Как увеличить объем потребляемый JVM?
			
	Тетирование:
		normal:
			- Пирамида тестирования?
			- Парное тестирование?
			- Каие есть характеристики у багов? Опишите их.
			
	Администрирование и CI:
		normal:
			- Что такое CI и зачем он нужен?
			- Какой командой можно сгенерировать отчет allure?
			- Как работает контейнерезация и зачем нужна? Например docker.
			- Что такое selenoid и selenide? :)
			- Назовите чаcто используемые команды в Linux;
		hard:
			- Напишите строку запуска тестов для maven-surefire-plugin, указав в строке через параметры 1 тест и количество потоков;
