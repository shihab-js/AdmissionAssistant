package shihab.mypro.com.gridviewex.model;

/**
 * Created by shihab on 11/3/2017.
 */

public class menuItem {

    public menuItem(Integer imageID, String name) {
        this.imageID = imageID;
        this.name = name;
    }

    private Integer imageID;
    private String name;

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
