package jhunions.isaiahgao.common;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	private static final ObjectMapper json = new ObjectMapper();

    public static ObjectMapper getJson() {
        return json;
    }

}
