package interfaceDemo;

import com.sun.org.glassfish.gmbal.Description;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static io.restassured.RestAssured.given;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
部门相关接口测试
 */


public class DemoTest01 {
    static String accessToken;

    @BeforeAll
    public static void getaccessToken() {
        accessToken = given()
                .when()
                .param("corpid", "wwa3df01c934fd5733")
                .param("corpsecret", "bioYbELS1UUYa07kxy-9xMDGS3Ejc1U0L7JIyEyGYCs")
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then()
                .log().body()
                .extract()
                .response()
                .path("access_token");
    }
    @Test
    @Description("创建部门")
    void creatDepartment() {
        String creatbody = "{\n" +
                "   \"name\": \"广州研发中心\",\n" +
                "   \"name_en\": \"RDGZ\",\n" +
                "   \"parentid\": 1,\n" +
                "   \"order\": 1,\n" +
                "   \"id\": 2\n" +
                "}";
        Response creatresponse = given()
                .when()
                .contentType("application/json")
                .body(creatbody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=" + accessToken)
                .then()
                .log().body()
                .extract()
                .response();
        assertEquals("0",creatresponse.path("errcode").toString());
    }
    @Test
    @Description("更新部门")
    void updateDepartment() {
        String updatabody = "{\n" +
                "   \"id\": 2,\n" +
                "   \"name\": \"广州研发中心更新后\",\n" +
                "   \"name_en\": \"RDGZ\",\n" +
                "   \"parentid\": 1,\n" +
                "   \"order\": 1\n" +
                "}";
        Response updateResponse = given()
                .when()
                .contentType("application/json")
                .body(updatabody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=" + accessToken)
                .then()
                .log().body()
                .extract()
                .response();
        assertEquals("0",updateResponse.path("errcode").toString());
    }



    @Test
    @Description("查询部门")
    void listDepartment() {
        Response listResponse = given()
                .when()
                .param("access_token",accessToken)
                .param("id","1")
                .contentType("application/json")
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
                .then()
                .log().body()
                .extract()
                .response();
        assertEquals("0",listResponse.path("errcode").toString());
    }
    @Test
    @Description("删除部门")
    void deletDepartment() {
        Response deletResponse = given()
                .when()
                .param("access_token",accessToken)
                .param("id","2")
                .contentType("application/json")
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
                .then()
                .log().body()
                .extract()
                .response();
        assertEquals("0",deletResponse.path("errcode").toString());
    }

}
