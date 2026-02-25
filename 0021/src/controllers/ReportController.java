package controllers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import models.Report;
import models.Enrollment;

public class ReportController {

    /**
     * create a list report of student follow with the number courser name of
     * student
     *
     * @param listStudent
     * @return list report include number of each course
     */
    public List<Report> createListReport(List<Enrollment> listStudent) {
        if (listStudent.isEmpty()) {
            throw new IllegalArgumentException("Error, that list not have any student");
        }
        
        Map<String, Report> map = new LinkedHashMap<>();
        
        for (Enrollment temp : listStudent) {
            String key = temp.getId() + "_" + temp.getCourseNameString();
            //check that key contain in the hashmap or not
            if (!map.containsKey(key)) {
                map.put(key, new Report(temp.getId(), temp.getName(), temp.getCourseNameString(),
                        1, temp.getScore()));
                
            } else { //initialize report exist then plus to total number course
                Report reportTemp = map.get(key);
                reportTemp.setTotalCourse(reportTemp.getTotalCourse() + 1);
                reportTemp.setSumScore(temp.getScore()+ reportTemp.getSumScore());
            }
            
        }
        for(Report r: map.values()){
            r.setAvg(r.getSumScore()/r.getTotalCourse());
        }
        
        System.out.println(map.values()+"\n");
        
        return new ArrayList<>(map.values());
    }
    
    private double getAvgDoubleScore(List<Enrollment> list, int id, String course) {
        double sum = 0.0;
        int count = 0;
        for (Enrollment temp : list) {
            if (temp.getId() == id && temp.getCourseNameString().equalsIgnoreCase(course)) {
                sum += temp.getScore();
                count++;
            }
        }
        return (double) (sum / count);
    }

//    private boolean isExistReport(List<Report> listReport, Enrollment student) {
//        for (Report temp : listReport) {
//            //check student exist in the report
//            if (temp.getId() == student.getId() && temp.getCourseName().equalsIgnoreCase(student.getCourseNameString()))  {
//                return true;
//            }
//        }
//        return false;
//    }
}
