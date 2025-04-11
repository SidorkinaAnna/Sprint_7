package courier.steps;

import courier.pojo.LoginDTO;
import courier.pojo.RegistrationNewCourierDTO;
import courier.pojo.RegistrationOrderDTO;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CourierSteps {


    @Step("POST request create new courier with data: {request}")
    public static Response newCourier(RegistrationNewCourierDTO request){
        return given()
                .header("Content-type", "application/json")
                .and().body(request)
                .when()
                .post("api/v1/courier");
    }

    @Step("Validate response status code {expectedStatusCode}")
    public static void validateResponseStatusCode(Response response, int expectedStatusCode){
        response.then().assertThat().statusCode(expectedStatusCode);
    }

    @Step("Expect response body equals to {expectedJsonBody}")
    public static void validateResponseBody(Response response, Object expectedJsonBody){
        Class<?> bodyClass = expectedJsonBody.getClass();
        Object object = response.then().extract().as(bodyClass);
        assertThat(object, equalTo(expectedJsonBody));
    }

    @Step("Login user with data {request}")
    public static Response loginRequest(LoginDTO request){
        return given()
                .header("Content-type", "application/json")
                .and().body(request)
                .when()
                .post("api/v1/courier/login");
    }

    @Step("Delete user with id {id}")
    public static Response deleteCourier(String id){
        return given()
                .pathParams("id", id)
                .delete("api/v1/courier/{id}");
    }

    @Step("Create order: {request}")
    public static Response createOrder(RegistrationOrderDTO request){
        return given()
                .header("Content-type", "application/json")
                .and().body(request)
                .when()
                .post("/api/v1/orders");
    }

    @Step
    public static Response getOrders(){
        return given()
                .when()
                .get("/api/v1/orders");
    }


}
