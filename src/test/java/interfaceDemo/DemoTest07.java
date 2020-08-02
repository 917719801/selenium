package interfaceDemo;

import apiobject.DepartmentApiobject;
import apiobject.TokenHelper;
import com.sun.org.glassfish.gmbal.Description;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import task.evnTask;
import wecht.FakeUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;
/*
并发测试
 */


public class DemoTest07 {
    private static final Logger logger = LoggerFactory.getLogger(DemoTest07.class);
    static String accessToken;
    static String deparmentid;

    @BeforeAll
    public static void getaccessToken() {
        accessToken = TokenHelper.getAccesstoken();
    }
    @BeforeEach

    void evnClear() {
        evnTask.evnClear(accessToken);

    }

    @RepeatedTest(10)
    @Description("创建部门 线程测试")
    @Execution(CONCURRENT)
    void creatDepartment() {
        String creatname = "creatname";
        String creatname_en = "creatname_en";
        Response creatresponse = DepartmentApiobject.cratDepartment(creatname, creatname_en, accessToken);
        deparmentid = creatresponse.path("id") != null ? creatresponse.path("id").toString() : null;
        assertEquals("0", creatresponse.path("errcode").toString());
    }


}
