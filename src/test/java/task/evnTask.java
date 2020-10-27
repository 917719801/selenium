package task;

import apiobject.DepartmentApiobject;
import io.restassured.response.Response;

import java.util.ArrayList;

public class evnTask {
    public static void evnClear(String accessToken){
        Response listResponse = DepartmentApiobject.listDepartment("", accessToken);
        ArrayList<Integer> departmentidList = listResponse.path("department.id");
        for (int departmentid : departmentidList) {
            if (1 == departmentid) {
                continue;
            }
            Response deletResponse = DepartmentApiobject.deleteDepartment(departmentid + "", accessToken);
        }

    }
}
