/**
 *  -> Composite Pattern
 *
 *  1. Create interface for component
 *  2. Implement leaf for base component
 *  3. Implement composite as well as options to add leaf,
 *     remove leaf, and get leaf children
 *
 */

package CompositePattern;

import java.util.ArrayList;

interface EmployeeComponent {
    int noOfEmployees();
}

class ManagerComposite implements EmployeeComponent {
    ArrayList<EmployeeComponent> employees;

    public ManagerComposite() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(EmployeeComponent employee) {
        employees.add(employee);
    }

    public void removeEmployee(EmployeeComponent employee) {
        employees.remove(employee);
    }

    public ArrayList<EmployeeComponent> getChildren() {
        return employees;
    }

    @Override
    public int noOfEmployees() {
        int numEmployees = 0;
        for(EmployeeComponent employee: this.getChildren()) {
            numEmployees += employee.noOfEmployees();
        }

        return numEmployees + 1;
    }
}

class EmployeeLeaf implements EmployeeComponent {
    @Override
    public int noOfEmployees() {
        return 1;
    }
}

class Test {
    public static void main(String[] args) {
        ManagerComposite sydneyManager = new ManagerComposite();
        sydneyManager.addEmployee(new EmployeeLeaf());
        sydneyManager.addEmployee(new EmployeeLeaf());
        sydneyManager.addEmployee(new EmployeeLeaf());

        ManagerComposite brisbaneManager = new ManagerComposite();
        brisbaneManager.addEmployee(new EmployeeLeaf());
        brisbaneManager.addEmployee(new EmployeeLeaf());
        brisbaneManager.addEmployee(new EmployeeLeaf());
        brisbaneManager.addEmployee(new EmployeeLeaf());

        ManagerComposite ceo = new ManagerComposite();
        ceo.addEmployee(sydneyManager);
        ceo.addEmployee(brisbaneManager);

        System.out.println(ceo.noOfEmployees());
    }
}
