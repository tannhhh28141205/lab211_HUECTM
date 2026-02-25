package Controller;

import Model.Task;
import java.util.List;

public class TaskManagement {

    private int nextId = 0;

    public void mock(List<Task> listTask) {
        listTask.add(validateIdMockData("PC1", 2, "12-12-2025", 8, 10, "long", "lead"));
        listTask.add(validateIdMockData("PC2", 2, "30-12-2025", 8, 10, "short", "lead"));
        listTask.add(validateIdMockData("PC3", 2, "19-12-2025", 8, 10, "bitcoin", "lead"));
        listTask.add(validateIdMockData("PC3", 2, "19-12-2025", 8, 10, "bitcoin", "lead"));
    }

    private Task validateIdMockData(String name, int task, String date, double f, double t, String a, String r) {
        Task temp = new Task(name, task, date, f, t, a, r);
        temp.setId(++nextId);
        return temp;
    }

    public void addTask(List<Task> listTask, Task task) {

        if (!isTimeSlotAvailable(listTask, task, -1)) {
            throw new IllegalArgumentException("Invalid, that task overlapped");
        }

        task.validateTimeAssign();

        //////
        if (task.getAssignee().equalsIgnoreCase(task.getReviewer())) {
            throw new IllegalArgumentException("Assignee cannot be Reviewer");
        }

//        if(!isTotalHourAvailable(task.getPlanFrom(), task.getPlanTo())){
//            throw new IllegalArgumentException("duma dung boc lot no nua");
//        }
        ///////
        task.setId(++nextId);
        listTask.add(task);

    }

    private boolean isTimeSlotAvailable(List<Task> listTask, Task task, int id) {

        for (Task temp : listTask) {

            //dung de update
            if (id == task.getId()) {
                continue;
            }

            if (temp.getAssignee().equalsIgnoreCase(task.getAssignee())) {

                if (isOneDay(task, temp)) {
                    //avoid 
                    boolean noOverlap = task.getPlanFrom() >= temp.getPlanTo()
                            || task.getPlanTo() <= temp.getPlanFrom();
                    //if the task is overlap
                    if (noOverlap == false) {
                        return false;
                    }

                }
            }
        }
        //if task not overlap
        return true;
    }

    private boolean isOneDay(Task task1, Task task2) {
        return task1.getParseDate().equals(task2.getParseDate());
    }

    private int findTaskById(List<Task> listTask, int id) {
        for (int i = 0; i < listTask.size(); i++) {
            if (id == listTask.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    public void deleteTask(List<Task> listTask, int id) {

        if (listTask.isEmpty()) {
            throw new IllegalArgumentException("That list not have any task");
        }

        int index = -1;

        index = findTaskById(listTask, id);
        if (index == -1) {
            throw new IllegalArgumentException("Not found task with that id");
        }

        listTask.remove(index);
    }

    ///////////////////////////////////////////////////////////////////////////////
//    void updateTask(List<Task> listTask, int id, String date, double plamFrom
//    , double planTo, String assigneem, String reviewer ){
//        
//        if(listTask.isEmpty()){
//            throw new IllegalArgumentException("The list empty");
//        }
//        
//        int index=-1;
//               index= findTaskById(listTask, id);
//        if(index==-1){
//            throw new IllegalArgumentException("not found task");
//        }
//        
//        Task oldTask= listTask.get(index);
//        
//        Task newTask= new Task(oldTask.getId(), oldTask.getName(), oldTask.getTaskType(), date, 
//                plamFrom, planTo, assigneem, reviewer);
//
//        
//      if(! isTimeSlotAvailable(listTask, newTask, id)){
//          throw new IllegalArgumentException("Cannot update that task with that time");
//      }
//        listTask.set(index, newTask);
//    }
//    
//    
//    private boolean isTotalHourAvailable(double from, double to){
//        return (to -from)>8 ? false : false;
//    }
//    
//    
//    
//    public Map<String, List<Task>> groupByDate(List<Task> listTask){
//         Map<String, List<Task>> map= new LinkedHashMap<>();
//         
//         for(Task temp: listTask){
//             String date = temp.getDate();
//             
//             if(!map.containsKey(date)){
//                 map.put(date, new ArrayList<>());
//             }
//             
//              map.get(date).add(temp);
//         }
//
//        return map;
//    }
}
