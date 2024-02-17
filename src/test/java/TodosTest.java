import ru.netology.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Морковь", "Сельдерей"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Покупки",
                "Продукты",
                "в 12:00 дня"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetSubtasks() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Морковь", "Сельдерей"};
        Epic epic = new Epic(31, subtasks);

        String[] expected = subtasks;
        String[] actual = epic.getSubtasks();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetId() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Морковь", "Сельдерей"};
        Epic epic = new Epic(31, subtasks);
        Task task = new Task(31);

        int expected = epic.getId();
        int actual = task.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchInTodos() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Морковь", "Сельдерей"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Покупки",
                "Продукты",
                "в 12:00 дня"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInSimpleTaskAndEpic() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Морковь", "Сельдерей"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Покупки",
                "Продукты",
                "в 12:00 дня"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search(simpleTask.getTitle());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingAndEpic() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Морковь", "Сельдерей"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Покупки",
                "Продукты",
                "в 12:00 дня"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Покупки");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Морковь", "Сельдерей"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Покупки",
                "Продукты",
                "в 12:00 дня"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("родителям");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInEpic() {
        SimpleTask simpleTask = new SimpleTask(1, "Написать чек-лист");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Морковь", "Сельдерей"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Покупки",
                "Продукты",
                "в 12:00 дня"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingFirst() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Морковь", "Сельдерей"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Покупки",
                "Продукты",
                "в 12:00 дня"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search(meeting.getTopic());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingSecond() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Морковь", "Сельдерей"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Покупки",
                "Продукты",
                "в 12:00 дня"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search(meeting.getProject());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingThird() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Морковь", "Сельдерей"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Покупки",
                "Продукты",
                "в 12:00 дня"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search(meeting.getStart());

        Assertions.assertArrayEquals(expected, actual);
    }
}