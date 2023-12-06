import java.util.ArrayList;
import java.util.Scanner;

class TaskListProgram {
    private ArrayList<String> tasks;

    public TaskListProgram() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public void markCompleted(int taskIndex) {
        if (isValidIndex(taskIndex)) {
            String completedTask = tasks.remove(taskIndex - 1);
            System.out.println("Task completed: " + completedTask);
        }
    }

    public void removeTask(int taskIndex) {
        if (isValidIndex(taskIndex)) {
            String removedTask = tasks.remove(taskIndex - 1);
            System.out.println("Task removed: " + removedTask);
        }
    }

    public void viewCompletedTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No completed tasks found.");
        } else {
            System.out.println("Completed Tasks:");
            for (String task : tasks) {
                System.out.println("- " + task);
            }
        }
    }

    private boolean isValidIndex(int index) {
        return index > 0 && index <= tasks.size();
    }

    public static void main(String[] args) {
        TaskListProgram taskList = new TaskListProgram();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("\nTask List Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task Completed");
        System.out.println("4. Remove Task");
        System.out.println("5. View Completed Tasks");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter task to add: ");
                String newTask = scanner.nextLine();
                taskList.addTask(newTask);
                break;
            case 2:
                taskList.viewTasks();
                break;
            case 3:
                System.out.print("Enter task index to mark as completed: ");
                int completedIndex = scanner.nextInt();
                taskList.markCompleted(completedIndex);
                break;
            case 4:
                System.out.print("Enter task index to remove: ");
                int removeIndex = scanner.nextInt();
                taskList.removeTask(removeIndex);
                break;
            case 5:
                taskList.viewCompletedTasks();
                break;
            case 0:
                System.out.println("Exiting Task List Program. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
