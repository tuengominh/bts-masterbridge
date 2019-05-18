package co.masterbridge.website.repository;

import co.masterbridge.website.model.User;
import com.mongodb.client.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import org.bson.Document;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static co.masterbridge.website.util.MongoUtil.doc;
import static com.mongodb.client.model.Filters.eq;

@Repository
public class UserRepositoryMongo implements UserRepository{

    private MongoCollection<Document> userCol;

    public UserRepositoryMongo(@Value("${mongoUri}") String mongoUri) {
        this.userCol = MongoClients.create(mongoUri).getDatabase("masterbridge").getCollection("users");
    }

    @Override
    public Collection<User> getAll() {
        return getUsersFromCursor(userCol.find().iterator());
    }

    @Override
    public User getById(String id) {
        return getUserFromDoc(userCol.find(eq("_id", id)).first());
    }

    @Override
    public void create(User user) {
        userCol.insertOne(getDocFromUser(user));
    }

    @Override
    public void update(String id, User user) {
        userCol.updateOne(eq("_id", id), getDocFromUser(user));
    }

    @Override
    public boolean login(User user) {
        boolean isValid = false;
        for (User userDB : getAll()) {
            if (userDB.getEmail().equals(user.getEmail()) && userDB.getPassword().equals(user.getPassword())) {
                isValid = true;
            }
        }
        return isValid;
    }

    private Collection<User> getUsersFromCursor(MongoCursor<Document> usersCursor) {
        List<User> users = new ArrayList<>();
        while (usersCursor.hasNext()) {
            users.add(getUserFromDoc(usersCursor.next()));
        }
        usersCursor.close();
        return users;
    }

    private User getUserFromDoc(Document doc) {
        return new User(
                doc.getObjectId("_id").toString(),
                doc.getString("email"),
                doc.getString("password"),
                doc.getString("user_name")
        );
    }

    private Document getDocFromUser(User user) {
        return doc()
                .append("email", user.getEmail())
                .append("password", user.getPassword());
    }
}
