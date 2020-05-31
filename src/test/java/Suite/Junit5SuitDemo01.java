package Suite;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
/*@SelectPackages({
        "testcase01.Junit5Demo02",
        "testcase01.Junit5DemoTest",
})*/
@SelectPackages({
        "testcase01"
})
@IncludePackages({
        "testcase01.Junit5Demo02",
        "testcase01.Junit5DemoTest",

})
public class Junit5SuitDemo01 {

}
