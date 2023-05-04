import org.example.Epic;
import org.example.Meeting;
import org.example.SimpleTask;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class TasksTest {
    @Test
    public void ResultWhenQueryNotInTitle() {
        SimpleTask task = new SimpleTask(1, "Купить молоко");
        String query = "пора";
        boolean expected = false;
        boolean actual = task.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ResultTrueWhenQueryInTopic() {
        Meeting meeting = new Meeting(1, "Встреча с родителями", "шашлыки", "09.05.2023");
        String query = "Встреча";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ResultTrueWhenQueryInProject() {
        Meeting meeting = new Meeting(1, "Встреча с родителями", "шашлыки", "09.05.2023");
        String query = "шашлыки";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ResultFalseWhenQueryNotInTopicInProject() {
        Meeting meeting = new Meeting(1, "Встреча с родителями", "шашлыки", "09.05.2023");
        String query = "баня";
        boolean expected = false;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ResultTrueWhenQueryInTitle() {
        SimpleTask task = new SimpleTask(1, "сдать хвосты");
        String query = "хвосты";
        boolean expected = true;
        boolean actual = task.matches(query);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void ResultFalseWhenQueryNotInSubtasks() {
        Epic epic = new Epic(1, new String[]{"купить скотч", "вынести мусор", "сходить к Ире"});
        String query = "Наташе";
        boolean expected = false;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);

    }
}
