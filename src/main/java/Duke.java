import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    enum Command {
        BYE, LIST, DONE, TODO, DEADLINE, EVENT, DELETE
    }

    public static void main(String[] args) {
        ArrayList<Task> ls = new ArrayList<>();
        String horizontalDiv = "____________________________________________________________";
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);

        System.out.println(horizontalDiv);
        System.out.println("Hello! I'm Dude\n" + "What can I do for you today?");
        System.out.println(horizontalDiv);
        WhileLoop:
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String[] arr = str.split(" ", 2);

            String upperCaseCmd = arr[0].toUpperCase().trim();
            Command cmd = Command.valueOf(upperCaseCmd);

            switch (cmd) {
            case BYE:
                System.out.println(horizontalDiv);
                System.out.println("Bye! Hope to see you again soon!");
                System.out.println(horizontalDiv);
                break WhileLoop;

            case LIST:
                System.out.println(horizontalDiv);
                if (ls.isEmpty()) {
                    System.out.println("Congratulations! You have currently no task.");
                } else {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < ls.size(); i++) {
                        Task task = ls.get(i);
                        int num = i + 1;
                        System.out.println(num + ". " + task.toString());
                    }
                }
                System.out.println(horizontalDiv);
                break;

            case DONE:
                try {
                    int numToBeMarkedAsDone = Integer.parseInt(str.substring(str.length() - 1)) - 1;
                    Task tsk = ls.get(numToBeMarkedAsDone);
                    tsk.markAsDone();
                    ls.set(numToBeMarkedAsDone, tsk);
                    System.out.println(horizontalDiv);
                    System.out.println("Nice! I've marked this task as done: ");
                    System.out.println(tsk.toString());
                    System.out.println(horizontalDiv);
                } catch (Exception ex) {
                    System.out.println(horizontalDiv);
                    System.out.println("Sorry! The number does not exist in the list!");
                    System.out.println(horizontalDiv);
                }
                break;

            case TODO:
                try {
                    Task newTask = new Todo(arr[1]);
                    ls.add(newTask);
                    System.out.println(horizontalDiv);
                    System.out.println("Got it. I've added this task: \n" + newTask.toString());
                    if(ls.size() > 1) {
                        System.out.println("Now you have " + ls.size() + " tasks in the list.");
                    } else {
                        System.out.println("Now you have " + ls.size() + " task in the list.");
                    }
                    System.out.println(horizontalDiv);
                } catch (Exception ex) {
                    System.out.println(horizontalDiv);
                    System.out.println("Sorry! The description of todo cannot be empty!!");
                    System.out.println(horizontalDiv);
                }
                break;

            case DEADLINE:
                try {
                    String secondStr = arr[1];
                    String[] arrOfStr = secondStr.split(" /by ", 2);
                    try {
                        Task newTask = new Deadline(arrOfStr[0], arrOfStr[1]);
                        ls.add(newTask);
                        System.out.println(horizontalDiv);
                        System.out.println("Got it. I've added this task: \n" + newTask.toString());
                        if(ls.size() > 1) {
                            System.out.println("Now you have " + ls.size() + " tasks in the list.");
                        } else {
                            System.out.println("Now you have " + ls.size() + " task in the list.");
                        }
                        System.out.println(horizontalDiv);
                    } catch (Exception ex) {
                        System.out.println(horizontalDiv);
                        System.out.println("Sorry! Please enter a date for the deadline using the command '/by'!");
                        System.out.println(horizontalDiv);
                    }
                } catch (Exception ex) {
                    System.out.println(horizontalDiv);
                    System.out.println("Sorry! The description of deadline cannot be empty!");
                    System.out.println(horizontalDiv);
                }
                break;

            case EVENT:
                try {
                    String secondStr = arr[1];
                    String[] arrOfStr = secondStr.split(" /at ", 2);
                    try {
                        Task newTask = new Event(arrOfStr[0], arrOfStr[1]);
                        ls.add(newTask);
                        System.out.println(horizontalDiv);
                        System.out.println("Got it. I've added this task: \n" + newTask.toString());
                        if (ls.size() > 1) {
                            System.out.println("Now you have " + ls.size() + " tasks in the list.");
                        } else {
                            System.out.println("Now you have " + ls.size() + " task in the list.");
                        }
                        System.out.println(horizontalDiv);
                    } catch (Exception ex) {
                        System.out.println(horizontalDiv);
                        System.out.println("Sorry! Please enter a duration for the event using the command '/at'!");
                        System.out.println(horizontalDiv);
                    }
                } catch (Exception ex) {
                    System.out.println(horizontalDiv);
                    System.out.println("Sorry! The description of event cannot be empty!");
                    System.out.println(horizontalDiv);
                }
                break;
            case DELETE:
                try {
                    int numToBeDeleted = Integer.parseInt(str.substring(str.length() - 1)) - 1;
                    Task tsk = ls.get(numToBeDeleted);
                    ls.remove(numToBeDeleted);
                    System.out.println(horizontalDiv);
                    System.out.println("Successfully deleted this task:");
                    System.out.println(tsk.toString());
                    if (ls.size() > 1) {
                        System.out.println("Now you have " + ls.size() + " tasks in the list.");
                    } else {
                        System.out.println("Now you have " + ls.size() + " task in the list.");
                    }
                    System.out.println(horizontalDiv);
                } catch (Exception ex) {
                    System.out.println(horizontalDiv);
                    System.out.println("Sorry! The number to be deleted does not exist in the list!");
                    System.out.println(horizontalDiv);
                }
                break;
            default:
                System.out.println(horizontalDiv);
                System.out.println("Sorry! But I don't know what that means!");
                System.out.println(horizontalDiv);
            }
        }
    }
}
