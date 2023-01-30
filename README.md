# Java_IP
WebSupport(Rest API), UNIT testing, JavaFX GUI
 
Необходимо реализовать консольное приложение, которое:

1)  Читает данные из входного файла;
2)  Обрабатывает полученную информацию;
3)  Записывает данные в выходной файл;
 
Входной и выходной файл могут быть следующих форматов: plain text, xml, json. Так же входные и выходные файлы могут быть архивированы и зашифрованы, разными engines (только архивирован, только зашифрован, сперва архивирован, а потом зашифрован и наоборот).
 
«Тип» входного и выходного файла задаются параметрами консоли.
Приложение реализовать двумя способами: без использования Design Patterns и c использованием Design Patterns (Decorator и Builder … можно оформить Builder в виде Singleton-а), сравнить реализации.
 
Обработка информации на первом этапе: найти все арифметические операции во входном файле и заменить на результаты в выходном файле.
Реализовать фильтрацию двумя способами без использования регулярных выражений и с использованием регулярных выражений (а так же третьим :) найти библиотеку, которая все делает за вас, парсинг и калькуляцию, такие есть и не одна). Провести сравнительный анализ 2-х вариантов реализации.
 
Следующие шаги по нашей задаче:
1)  Добавить UI:
    a.  консольный;
    b.  использую любую графическую библиотеку Java на Ваш выбор;
    c.  сравнить CLI и UI based реализации;
    d.  поговорить с одногруппниками и сравнить различные графические Java библиотеки;
2)  Реализовать логику как Web Service:
    a.  Rest, используя любой Java engine;
    b.  SOAP, используя любой Java engine;
    c.  Сравнить Rest и SOAP реализации;
    d.  поговорить с одногруппниками и сравнить различные Rest \ Soap Java engines;
3)  Соединить все вместе UI и Web Service;

Примеры атомарных подзадач:
Чтение \ запись текстовый файл;
Чтение \ запись xml файл (используя специальный API для чтения XML и не используя – чтение по строчно);
Чтение \ запись json файл (используя специальный API для чтения XML и не используя – чтение по строчно);
Архивация \ де Архивация файла используя ту или иную реализацию Zip;
Архивация \ де Архивация файла используя ту или иную реализацию Rar;
Шифровка \ де Шифровка файла используя любую библиотеку шифрования;
Покрыть все эти атомарные задачи Unit Test-ами;

1) Парсинг, уверен, большинство не решило задачу разбора и расчёта арифметических выражений в полном объеме, есть ограничения о которых нужно сказать.
2) Какие архиваторы и шифровальные алгоритмы поддерживает
3) Какая вложенность ..? Могу ли я зазиповать, зарарить, потом зашифровать и еще раз разиповать и так далее. Укажите пожалуйста вложенность и конкретные примеры вложенности.
4) Есть ли UI: Desktop, Web, оба ... если да, то на какой технологии
5) Есть ли сервисы и если да, то какие: Rest, SOAP, Оба.

![image](https://github.com/Ilusha2004/Java_IP/blob/main/src/res/images/Screenshot%202023-01-17%20015046.png)
![image](https://github.com/Ilusha2004/Java_IP/blob/main/src/res/images/Screenshot%202023-01-17%20015103.png)
![image](https://github.com/Ilusha2004/Java_IP/blob/main/src/res/images/Screenshot%202023-01-17%20015155.png)
![image](https://github.com/Ilusha2004/Java_IP/blob/main/src/res/images/Screenshot%202023-01-17%20015210.png)
![image](https://github.com/Ilusha2004/Java_IP/blob/main/src/res/images/Screenshot%202023-01-17%20015221.png)
![image](https://github.com/Ilusha2004/Java_IP/blob/main/src/res/images/Screenshot%202023-01-17%20015237.png)
![image](https://github.com/Ilusha2004/Java_IP/blob/main/src/res/images/Screenshot%202023-01-17%20015248.png)
![image](https://github.com/Ilusha2004/Java_IP/blob/main/src/res/images/Screenshot%202023-01-17%20015302.png)
![image](https://github.com/Ilusha2004/Java_IP/blob/main/src/res/images/Screenshot%202023-01-17%20015315.png)
![image](https://github.com/Ilusha2004/Java_IP/blob/main/src/res/images/Screenshot%202023-01-17%20015329.png)
![image](https://github.com/Ilusha2004/Java_IP/blob/main/src/res/images/Screenshot%202023-01-17%20015329.png)
![image](https://github.com/Ilusha2004/Java_IP/blob/main/src/res/images/Screenshot%202023-01-17%20015339.png)
![image](https://github.com/Ilusha2004/Java_IP/blob/main/src/res/images/Screenshot%202023-01-17%20015355.png)
![image](https://github.com/Ilusha2004/Java_IP/blob/main/src/res/images/Screenshot%202023-01-17%20015421.png)
![image](https://github.com/Ilusha2004/Java_IP/blob/main/src/res/images/Screenshot%202023-01-17%20015516.png)





