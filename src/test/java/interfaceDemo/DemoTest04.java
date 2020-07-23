package interfaceDemo;

import apiobject.DepartmentApiobject;
import com.sun.org.glassfish.gmbal.Description;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import wecht.FakeUtils;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
/*
部门相关接口测试
优化记录
1.增加了入参实时获取的逻辑
2.增加了脚本的独立性改造
3.使用时间戳命名法避免数据重复

 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)//添加用例执行顺序
public class DemoTest04 {
    static String accessToken;
    static String deparmentid;

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

    @BeforeEach
    void evnClear() {
        Response listResponse = given()
                .when()
                .param("access_token", accessToken)
                .param("id", deparmentid)
                .contentType("application/json")
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
                .then()
                .log().body()
                .extract()
                .response();
        ArrayList<Integer> departmentidList = listResponse.path("department.id");

        for (int departmentid : departmentidList) {
            if (1 == departmentid) {
                continue;
            }
            Response deletResponse = given()
                    .when()
                    .param("access_token", accessToken)
                    .param("id", departmentid)
                    .contentType("application/json")
                    .get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
                    .then()
                    .log().body()
                    .extract()
                    .response();

        }

    }

    @AfterEach
    void endClear() {
        Response listResponse = given()
                .when()
                .param("access_token", accessToken)
                .param("id", deparmentid)
                .contentType("application/json")
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
                .then()
                .log().body()
                .extract()
                .response();
        ArrayList<Integer> departmentidList = listResponse.path("department.id");

        for (int departmentid : departmentidList) {
            if (1 == departmentid) {
                continue;
            }
            Response deletResponse = given()
                    .when()
                    .param("access_token", accessToken)
                    .param("id", departmentid)
                    .contentType("application/json")
                    .get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
                    .then()
                    .log().body()
                    .extract()
                    .response();

        }

    }

    @Test
    @Description("创建部门")
    @Order(1)
    void creatDepartment() {
        String creatname = "creatname" + FakeUtils.gettimeStamp();
        String creatname_en = "creatname_en" + FakeUtils.gettimeStamp();
        Response creatresponse = DepartmentApiobject.cratDepartment(creatname, creatname_en, accessToken);
        deparmentid = creatresponse.path("id") != null ? creatresponse.path("id").toString() : null;
        assertEquals("0", creatresponse.path("errcode").toString());
    }

    @Test
    @Description("更新部门")
    @Order(2)
    void updateDepartment() {
        Response creatresponse = DepartmentApiobject.cratDepartment(accessToken);
        deparmentid = creatresponse.path("id") != null ? creatresponse.path("id").toString() : null;
        String updatename = "updatecreatname" + FakeUtils.gettimeStamp();
        String updatenameEn = "updatecreatname_en" + FakeUtils.gettimeStamp();
        Response updateResponse = DepartmentApiobject.updateDepartment(updatename, updatenameEn, deparmentid, accessToken);
        assertEquals("0", updateResponse.path("errcode").toString());
    }


    @Test
    @Description("查询部门")
    @Order(3)
    void listDepartment() {
        Response creatresponse = DepartmentApiobject.cratDepartment(accessToken);
        deparmentid = creatresponse.path("id") != null ? creatresponse.path("id").toString() : null;

        Response listResponse = given()
                .when()
                .param("access_token", accessToken)
                .param("id", deparmentid)
                .contentType("application/json")
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
                .then()
                .log().body()
                .extract()
                .response();
        assertEquals("0", listResponse.path("errcode").toString());
    }

    @Test
    @Description("删除部门")
    @Order(4)
    void deletDepartment() {
        Response creatresponse = DepartmentApiobject.cratDepartment(accessToken);
        deparmentid = creatresponse.path("id") != null ? creatresponse.path("id").toString() : null;
        Response deletResponse = given()
                .when()
                .param("access_token", accessToken)
                .param("id", deparmentid)
                .contentType("application/json")
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
                .then()
                .log().body()
                .extract()
                .response();
        assertEquals("0", deletResponse.path("errcode").toString());
    }

}
