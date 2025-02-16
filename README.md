##Автотест проверяет:

1. JSON-ответ является непустым массивом.

2. Первый элемент массива содержит все ожидаемые поля.

3. Типы данных полей соответствуют ожидаемым:

sellerId — целое число (Integer или Long).

name — строка (String).

price — целое число (Integer).

statistics — объект (Map).

Поля внутри statistics (contacts, likes, viewCount) — целые числа (Integer).
