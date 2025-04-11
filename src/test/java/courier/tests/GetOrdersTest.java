package courier.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static courier.steps.CourierSteps.*;
import static org.junit.Assert.*;

public class GetOrdersTest {
    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru/";
    }

    @Test
    @DisplayName("Get all orders")
    @Description("Test that list orders is not empty")
    public void createNewOrder() {
        Response response = getOrders();
        validateResponseStatusCode(response, 200);
        Object orders = response.path("orders");
        assertNotNull("key \"orders\" not found in response body", orders);
        List list = (List) orders;
        assertFalse("List orders should not be empty", list.isEmpty());
    }
}
