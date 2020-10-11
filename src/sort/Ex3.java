package sort;

import java.util.Comparator;

public class Ex3 {
    public static void main(String[] args) {
        int N = 4;
        Student[] students1 = new Student[N];

        students1[0] = new Student(10313, "Иванов Иван", 300);
        students1[1] = new Student(10312, "Пупкин Вася", 250);
        students1[2] = new Student(9313, "Попов Олег", 288);
        students1[3] = new Student(11313, "Михайлов Стас", 249);

        Student[] students2 = new Student[N];

        students2[0] = new Student(10311, "Орлова Татьяна", 299);
        students2[1] = new Student(10314, "Лебедева Ольга", 250);
        students2[2] = new Student(9314, "Александрова Галина", 278);
        students2[3] = new Student(11312, "Третьякова Анастасия", 231);

        Student[] students = new Student[N+N];

        System.out.println("Дано");
        System.out.println("Список №1");
        printStudents(students1);
        System.out.println("Список №2");
        printStudents(students2);

        for (int i = 0; i < N; i++) {
            students[i] = students1[i];
        }
        for (int i = 0; i < N; i++) {
            students[i+N] = students2[i];
        }

        System.out.println("Совмещенный список");
        printStudents(students);

        mergeSort(students, 0, N+N-1);

        System.out.println("Упражнение 3.");
        printStudents(students);

    }

    public static void mergeSort (Student[] students, int left, int right) {
        if (right <= left)
            return;

        int middle = (left + right) / 2;

        mergeSort (students, left, middle);
        mergeSort (students, middle+1, right);

        merge (students, left, middle, right, Comparator.comparing(Student::getPoint));
    }

    public static void merge (Student[] students, int left, int middle, int right, Comparator<Student> c) {
        int lengthLeft = middle - left + 1;
        int lengthRight = right - middle;

        Student[] studentsLeft = new Student [lengthLeft];
        Student[] studentsRight = new Student [lengthRight];

        for (int i = 0; i < lengthLeft; i++)
            studentsLeft[i] = students [left + i];
        for (int i = 0; i < lengthRight; i++)
            studentsRight[i] = students [middle + i + 1];

        int indexLeft = 0;
        int indexRight = 0;

        for (int i = left; i < right + 1; i++) {
            if (indexLeft < lengthLeft && indexRight < lengthRight) {
                if (c.compare(studentsLeft[indexLeft], studentsRight[indexRight]) > 0) {
                    students[i] = studentsLeft[indexLeft];
                    indexLeft++;
                }
                else {
                    students[i] = studentsRight[indexRight];
                    indexRight++;
                }
            }

            else if (indexLeft < lengthLeft) {
                students[i] = studentsLeft[indexLeft];
                indexLeft++;
            }

            else if (indexRight < lengthRight) {
                students [i] = studentsRight[indexRight];
                indexRight++;
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
