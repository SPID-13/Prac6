package sort;

import java.util.Comparator;

public class Student implements Comparable<Student> {
    private final int IDNumber;
    private final String Name;
    private final int Point;

    public Student(int IDNumber, String Name, int Point) {
        this.IDNumber = IDNumber;
        this.Name = Name;
        this.Point = Point;
    }

    public int getIDNumber() {
        return IDNumber;
    }

    public String getName() {
        return Name;
    }

    public int getPoint() {
        return Point;
    }

    public String toString() {
        return ("< " + IDNumber + " > " + Name + " - " + Point);
    }

    @Override
    public int compareTo(Student o) {
        return (this.Name.compareTo(o.Name));
    }
}



