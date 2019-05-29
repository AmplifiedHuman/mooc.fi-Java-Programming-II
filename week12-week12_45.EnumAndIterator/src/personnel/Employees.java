package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {

    private List<Person> employees;

    public Employees() {
        employees = new ArrayList<Person>();
    }

    public void add(Person person) {
        employees.add(person);
    }

    public void add(List<Person> persons) {
        employees.addAll(persons);
    }

    public void print() {
        Iterator<Person> iter = employees.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public void print(Education education) {
        Iterator<Person> iter = employees.iterator();
        while (iter.hasNext()) {
            Person temp = iter.next();
            if (temp.getEducation() == education) {
                System.out.println(temp);
            }
        }
    }

    public void fire(Education education) {
        Iterator<Person> iter = employees.iterator();
        while (iter.hasNext()) {
            if (iter.next().getEducation() == education) {
                iter.remove();
            }
        }
    }
}