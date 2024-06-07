
public class DigitalVideoDisc {
    //8
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    //15
    private static int nbDigitalVideoDiscs = 0;
    private int id;

    
    //9
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    //15
    public void setTitle(String title) {
        this.title = title;
    }


    //16
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    public int getId() {
        return id;
    }

    //10 constructor 
    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs += 1;
        id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs += 1;
        id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        nbDigitalVideoDiscs += 1;
        id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs += 1;
        id = nbDigitalVideoDiscs;
    }

}

