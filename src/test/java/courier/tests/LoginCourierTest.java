package courier.tests;

import courier.pojo.LoginDTO;
import courier.pojo.RegistrationNewCourierDTO;
import courier.pojo.ResponseMessage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static courier.steps.CourierSteps.*;
import static org.junit.Assert.assertNotNull;

public class LoginCourierTest {
    private String login = "newCourierAnyaS";
    private String password = "1234";
    private String firstName = "AnnaV";

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru/";
    }


    private void registerUser(){
        newCourier(new RegistrationNewCourierDTO(login, password, firstName));
    }
    private void deleteUser(String id){
        deleteCourier(id);
    }

    @Test
    @DisplayName("Login courier")
    @Description("Success login courier")
    public void loginCourier() {
        registerUser();

        Response response = loginRequest(new LoginDTO(login, password));
        validateResponseStatusCode(response, 200);
        Integer id = response.path("id");

        assertNotNull("response must have id", id);

        deleteUser(id.toString());
    }

    @Test
    @DisplayName("Fail login courier")
    @Description("Login courier without login")
    public void loginCourierWithoutLogin() {
        Response response = loginRequest(new LoginDTO("", password));
        validateResponseStatusCode(response, 400);
        validateResponseBody(response, new ResponseMessage("Недостаточно данных для входа"));
    }

    @Test
    @DisplayName("Fail login courier")
    @Description("Login courier without password")
    public void loginCourierWithoutPassword() {
        Response response = loginRequest(new LoginDTO("ninja", ""));
        validateResponseStatusCode(response, 400);
        validateResponseBody(response, new ResponseMessage("Недостаточно данных для входа"));
    }

    @Test
    @DisplayName("Fail login courier")
    @Description("Doesn't exist login courier")
    public void loginCourierNotExist() {
        Response response = loginRequest(new LoginDTO("ninja" + System.currentTimeMillis(), "1234"));
        validateResponseStatusCode(response, 404);
        validateResponseBody(response, new ResponseMessage("Учетная запись не найдена"));
    }

}
