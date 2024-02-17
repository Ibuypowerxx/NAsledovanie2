import ru.netology.Epic;
import ru.netology.Meeting;
import ru.netology.SimpleTask;
import ru.netology.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldFindQueryInSimpleTaskTrue() {
        Task simpleTask = new SimpleTask(1, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInSimpleTaskFalse() {
        Task simpleTask = new SimpleTask(1, "Позвонить родителям");

        boolean expected = false;
        boolean actual = simpleTask.matches("молоко");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInEpicTrue() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Морковь", "Сельдерей"};
        Task epic = new Epic(31, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Яйца");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInEpicFalse() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Морковь", "Сельдерей"};
        Task epic = new Epic(31, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("яйца");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInMeetingTrue() {
        Task meeting = new Meeting(
                17,
                "Покупки",
                "Продукты",
                "в 12:00 дня"
        );

        boolean expected = true;
        boolean actual = meeting.matches("ы");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInMeetingFalse() {
        Task meeting = new Meeting(
                17,
                "Покупки",
                "Продукты",
                "в 12:00 дня"
        );

        boolean expected = false;
        boolean actual = meeting.matches("дня");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInTaskFalse() {
        Task task = new Task(31);

        boolean expected = false;
        boolean actual = task.matches("яйца");

        Assertions.assertEquals(expected, actual);
    }
}