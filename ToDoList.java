package saiket_Projects;
import java.util.ArrayList;
import java.util.Scanner;

	// Task class representing a single to-do item
	class Task {
	    private String title;
	    private boolean isCompleted;

	    public Task(String title) {
	        this.title = title;
	        this.isCompleted = false;
	    }

	    public void markAsComplete() {
	        isCompleted = true;
	    }

	    public String getStatus() {
	        return isCompleted ? "Completed" : "Pending";
	    }

	    public String getTitle() {
	        return title;
	    }

	    @Override
	    public String toString() {
	        return "[ " + getStatus() + " ] " + title;
	    }
	}

	// Main application class
	public class ToDoList {
	    private static ArrayList<Task> taskList = new ArrayList<>();
	    private static Scanner scanner = new Scanner(System.in);

	    // Add a new task
	    public static void addTask() {
	        System.out.print("Enter task title: ");
	        scanner.nextLine(); // Consume newline
	        String title = scanner.nextLine();
	        Task task = new Task(title);
	        taskList.add(task);
	        System.out.println("Task added successfully.");
	    }

	    // Mark a task as complete
	    public static void markTaskAsComplete() {
	        displayTasks();
	        System.out.print("Enter task number to mark as complete: ");
	        int index = scanner.nextInt();

	        if (index >= 1 && index <= taskList.size()) {
	            taskList.get(index - 1).markAsComplete();
	            System.out.println("Task marked as completed.");
	        } else {
	            System.out.println("Invalid task number.");
	        }
	    }

	    // Display all tasks
	    public static void displayTasks() {
	        System.out.println("\n--- To-Do List ---");
	        if (taskList.isEmpty()) {
	            System.out.println("No tasks found.");
	        } else {
	            for (int i = 0; i < taskList.size(); i++) {
	                System.out.println((i + 1) + ". " + taskList.get(i));
	            }
	        }
	    }

	    // Main method with menu
	    public static void main(String[] args) {
	        int choice;

	        do {
	            System.out.println("\n *****To-Do List Menu *****");
	            System.out.println("1. Add Task");
	            System.out.println("2. Mark Task as Complete");
	            System.out.println("3. View Tasks");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice (1-4): ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    addTask();
	                    break;
	                case 2:
	                    markTaskAsComplete();
	                    break;
	                case 3:
	                    displayTasks();
	                    break;
	                case 4:
	                    System.out.println("Exiting From The To-Do List. Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }

	        } while (choice != 4);
	    }
	}



