package co.masterbridge.website.util;

import org.bson.Document;

public class MongoUtil {

    public static Document doc() {
        return new Document();
    }

    public static Document doc(String key, Object value) {
        return new Document(key, value);
    }
}
