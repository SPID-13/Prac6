package sort;

import java.util.Comparator;

public class SortingStudentsByGPA {
    public static void main(String[] args) {
        int N = 4;
        Student[] students = new Student[N];

        students[0] = new Student(10313, "Иванов Иван", 300);
        students[1] = new Student(10312, "Пупкин Вася", 250);
        students[2] = new Student(9313, "Попов Олег", 288);
        students[3] = new Student(11313, "Михайлов Стас", 249);

        System.out.println("Дано.");
        printStudents(students);

        quickSort(students, 0, N-1, Comparator.comparing(Student::getPoint));

        System.out.println("Упражнение 2.");
        printStudents(students);

    }

    public static void quickSort (Student[] students, int low, int high, Comparator<Student> c) {
        if (students.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        Student pivot = students[middle];
        int i = low;
        int j = high;

        while (i <= j) {
            while (c.compare (students[i], pivot) > 0) {
                i++;
            }

            while (c.compare (students[j], pivot) < 0) {
                j--;
            }

            if (i <= j) {
                Student temp = students [i];
                students [i] = students [j];
                students [j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort (students, low, j, Comparator.comparing(Student::getPoint));

        if (high > i)
            quickSort (students, i, high, Comparator.comparing(Student::getPoint));

    }

    private  static void printStudents(Student[] students) {
        int num = 1;
        for (Student student : students) {
            System.out.printf("%1d: %s;\n", num++, student);
        }
    }
}

