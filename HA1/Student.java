/**
 * Group: AG1605
 * @author Linus Pieper 108019211982
 * @author Tim Barsch   108019210718
 * 
 */


 package HA1;

import java.util.Date;

public class Student 
{
    private String firstname;
    private String lastname; 
    private long studentID;
    private double weigth;
    private Date birthday;

    public enum SortKey {FIRSTNAME, LASTNAME, STUDENT_ID, WEIGHT, BIRTHDAY}

    // constructors
    Student() {
        this(null, null, 0, 0, new Date(0));
    }

    Student(String firstname, String lastname , long studentID, double weigth, Date birthday) {   
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentID = studentID;
        this.weigth = weigth;
        this.birthday = birthday;
    }

    // getter
    public Date getBirthday() {
        return birthday;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public long getStudentID() {
        return studentID;
    }
    public double getWeigth() {
        return weigth;
    }

    // setter
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    private void setStudentID(long studentID) {
        this.studentID = studentID;
    }
    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

    // methods
    public String getName() {
        String name = getFirstname() + " " + getLastname();
        return name;
    }

    @Override
    public String toString() {
        String studentAsString = getName() + " " +
                                 getStudentID() + " " + 
                                 getWeigth() + " " +
                                 getBirthday();
        return studentAsString;
    }
}
