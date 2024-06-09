package hust.soict.globalict.aims.media;

import java.util.Comparator;

public abstract class Media {
    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }

    //constructor
    public Media() {
        
    }
    public Media(String title) {
        this.title = title;
    }

    public Media(String title, String category, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    //ex15
    @Override //override equals method
    public boolean equals (Object o) {
        if (o instanceof Media) {
            return ((Media)o).title == this.title;
        }
        return false;
    }
    
    //ex17
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	public abstract boolean isMatch(String title);

}