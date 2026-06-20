import java.util.ArrayList;

class Sport {
    public  String name;

    public Sport(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String toString() {
        return name; // Return the name of the sport
    }

}

class SportsCollection {
    private ArrayList<Sport> sportsList = new ArrayList<>();

    public SportsCollection() {
        sportsList.add(new Sport("Football"));
        sportsList.add(new Sport("Handball"));
        sportsList.add(new Sport("Basketball"));
    }

    public ArrayList<Sport> getSportsList() {
        return sportsList;
    }
}