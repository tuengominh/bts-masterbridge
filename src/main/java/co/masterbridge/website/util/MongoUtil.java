package co.masterbridge.website.util;

import org.bson.Document;

public class MongoUtil {

    public static Document doc() {
        return new Document();
    }

    public static Document doc(String key, Object value) {
        return new Document(key, value);
    }

    public static void appendIfNotNull(Document document, String property, Object value) {
        if (value != null) {
            document.append(property, value);
        }
    }
}
