## 1. Отсутствие валидации обязательных полей
### 1.1 Создание объявление без указания ID
### Шаги выполнения
1. Отправка запроса `Post` `https://qa-internship.avito.com/api/1/item`
2. Тестовые данные
`"sellerId": "239049331"`
   
   Body JSON
```json
{
    "createdAt": "2025-02-18 11:28:35.164375 +0500 +0500",

    "name": "Мой товар2",
    "price": 1502,
    "sellerId": 239049331,
    "statistics": {
        "contacts": 6,
        "likes": 50,
        "viewCount": 100
    }
}
```
3. Получен статус ответа `202 OK`
### Ожидаемый Результат:
Получен статус ответа `400 Bad Request`

### Фактический Результат:
Получен статус ответа `200 OK`

Body JSON
```json
{
    "status": "Сохранили объявление - 26420c68-6dd9-4a20-bcda-a82313290bab"
}
```
### 1.2 Создание объявление без указания sellerId
### Шаги выполнения
1. Отправка запроса `Post` `https://qa-internship.avito.com/api/1/item`
2. Тестовые данные
   `"id": "0rptrptp-7777-4dfdf-8dfdfd-b5ororota"`
   
   Body JSON
```json
{
    "createdAt": "2025-02-12 11:28:35.164375 +0300 +0300",
    "id": "0rptrptp-7777-4dfdf-8dfdfd-b5ororota",
    "name": "Мой товар",
    "price": 1500,
    
    "statistics": {
        "contacts": 5,
        "likes": 50,
        "viewCount": 100
    }
}
```
3. Получен статус ответа `202 OK`
   
### Ожидаемый Результат:
Получен статус ответа `400 Bad Request`

### Фактический Результат:
Получен статус ответа `200 OK`

Body JSON
```json
{
    "status": "Сохранили объявление - 277958fa-4c51-4fc9-acc0-550e40539ada"
}
```
## 1.3 Повторное создание объявление с уже существующими данными
### Шаги выполнения
1. Отправка запроса `Post` `https://qa-internship.avito.com/api/1/item`
2. Предварительный данные:

   Body JSON
```json
{
 "createdAt": "2025-02-18 11:28:35.164375 +0500 +0500",
    "id": "0rptrptp-7777-4dfdf-8dfdfd-b5ororota"
    "name": "Мой товар2",
    "price": 1502,
    "sellerId": 239049331,
    "statistics": {
        "contacts": 6,
        "likes": 50,
        "viewCount": 100
   }
}
```

3. Тестовые данные
`"id": "0rptrptp-7777-4dfdf-8dfdfd-b5ororota"`
`"sellerId": "239049331"`
   
   Body JSON
```json
{
    "createdAt": "2025-02-18 11:28:35.164375 +0500 +0500",
    "id": "0rptrptp-7777-4dfdf-8dfdfd-b5ororota"
    "name": "Мой товар2",
    "price": 1502,
    "sellerId": 239049331,
    "statistics": {
        "contacts": 6,
        "likes": 50,
        "viewCount": 100
    }
}
```
4. Получен статус ответа `202 OK`
### Ожидаемый Результат:
Получен статус ответа `400 Bad Request`

### Фактический Результат:
Получен статус ответа `200 OK`

Body JSON
```json
{
    "status": "Сохранили объявление - 0cf9a591-d098-493a-8fa8-2962ae139019"
}
```
## 2. Отсутствие граничных значений для ввода в поля типа integer
1. Отправка запроса `Post` `https://qa-internship.avito.com/api/1/item`
2. Тестовые данные
   
 Body JSON
```json
{
    "createdAt": "2025-02-18 11:28:35.164375 +0500 +0500",
    "id": "0rptrptp-7777-4dfdf-8dfdfd-b5ororota"
    "name": "Мой товар14",
    "price": -1502,
    "sellerId": -239049331,
    "statistics": {
        "contacts": -6,
        "likes": -50,
        "viewCount": -100
    }
}
```
### Ожидаемый Результат:
Получен статус ответа `400 Bad Request`

### Фактический Результат:
Получен статус ответа `200 OK`

Body JSON
```json
{
    "status": "Сохранили объявление - c239fa1d-3b8a-4f1e-a4b2-018bab266cb6"
}
```
