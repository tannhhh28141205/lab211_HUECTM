package Model;

public  class Worker {

    private String id,name, workLocation;
    private int age;
    private double salary;

    public Worker() {
    }

    public Worker(String id, String name, int age, double salary, String workLocation) {
        setAge(age);
        setId(id);
        setName(name);
        setSalary(salary);
        setWorkLocation(workLocation);
    }

    //GETTER
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    //SETTER
    public final void setId(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must not be empty");
        }
        this.id = id;
    }

    public final void setName(String name){
    if(name==null){
        throw  new IllegalArgumentException("Name must not be empty");
    }
    this.name  = name;
}

public final void setWorkLocation(String workLocation) {
        if(workLocation ==null){
            throw new IllegalArgumentException("Work location must not be empty");
        }
        this.workLocation = workLocation;
    }

    public final void setAge(int age) {
        if(age< 18 || age >50){
            throw new IllegalArgumentException("Age must be in range 18 to 50");
        }
        this.age = age;
    }

    public final void setSalary(double salary) {
       if(salary < 0){
           throw new IllegalArgumentException("Salary must be greater than 0");
       }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker{" + "id=" + id + ", name=" + name + ", workLocation=" + workLocation + ", age=" + age + ", salary=" + salary + '}';
    }
    
    
    
}
