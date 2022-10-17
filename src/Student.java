import java.util.Date;

public class Student {
    String id;
    String name;
    Date dob;
    String address;
    int fees;

    public Student(String name, Date dob, String address, int fees) {
        this.id = generateNewAdmissionId();
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.fees = fees;
    }

    private String generateNewAdmissionId() {
        int series = 18;
        char state = 'T';
        char alphaNew = 'A';
        return String.valueOf(series) + state + getRandom() + alphaNew + getRandom();
    }
    private int getRandom(){
        StringBuilder threeRand = new StringBuilder();
        int counter = 0;
        while (counter < 3){
            threeRand.append((int)Math.floor(Math.random() * 10));
            counter++;
        }
        return Integer.parseInt(threeRand.toString());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public int getFees() {
        return fees;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", fees=" + fees +
                '}';
    }
}
