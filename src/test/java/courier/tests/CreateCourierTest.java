package courier.tests;

import courier.pojo.LoginDTO;
import courier.pojo.RegistrationNewCourierDTO;
import courier.pojo.ResponseSuccess;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static courier.steps.CourierSteps.*;

@RunWith(Parameterized.class)
public class CreateCourierTest {
    private RegistrationNewCourierDTO newCourierDTO;

    public CreateCourierTest(RegistrationNewCourierDTO newCourierDTO) {
        this.newCourierDTO = newCourierDTO;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {new RegistrationNewCourierDTO("newCourierAnyaS", "1234", "AnnaV")},
                {new RegistrationNewCourierDTO("newCourierOLEG", "1234", "OLEG")}
        });
    }

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru/";
    }

    @After
    public  void after() {
        LoginDTO loginDTO = new LoginDTO(newCourierDTO.getLogin(), newCourierDTO.getPassword());
        Response response = loginRequest(loginDTO);
        int statusCode = response.statusCode();
        if(statusCode == 200){
            Integer id = response.path("id");
            deleteCourier(id.toString());
        }
    }


    @Test
    @DisplayName("Create new courier")
    @Description("Success new courier creating")
    public void createNewCourier() {
        Response response = newCourier(newCourierDTO);
        validateResponseStatusCode(response, 201);
        validateResponseBody(response, new ResponseSuccess("true"));
    }

    @Test
    @DisplayName("Create duplicate courier")
    @Description("Expect error 409 while new courier creating")
    public void creatingDuplicateCourier() {
        Response response = newCourier(newCourierDTO);
        validateResponseStatusCode(response, 201);
        response = newCourier(newCourierDTO);
        validateResponseStatusCode(response, 409);
    }

}
