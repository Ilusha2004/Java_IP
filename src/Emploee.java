public class Emploee {

    String Name;
    String Job;

    Emploee(String Name, String Job){
        this.Job = Job;
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }

    @Override
    public String toString() {
        return "Emploee [Name=" + Name 
                + ", Job=" + Job + "]";
    }

}
