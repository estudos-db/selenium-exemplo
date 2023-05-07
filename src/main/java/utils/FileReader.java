package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileReader {
    private static final String PATH_PROPERTIES = System.getProperty("user.dir")
            + File.separator + "src" + File.separator + "main" +
            File.separator + "resources" + File.separator + "Properties" + File.separator;
    public Properties getProperties(String name) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = null;

        try{
            File file = new File(PATH_PROPERTIES + name + ".properties");
            inputStream = new FileInputStream(file);
            properties.load(inputStream);
            return properties;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            assert inputStream != null;
            inputStream.close();
        }
        return properties;
    }
}
