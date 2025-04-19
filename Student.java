package model;

public class Student {
    private String prn;
    private String name;
    private String dob;
    private float marks;

    public Student(String prn, String name, String dob, float marks) {
        this.prn = prn;
        this.name = name;
        this.dob = dob;
        this.marks = marks;
    }

    public String getPrn() { return prn; }
    public String getName() { return name; }
    public String getDob() { return dob; }
    public float getMarks() { return marks; }

    public void setName(String name) { this.name = name; }
    public void setDob(String dob) { this.dob = dob; }
    public void setMarks(float marks) { this.marks = marks; }

    @Override
    public String toString() {
        return "PRN: " + prn + ", Name: " + name + ", DoB: " + dob + ", Marks: " + marks;
    }
}
