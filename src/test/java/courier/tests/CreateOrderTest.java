package courier.tests;

import courier.pojo.RegistrationOrderDTO;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static courier.steps.CourierSteps.*;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class CreateOrderTest {
    private RegistrationOrderDTO registrationOrderDTO;

    public CreateOrderTest(RegistrationOrderDTO registrationOrderDTO) {
        this.registrationOrderDTO = registrationOrderDTO;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new RegistrationOrderDTO(
                                "Megumy",
                                "Fushiguru",
                                "Tokyo, 15",
                                4,
                                "+7 800 355 35 35",
                                5,
                                "2020-06-06",
                                List.of("BLACK"),
                                "pupupu"
                        )
                },
                {
                        new RegistrationOrderDTO(
                                "Megumy",
                                "Fushiguru",
                                "Tokyo, 15",
                                4,
                                "+7 800 355 35 35",
                                5,
                                "2020-06-06",
                                List.of("BLACK", "GREY"),
                                "pupupu"
                        )
                },

                {
                        new RegistrationOrderDTO(
                                "Megumy",
                                "Fushiguru",
                                "Tokyo, 15",
                                4,
                                "+7 800 355 35 35",
                                5,
                                "2020-06-06",
                                List.of(""),
                                "pupupu"
                        )
                }
        });
    }

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru/";
    }

    @Test
    @DisplayName("Create new order")
    @Description("Success new order creating")
    public void createNewOrder() {
        Response response = createOrder(registrationOrderDTO);
        validateResponseStatusCode(response, 201);
        Object track = response.path("track");
        assertNotNull("key \"track\" not found in response body", track);
    }
}
