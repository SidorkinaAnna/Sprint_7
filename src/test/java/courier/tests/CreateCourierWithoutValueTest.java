package courier.tests;

import courier.pojo.RegistrationNewCourierDTO;
import courier.pojo.ResponseMessage;
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

import static courier.steps.CourierSteps.*;

@RunWith(Parameterized.class)
public class CreateCourierWithoutValueTest {
    private RegistrationNewCourierDTO newCourierDTO;
    private int expectedResponseCode;
    private ResponseMessage expectedBody;

    public CreateCourierWithoutValueTest(RegistrationNewCourierDTO newCourierDTO, int expectedResponseCode, ResponseMessage expectedBody) {
        this.newCourierDTO = newCourierDTO;
        this.expectedResponseCode = expectedResponseCode;
        this.expectedBody = expectedBody;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new RegistrationNewCourierDTO("", "1234", "AnnaV"), 400, new ResponseMessage("Недостаточно данных для создания учетной записи")},
                {new RegistrationNewCourierDTO("newCourierAnyaS", "", "AnnaV"), 400, new ResponseMessage("Недостаточно данных для создания учетной записи")},
                {new RegistrationNewCourierDTO(null, "1234", "AnnaV"), 400, new ResponseMessage("Недостаточно данных для создания учетной записи")},
        });
    }

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru/";
    }

    @Test
    @DisplayName("Create courier without some values")
    @Description("Expect error 400")
    public void creatingCourierWithoutValue() {
        Response response = newCourier(newCourierDTO);
        validateResponseStatusCode(response, expectedResponseCode);
        validateResponseBody(response, expectedBody);
    }



}
