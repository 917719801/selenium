package apiobject;

import io.restassured.response.Response;
import wecht.FakeUtils;

import static io.restassured.RestAssured.given;

public class DepartmentApiobject {
    public static Response cratDepartment(String creatname, String creatname_en, String accessToken) {
        String creatbody = "{\n" +
                "   \"name\": \"" + creatname + "\",\n" +
                "   \"name_en\": \"" + creatname_en + "\",\n" +
                "   \"parentid\": 1,\n" +
                "   \"order\": 1,\n" +
                "   }";
        Response creatresponse = given()
                .when()
                .contentType("application/json")
                .body(creatbody)
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=" + accessToken)
                .then()
                .log().body()
                .extract()
                .response();
        return creatresponse;
    }

    public static Response cratDepartment(String accessToken) {
        String creatname = "creatname" + FakeUtils.gettimeStamp();
        String creatname_en = "creatname_en" + FakeUtils.gettimeStamp();
        return cratDepartment(creatname, creatname_en, accessToken);
    }

    public static Response updateDepartment(String updatename, String updatenameEn, String deparmentid, String accessToken) {
        String updatabody = "{\n" +
                "   \"id\": " + deparmentid + ",\n" +
                "   \"name\": \"" + updatename + "\",\n" +
                "   \"name_en\": \"" + updatenameEn + "\",\n" +
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
        return updateResponse;
    }
}