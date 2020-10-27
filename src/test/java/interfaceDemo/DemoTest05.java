package interfaceDemo;

import apiobject.DepartmentApiobject;
import apiobject.TokenHelper;
import com.sun.org.glassfish.gmbal.Description;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import task.evnTask;
import wecht.FakeUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
部门相关接口测试
优化记录
1.增加了入参实时获取的逻辑
2.增加了脚本的独立性改造
3.使用时间戳命名法避免数据重复
4.通过添加evnclear方法解决脚本无法重复运行的问题
5.对脚本进行了分层，减少了重复代码，减少了维护成本
 */


public class DemoTest05 {
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

    @Test
    @Description("创建部门")
    void creatDepartment() {
        String creatname = "creatname" + FakeUtils.gettimeStamp();
        String creatname_en = "creatname_en" + FakeUtils.gettimeStamp();
        Response creatresponse = DepartmentApiobject.cratDepartment(creatname, creatname_en, accessToken);
        deparmentid = creatresponse.path("id") != null ? creatresponse.path("id").toString() : null;
        assertEquals("0", creatresponse.path("errcode").toString());
    }
    @Test
    @Description("创建部门32位")
    void creatDepartment32() {
        String creatname = "abcdefghijabcdefghijabcdefghij12";
        String creatname_en = "creatname_en" + FakeUtils.gettimeStamp();
        Response creatresponse = DepartmentApiobject.cratDepartment(creatname, creatname_en, accessToken);
        deparmentid = creatresponse.path("id") != null ? creatresponse.path("id").toString() : null;
        assertEquals("0", creatresponse.path("errcode").toString());
    }
    @Test
    @Description("创建部门33位")
    void creatDepartment33() {
        String creatname = "abcdefghijabcdefghijabcdefghij123";
        String creatname_en = "creatname_en" + FakeUtils.gettimeStamp();
        Response creatresponse = DepartmentApiobject.cratDepartment(creatname, creatname_en, accessToken);
        deparmentid = creatresponse.path("id") != null ? creatresponse.path("id").toString() : null;
        assertEquals("60001", creatresponse.path("errcode").toString());
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
        Response creatresponse = DepartmentApiobject.cratDepartment(accessToken);
        deparmentid = creatresponse.path("id") != null ? creatresponse.path("id").toString() : null;
        Response listResponse = DepartmentApiobject.listDepartment(deparmentid, accessToken);
        assertEquals("0", listResponse.path("errcode").toString());
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
