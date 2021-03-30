import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Student implements Comparable<Student> {
    private String name;
    private double CGPA;
    private int id;

    public Student (String name, double CGPA, int id) {
        this.name = name;
        this.CGPA = CGPA;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return CGPA;
    }

    public int getid() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public void setID(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Student student) {
        if (Integer.compare((int) (this.CGPA * 100), (int) (student.CGPA * 100)) == 0) {
            if (this.name.compareTo(student.name) == 0) {
                return this.id < student.id ? -1 : 1;
            } else {
                // test
                // System.out.println("Name Compare");
                return this.name.compareTo(student.name);
            }
        } else {
            // test
            // System.out.println("CGPA Compare");
            return Double.compare(this.CGPA, student.CGPA) < 0 ? 1 : -1;
        }
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", CGPA: " + Double.toString(this.CGPA) + ", id: " + this.id;
    }
}

class Priorities {
    List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> queue = new PriorityQueue<Student>();

        for (int i = 0; i < events.size(); i++) {
            String event = events.get(i);

            String[] tokens = event.split(" ");

            if (tokens[0].equals("ENTER")) {
                queue.add(new Student(tokens[1], Double.parseDouble(tokens[2]), Integer.parseInt(tokens[3])));
                // test
                // System.out.println(queue.toString());
            } else {
                queue.poll();
            }
        }

        List<Student> list = new ArrayList<Student>();
        
        for (Student student : queue) {
            list.add(student);
        }

        Collections.sort(list);
        
        return list;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}