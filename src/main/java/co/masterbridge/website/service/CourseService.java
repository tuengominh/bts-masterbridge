package co.masterbridge.website.service;

import co.masterbridge.website.model.Course;
import co.masterbridge.website.model.CourseSearch;
import co.masterbridge.website.repository.CourseRepository;
import co.masterbridge.website.repository.CourseRepositoryMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CourseService {

    private CourseRepository courseRepository;
    private CourseRepositoryMongo courseRepositoryMongo;

    @Autowired
    public CourseService (CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Collection<Course> getAll() {
        return courseRepository.getAll();
    }

    public Collection<Course> find(CourseSearch courseSearch) {
        return courseRepository.find(courseSearch);
    }
    //TODO: store CourseSearch => MongoDB (?)

    public Course createGame() {

        Course сourse = new Course();

        courseRepositoryMongo.create(course);

        return course;
    }

    public void joinGame(GameUser gameUser) {

        Game game = gameRepo.getById(gameUser.getGameId());
        game.join(gameUser.getUsername());
    }

    public Card pickCard(GameUser gameUser) {

        Game game = gameRepo.getById(gameUser.getGameId());
        return game.pickCard(gameUser.getUsername());
    }

    public Collection<Game> getAllGames() {

        return gameRepo.getAll();
    }

    public Game getGameById(long id) {

        return gameRepo.getById(id);
    }

    public Collection<Game> find(GameSearch gameSearch) {

        return gameRepo.find(gameSearch);
    }
}
