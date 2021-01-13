package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonLibs {

    public String readPropertyFromFile(String fileName, String propertyName) throws IOException {
        FileInputStream fileInputStream = null;
        Properties properties = null;

        try {
            fileInputStream = new FileInputStream(fileName);
            properties = new Properties();
            properties.load(fileInputStream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
        }

        assert properties != null;
        return properties.getProperty(propertyName);
    }
}
