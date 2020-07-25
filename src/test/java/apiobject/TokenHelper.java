package apiobject;

import javax.xml.ws.Response;

import static io.restassured.RestAssured.given;

public class TokenHelper {
    public static String getAccesstoken() {
        String accessToken = given()
                .when()
                .param("corpid", "wwa3df01c934fd5733")
                .param("corpsecret", "bioYbELS1UUYa07kxy-9xMDGS3Ejc1U0L7JIyEyGYCs")
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then()
                .log().body()
                .extract()
                .response()
                .path("access_token");
        return accessToken;
    }
}
