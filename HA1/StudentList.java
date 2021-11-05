/**
 * Group: AG1605
 * @author Linus Pieper 108019211982
 * @author Tim Barsch   108019210718
 * 
 */


package HA1;


import java.util.ArrayList;
import java.util.Date;


public class StudentList
{
    private ArrayList<Student> Students;

    // constructors
    StudentList() {
        this.Students = new ArrayList<Student>();
    }

    StudentList(StudentList StudentList) {
        this.Students = new ArrayList<Student>();

        for (Student s : StudentList.Students) {
            Student TempStudent = new Student(s.getFirstname(), 
                                              s.getLastname(), 
                                              s.getStudentID(), 
                                              s.getWeigth(), 
                                              new Date(s.getBirthday().getTime())); 
            this.Students.add(TempStudent);
        }
    }

    /**
     * Adds student to the list, if the list does not yet contain a
     * student with the same studentId. Returns true on success and false otherwise.
     * 
     * @param student - The Student to be added.
     * 
     * @return <b>success</b> - True if student was successfully added to the list. 
     */
    public boolean add(Student student) {
        boolean success = false;

        if (!containsId(student.getStudentID())) {
            Students.add(student);
            success = true;
        }

        return success;
    }

    /**
     * Removes the student with the studentId of student from
     * the list. Returns true if an entry was deleted and false otherwise.
     * 
     * @param student - The Student to be removed.
     * 
     * @return <b>success</b> - True if student was successfully removed from the list. 
     */
    public boolean remove(Student student) {
        boolean success = false;

        if (containsId(student.getStudentID())) {
            Students.remove(student);
            success = true;
        }

        return success;
    }

    /**
     * Removes the student at position pos from the list. Returns the corresponding 
     * student if an entry was deleted and null in case pos is too small / big.
     * 
     * @param pos - The position in the list.
     * 
     * @return <b>removedStudent</b> - The removed student or null.
     */
    public Student remove(int pos) {
        Student removedStudent = null;

        if (0 <= pos && pos < size()) {
            removedStudent = get(pos);
            Students.remove(pos);
        }

        return removedStudent;
    }

    /**
     * Returns the student at position pos or null in case pos is too small / big.
     * 
     * @param pos - The position in the list.
     * 
     * @return <b>student</b> - The student at this position or null.
     */
    public Student get(int pos) {
        Student student = null;

        if (0 <= pos && pos < size()) {
            student = Students.get(pos);
        }

        return student;
    }

    /**
     * Returns a (possibly empty) list of positions, corresponding to the 
     * students in the list whose lastname matches lastname.
     * 
     * @param lastname - The lastname to be searched.
     * 
     * @return <b>lastnameList</b> - A list of positions of matched students. 
     */
    public ArrayList<Integer> findLastname(String lastname) {
        ArrayList<Integer> lastnameList = new ArrayList<Integer>();

        for (int i = 0; i < size(); i++) {
            if (Students.get(i).getLastname() == lastname) {
                lastnameList.add(i);
            }
        }

        return lastnameList;
    }

    /**
     * Returns a (possibly empty) list of positions, corresponding to the 
     * students in the list whose firstname matches firstname.
     * 
     * @param firstname - The firstname to be searched.
     * 
     * @return <b>firstnameList</b> - A list of positions of matched students. 
     */
    public ArrayList<Integer> findFirstname(String firstname) {
        ArrayList<Integer> firstnameList = new ArrayList<Integer>();

        for (int i = 0; i < size(); i++) {
            if (Students.get(i).getFirstname() == firstname) {
                firstnameList.add(i);
            }
        }

        return firstnameList;
    }

    /**
     * Should the list contain a student with studentId studentId,
     * return its position in the list, else return -1.
     * 
     * @param studentId - The studentID to be searched.
     * 
     * @return <b>position</b> - The positionn of the student or -1.
     */
    public int findStudentId(long studentId) {
        int position = -1;

        for (int i = 0; i < size(); i++) {
            if (Students.get(i).getStudentID() == studentId) {
                position = i;
                break;
            }
        }

        return position;
    }

    /**
     * Return the number of students inside the list.
     * 
     * @return <b>bize</b> - The number of students.
     */
    public int size() {
        return Students.size();
    }

    /**
     * Returns true if the list contains the student with studentId studentId. 
     * Otherwise return false.
     * 
     * @param studentId - The studentID to be searched.
     * 
     * @return <b>contains</b> - True if the list contains the studentID.
     */
    public boolean containsId(final long studentId) {
        boolean contains = false;

        for (Student s : Students) {
            if (s.getStudentID() == studentId) {
                contains = true;
                break;
            }
        }

        return contains;
    }

    public void sort(Student.SortKey key) {
        // search Student with "smallest" keyword(beginning at the end),
        // add to tmpList and then update original list with tmpList
        int n = size();
        ArrayList<Student> tmpList = new ArrayList<Student>();

        for (int i = n-1; i >= 0 ; i--)
        {
            Student tmpStudent = Students.get(i);
            for (int j = i-1; j >= 0; j--)
            {
                switch (key) {
                    case FIRSTNAME:
                        if (tmpStudent.getFirstname().compareTo(Students.get(j).getFirstname()) > 0)
                        {
                            tmpStudent = Students.get(j);
                        }
                        break;

                    case LASTNAME:
                        if (tmpStudent.getLastname().compareTo(Students.get(j).getLastname()) > 0)
                        {
                            tmpStudent = Students.get(j);
                        }
                        break;

                    case STUDENT_ID:
                        if (tmpStudent.getStudentID() > Students.get(j).getStudentID())
                        {
                            tmpStudent = Students.get(j);
                        }
                        break;

                    case WEIGHT:
                        if (tmpStudent.getWeigth() > Students.get(j).getWeigth())
                        {
                            tmpStudent = Students.get(j);
                        }
                        break;

                    case BIRTHDAY:
                        if (tmpStudent.getBirthday().after(Students.get(j).getBirthday()))
                        {
                            tmpStudent = Students.get(j);
                        }
                        break;
                    
                    default:
                        return;
                }        
            }                
            tmpList.add(tmpStudent);
            Students.remove(tmpStudent);
        }
        Students = tmpList;
    }

    @Override
    public String toString() {
        String studentListAsString = "";

        for (Student s : Students) {
            studentListAsString += s.toString() + "\n";
        }

        return studentListAsString;
    }
}
