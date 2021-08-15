import org.apache.hc.client5.http.fluent.Content;
import org.apache.hc.client5.http.fluent.Request;

import java.io.IOException;

public class HttpClientDemo {
    public static void main(String[] args) throws IOException {
        String url = "http://localhost:8801";
        Content content = Request.get(url).execute().returnContent();
        String res = content.toString();
        System.out.println(res);
    }
}
