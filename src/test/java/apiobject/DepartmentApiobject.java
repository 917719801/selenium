package apiobject;

import io.restassured.response.Response;
import org.junit.jupiter.api.RepeatedTest;
import wecht.FakeUtils;

import static io.restassured.RestAssured.given;

public class DepartmentApiobject {
    //添加部门分装
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
//使用时间戳进行命名，避免数据重复
    public static Response cratDepartment(String accessToken) {
        String creatname = "creatname" + FakeUtils.gettimeStamp();
        String creatname_en = "creatname_en" + FakeUtils.gettimeStamp();
        return cratDepartment(creatname, creatname_en, accessToken);
    }
//更新部门封装
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
//查询部门封装
    public static Response listDepartment(String deparmentid, String accessToken) {
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
        return listResponse;
    }
//删除部门封装
    public static Response deleteDepartment(String deparmentid, String accessToken) {
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
        return deletResponse;

    }
}
