package HA1;


import java.util.ArrayList;


public class StudentList
{
    // constructors
    StudentList() {

        // TODO

    }

    StudentList(StudentList StudentList) {

        // TODO

    }

    /**
     * Adds student to the list, if the list does not yet contain a
     * student with the same studentId. Returns true on success and false otherwise.
     * 
     * @param student - The Student to be added.
     * 
     * @return <b>success</b> - True if student was successfully added to the list. 
     */
    boolean add(Student student) {
        boolean success = false;

        // TODO

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
    boolean remove(Student student) {
        boolean success = false;

        // TODO

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
    Student remove(int pos) {
        Student removedStudent = null;

        // TODO

        return removedStudent;
    }

    /**
     * Returns the student at position pos or null in case pos is too small / big.
     * 
     * @param pos - The position in the list.
     * 
     * @return <b>student</b> - The student at this position or null.
     */
    Student get(int pos) {
        Student student = null;

        // TODO

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
    ArrayList<Integer> findLastname(String lastname) {
        ArrayList<Integer> lastnameList = new ArrayList<Integer>();

        // TODO

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
    ArrayList<Integer> findFirstname(String firstname) {
        ArrayList<Integer> firstnameList = new ArrayList<Integer>();

        // TODO

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
    int findStudentId(long studentId) {
        int position = -1;

        // TODO

        return position;
    }

    /**
     * Return the number of students inside the list.
     * 
     * @return <b>bize</b> - The number of students.
     */
    int size() {
        int size = 0;

        // TODO

        return size;
    }

    /**
     * Returns true if the list contains the student with studentId studentId. 
     * Otherwise return false.
     * 
     * @param studentId - The studentID to be searched.
     * 
     * @return <b>contains</b> - True if the list contains the studentID.
     */
    private boolean containsId(final long studentId) {
        boolean contains = false;

        // TODO

        return contains;
    }

    @Override
    public String toString() {
        String studentListAsString = "";

        // TODO

        return studentListAsString;
    }
}
