public class StaticDepartment{
    public static int numberOfWorker= 0;
    public String name;
    
    public StaticDepartment(String name) {
        this.name = name;
        numberOfWorker++; // increment the static variable every time a new 							//Person is created
    }

    public static void main(String[] args) {
      Department dpt1 = new Department("Admin");
      System.out.println(Department.numberOfWorker); // output: 1

      Department dpt2 = new Department ("Finance");
      System.out.println(Department.numberOfWorker); // output: 2

      Department dpt3 = new Department ("Software");
      System.out.println(Department.numberOfWorker); // output: 3
    }
}
