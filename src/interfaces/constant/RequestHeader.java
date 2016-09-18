package interfaces.constant;

import java.util.HashMap;
import java.util.Map;

public class RequestHeader {
	public final static Map<String, String> head = new HashMap<>();
	static{
		head.put("accept", "*/*");
		head.put("connection", "Keep-Alive");
		head.put("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		head.put("Charset", "UTF-8");
	}
}
