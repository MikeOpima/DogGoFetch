package org.example.doggofetch.pojo;

/**
 * Database Item Class
 * @author katkoe
 * 5apr26
 */
public class DatabaseItem {
    private int id;

    /** pass id for selected item
     * @param id
     */
    public DatabaseItem(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

}
