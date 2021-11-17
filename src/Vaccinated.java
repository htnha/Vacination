public class Vaccinated {
    int id;
    int personId;
    String vaccineType;
    String vaccineDate;
    int vaccineCounter;

    public Vaccinated(int id, int personId, String vaccineType, String vaccineDate, int vaccineCounter) {
        this.id = id;
        this.personId = personId;
        this.vaccineType = vaccineType;
        this.vaccineDate = vaccineDate;
        this.vaccineCounter = vaccineCounter;
    }
}
