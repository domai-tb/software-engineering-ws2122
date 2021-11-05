/**
 * Group: AG1605
 * @author Linus Pieper 108019211982
 * @author Tim Barsch   108019210718
 * 
 */


package HA1;

import java.util.Date;

import HA1.Student.SortKey;

public class Main 
{
    public static void main(String args[])
    {
        StudentList STUDENTS = new StudentList();

        Student[] students = {
            new Student("Linus", "Zebe", 1210, 36, new Date(1)),
            new Student("Ali", "Asdesef", 2021, 22, new Date(20000)),
            new Student("Gustsu", "Jlhe", 3211541, 45, new Date(3000)),
            new Student("Klsh", "JKghe", 155, 178, new Date(400000)),
            new Student("Justin", "Lose", 165, 158, new Date(5000000)),
            new Student("Peter", "Hasd", 15131, 105, new Date(60000000)),
            new Student("Jonas", "Müller", 45, 156, new Date(7000000)),
            new Student("Rudolf", "Geter", 1545, 140, new Date(8000000)),
            new Student("Hans", "Glück", 65468, 77, new Date(9000000)),
            new Student("Bumb", "Marihuna", 135, 65, new Date(1000000))
        };

        for (int i = 0; i < students.length; i++) {
            STUDENTS.add(students[i]);
        }

        System.out.print(STUDENTS.toString() + "\n\n");
        STUDENTS.sort(SortKey.FIRSTNAME);
        System.out.print(STUDENTS.toString() + "\n\n");
        STUDENTS.sort(SortKey.LASTNAME);
        System.out.print(STUDENTS.toString() + "\n\n");
        STUDENTS.sort(SortKey.STUDENT_ID);
        System.out.print(STUDENTS.toString() + "\n\n");
        STUDENTS.sort(SortKey.WEIGHT);
        System.out.print(STUDENTS.toString() + "\n\n");
        STUDENTS.sort(SortKey.BIRTHDAY);
        System.out.print(STUDENTS.toString() + "\n\n");

        StudentList COPY_STUDENTS = new StudentList(STUDENTS);
        COPY_STUDENTS.remove(students[3]);
        System.out.print("Remove by Student from Copy done\n");
        System.out.print(STUDENTS.toString() + "\n\n");
        System.out.print(COPY_STUDENTS.toString() + "\n\n");
        COPY_STUDENTS.remove(3);
        System.out.print("Remove by ID from Copy done\n");
        System.out.print(STUDENTS.toString() + "\n\n");
        System.out.print(COPY_STUDENTS.toString() + "\n\n");
        students[5] = COPY_STUDENTS.remove(5);
        System.out.print("Remove by ID from Copy done\n");
        System.out.print(STUDENTS.toString() + "\n\n");
        System.out.print(COPY_STUDENTS.toString() + "\n\n");
        COPY_STUDENTS.remove(6);
        System.out.print("Remove by ID from Copy done\n");
        System.out.print(STUDENTS.toString() + "\n\n");
        System.out.print(COPY_STUDENTS.toString() + "\n\n");
        COPY_STUDENTS.add(students[5]);
        System.out.print("Add To Copy done\n");
        System.out.print(STUDENTS.toString() + "\n\n");
        System.out.print(COPY_STUDENTS.toString() + "\n\n");
    }
}