package br.com.financial_api;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CategoryResourceTest {
    @Test
    public void testListAll() {
        given()
          .when().get("/category")
          .then()
             .statusCode(200);
    }
}