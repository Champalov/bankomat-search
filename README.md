# bankomat-search-application-middle

# локальная база
docker run --name ibs_db -e POSTGRES_USER=innoteh -e POSTGRES_PASSWORD=12345678 -e POSTGRES_DB=ibs_db -d -p 65432:5432 postgres:9.6.11

# в application.yml
nsp_source_url: https://www.vtb.ru/nsp.xml                              # урл для загрузки nsp.xml
nsp_source_file: D:\Innoteh\bankomat-search\src\main\resources\nsp.xml  # путь к файлу для загрузки nsp.xml
spring:
  application:
    name: bankomat-search-api
  datasource:
    url: jdbc:postgresql://localhost:65432/ibs_db                       # локальная база данных
    username: innoteh                                                   # пользователь БД
    password: 12345678                                                  # пароль БД
    driver-class-name: org.postgresql.Driver
  liquibase:
    change-log: classpath:db/changelog/db.changelog-master.xml

# загрузку данных через урл по расписанию можно настроить в классе ScheduledTasks
    @Scheduled(cron = "0 0 0 * * ?")
    public void scheduledUrlDataLoad() {
        dataService.loadToBase(XmlLoadService.XmlSourceType.URL);
    }

# реализованы 2 реста - можно тестить через сваггер/постман
POST /data/load-from-xml     -- загрузка данных из nsp.xml в базу через урл или из файла
http://localhost:8080/data/load-from-xml?xmlSourceType=URL

POST /data/search            -- поиск по параметрам в локальной базе
http://localhost:8080/data/search

# Структура параметров поиска CompanySearchParams (поля которые не участвуют в поиске можно не указывать или заполнять как null):
    int startPage;    // начальная страница пагинатора
    int itemsPerPage; // количество записей на страницу пагинатора
    String sortBy;    // поле сортировки
    boolean sortDesc; // признак сортировки по убыванию
    Filter filters;   // фильтры 
        Coordinates coordinates; // координаты (широта, долгота) точки относительно которой считаем расстояние
        Double radius;           // радиус в метрах в пределах которого ищем
        String name;             // фильтрация по вхождению подстроки в имя организации
        String address;          // --//-- в адрес организации (вида country+' '+address+' '+address_add)
        String workingTime;      // --//-- в строку рабочего времен
        String url;              // --//-- в строку url
        String rubricId;         // --//-- в id рубрики
        String companyId;        // --//-- в id компании

# пример
{
  "filters": {
    "coordinates": {
      "lat": 55.781895,
      "lon": 37.633067
    },
    "radius": 20000,
    "name": null,
    "address": "ревск",
    "workingTime": null,
    "url": null,
    "companyId": null,
    "rubricId": null  },
  "itemsPerPage": 100,
  "startPage": 0,
  "sortBy": null,
  "sortDesc": false
}

