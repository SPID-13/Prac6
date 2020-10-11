package sort;

import java.util.Comparator;

public class Ex1 {
    public static void main(String[] args) {
        int N = 4;
        Student[] students = new Student[N];

        students[0] = new Student(10313, "Иванов Иван", 300);
        students[1] = new Student(10312, "Пупкин Вася", 250);
        students[2] = new Student(9313, "Попов Олег", 288);
        students[3] = new Student(11313, "Михайлов Стас", 249);

        System.out.println("Дано.");
        printStudents(students);

        selectionSort(students, Comparator.comparing(Student::getIDNumber));

        System.out.println("Упражнение 1.");
        printStudents(students);

        System.out.println (7/2);

    }

    public static void selectionSort (Student[] students, Comparator<Student> c) {
        for (int index = 0; index < students.length; index ++) {
            for (int sub = index; sub >= 1; sub--) {
                if (c.compare(students[sub], students[sub - 1]) < 0) {
                    Student temp = students[sub];
                    students[sub] = students[sub - 1];
                    students[sub - 1] = temp;
                }
                else {
                    break;
                }
            }
        }
    }

    private  static void printStudents(Student[] students) {
        int num = 1;
        for (Student student : students) {
            System.out.printf("%1d: %s;\n", num++, student);
        }
    }
}
