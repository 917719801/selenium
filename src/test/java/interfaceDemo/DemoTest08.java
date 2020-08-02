package interfaceDemo;

import apiobject.DepartmentApiobject;
import apiobject.TokenHelper;
import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import task.evnTask;
import wecht.FakeUtils;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
/*
部门相关接口测试
优化记录
1.增加了入参实时获取的逻辑
2.增加了脚本的独立性改造
3.使用时间戳命名法避免数据重复
4.通过添加evnclear方法解决脚本无法重复运行的问题
5.对脚本进行了分层，减少了重复代码，减少了维护成本
6.使用数据驱动的方式将入参数据从代码中剥离
7.使用Junit5提供的java8 lambdas的断言方法，增加了脚本的容错性

 */

@Epic("Epic企业微信接口测试用例")
@Feature("Feature部门相关功能测试")
public class DemoTest08 {
    static String accessToken;
    static String deparmentid;

    @BeforeAll
    public static void getaccessToken() {
        accessToken = TokenHelper.getAccesstoken();
    }

    @BeforeEach
    @AfterEach
    void evnClear() {
        evnTask.evnClear(accessToken);

    }

    @Description("Description创建部门")
    @Story("Story创建部门测试")
    @DisplayName("DisplayName创建部门")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("Issue123")
    @TmsLink("test-1")
    //数据驱动从csv文件中获取文件名和相应错误码
    @CsvFileSource(resources = "/createDepartment.csv", numLinesToSkip = 1)
    @ParameterizedTest

    void creatDepartment(String creatname, String creatname_en, String returncode) {

        Response creatresponse = DepartmentApiobject.cratDepartment(creatname, creatname_en, accessToken);
        deparmentid = creatresponse.path("id") != null ? creatresponse.path("id").toString() : null;
        assertEquals(returncode, creatresponse.path("errcode").toString());
    }

    @Test
    @Description("更新部门")
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
    void listDepartment() {
        String creatname = "creatname" + FakeUtils.gettimeStamp();
        String creatname_en = "creatname_en" + FakeUtils.gettimeStamp();
        Response creatresponse = DepartmentApiobject.cratDepartment(creatname, creatname_en, accessToken);
        deparmentid = creatresponse.path("id") != null ? creatresponse.path("id").toString() : null;
        Response listResponse = DepartmentApiobject.listDepartment(deparmentid, accessToken);

        assertAll("返回值校验！",
                () -> assertEquals("0"+"x", listResponse.path("errcode").toString()),
                () -> assertEquals(deparmentid, listResponse.path("department.id[0]").toString()),
                () -> assertEquals(creatname, listResponse.path("department.name[0]").toString()),
                () -> assertEquals(creatname_en+"x", listResponse.path("department.name_en[0]").toString())

        );

//        assertEquals("0", listResponse.path("errcode").toString());
//        assertEquals(deparmentid, listResponse.path("department.id[0]").toString());
//        assertEquals(creatname, listResponse.path("department.name[0]").toString());
//        assertEquals(creatname_en, listResponse.path("department.name_en[0]").toString());
    }

    @Test
    @Description("删除部门")
    void deletDepartment() {
        Response creatresponse = DepartmentApiobject.cratDepartment(accessToken);
        deparmentid = creatresponse.path("id") != null ? creatresponse.path("id").toString() : null;
        Response deletResponse = DepartmentApiobject.deleteDepartment(deparmentid, accessToken);
        assertEquals("0", deletResponse.path("errcode").toString());
    }

}
