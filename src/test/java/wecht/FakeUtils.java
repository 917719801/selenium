package wecht;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FakeUtils {
    private static final Logger logger = LoggerFactory.getLogger(FakeUtils.class);

    public static String gettimeStamp() {
        return String.valueOf(System.currentTimeMillis());

    }

}
