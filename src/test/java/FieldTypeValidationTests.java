import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class FieldTypeValidationTests {

    @BeforeAll
    public static void setup() {
        // Настройка базового URI и пути для всех запросов
        RestAssured.baseURI = "https://qa-internship.avito.com";
        RestAssured.basePath = "/api/1";
    }

    @Test
    public void testFieldTypes() {
        // Шаг 1: Отправка запроса и получение ответа
        Response response = given()
                .when()
                .get("/item/0cd4183f-a699-4486-83f8-b513dfde477a")  // Пример запроса
                .then()
                .statusCode(200)  // Проверка, что статус ответа 200 OK
                .extract()
                .response();

        // Шаг 2: Вывод JSON-ответа в консоль для диагностики
        System.out.println("JSON-ответ: " + response.asString());

        // Шаг 3: Проверка, что ответ является непустым массивом
        assertTrue(response.jsonPath().getList("$").size() > 0, "Ответ должен быть непустым массивом");

        // Шаг 4: Извлечение первого элемента массива
        Object firstItem = response.jsonPath().getList("$").get(0);
        assertNotNull(firstItem, "Первый элемент массива не должен быть null");

        // Шаг 5: Преобразование первого элемента в Map для доступа к полям
        java.util.Map<String, Object> itemMap = (java.util.Map<String, Object>) firstItem;

        // Шаг 6: Проверка наличия и типа поля sellerId
        Object sellerId = itemMap.get("sellerId");
        assertNotNull(sellerId, "Поле sellerId отсутствует в ответе");
        assertTrue(sellerId instanceof Integer || sellerId instanceof Long,
                "sellerId должен быть integer или long");

        // Шаг 7: Проверка типа поля name
        assertTrue(itemMap.get("name") instanceof String, "name должен быть string");

        // Шаг 8: Проверка типа поля price
        assertTrue(itemMap.get("price") instanceof Integer, "price должен быть integer");

        // Шаг 9: Проверка типа поля statistics
        assertTrue(itemMap.get("statistics") instanceof java.util.Map, "statistics должен быть объектом");

        // Шаг 10: Проверка типов полей внутри statistics
        java.util.Map<String, Object> statistics = (java.util.Map<String, Object>) itemMap.get("statistics");
        assertTrue(statistics.get("contacts") instanceof Integer, "contacts должен быть integer");
        assertTrue(statistics.get("likes") instanceof Integer, "likes должен быть integer");
        assertTrue(statistics.get("viewCount") instanceof Integer, "viewCount должен быть integer");
    }
}