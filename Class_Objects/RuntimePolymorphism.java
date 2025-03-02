package Class_Objects;

class Employee {
    public void salary(){
        System.out.println("500");
    }
}


class Programmer extends Employee{
    public void salary(){
        System.out.println("1000");
    }
}


class SalesPerson extends Employee{
    public void salary(){
        System.out.println("800");
    }
}


public class RuntimePolymorphism {
    public static void main(String[] args){
        Programmer p = new Programmer();
        SalesPerson s = new SalesPerson();
        p.salary();
        s.salary();
    }
}






