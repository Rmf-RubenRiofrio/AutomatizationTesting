package com.ruben.api;

import com.ruben.framework.ConfigReader;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PostsApiTest {
    @Test
    void getPostById_shouldReturnPostDetails(){
        given()
                .baseUri(ConfigReader.getProperty("api.base.url"))
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .body("id",equalTo(1))
                .body("userId",notNullValue())
                .body("title",notNullValue())
                .body("body",notNullValue());
    }

    @Test
    void getInvalidPost_shouldReturnNotFound(){
        given()
                .baseUri(ConfigReader.getProperty("api.base.url"))
                .when()
                .get("/posts/999999")
                .then()
                .statusCode(404);
    }

    @Test
    void createPost_shouldReturnCreatedPost() {
        given()
                .baseUri(ConfigReader.getProperty("api.base.url"))
                .header("Content-Type", "application/json")
                .body("""
                    {
                      "title": "Test Automation",
                      "body": "Learning REST API testing",
                      "userId": 1
                    }
                    """)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("title", equalTo("Test Automation"));
    }
}
