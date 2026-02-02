package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HistorySalary {

    private Date date = new Date();
    private String status;
    private Worker worker;
    //private String id;

    public HistorySalary() {

    }

    public HistorySalary(String status, Date date, Worker worker) {
        setStatus(status);
        this.worker = worker;
        this.date = date;
      //  this.id = id;
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

 


    public String getDateString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        return dateFormat.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public final void setStatus(String status) {
        if (status.isEmpty()) {
            throw new IllegalArgumentException("Status must not be empty");
        }
        this.status = status;

    }

    @Override
    public String toString() {
        return String.format("%s %s %d %f %s %s", worker.getId(),
                worker.getName(), worker.getAge(), worker.getSalary(), status, getDateString());
    }

}
