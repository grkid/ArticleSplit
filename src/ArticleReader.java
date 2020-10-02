import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ArticleReader {
    //TODO

    private String result;

    public ArticleReader(String fileName)
            throws IOException
    {
        FileInputStream fis=new FileInputStream(fileName);
        byte[] b;
        b=fis.readAllBytes();
        result= Arrays.toString(b);
    }

    public String getResult() {
        return result;
    }
}
