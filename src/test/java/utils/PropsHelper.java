package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropsHelper {
    private static Properties props;

    public static Properties getProps() throws IOException {
        if (props == null)
            initProps();
        return props;
    }

    private static void initProps() throws IOException {
        props = new Properties();
        props.load(
                new InputStreamReader(
                        new FileInputStream("src/test/resources/application.properties")
                )
        );
    }
}
