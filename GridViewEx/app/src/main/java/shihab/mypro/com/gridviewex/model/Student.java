package shihab.mypro.com.gridviewex.model;

/**
 * Created by shihab on 11/14/2017.
 */

public class Student {
    private  int id;
    private  String name;
    private String password;


    public Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
