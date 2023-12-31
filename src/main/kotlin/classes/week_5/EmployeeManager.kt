package classes.week_5

class MyEmployeeManager : EmployeeManager {
  private val employees: MutableMap<String, Employee> = mutableMapOf()
  override fun addEmployee(employee: Employee) {
    // Not a pure function, accesses a global state
    if (!employees.containsKey(employee.id)) {
      employees[employee.id] = employee
    }
  }

  override fun getAllEmployees(): List<Employee> {
    // Not a pure function
    return employees.values.toList()
  }

  override fun getEmployeeById(id: String): Employee? {
    // Accesses a global state so it's a side effect and hence not a pure function
    return employees[id]
  }

  override fun getEmployeesByDesignation(designation: Designation): List<Employee> {
    return employees.values.filter {
      when (designation) {
        is Designation.Manager -> it.designation is Designation.Manager
        is Designation.Executive -> it.designation is Designation.Executive
        is Designation.Junior -> it.designation is Designation.Junior
      }
    }
  }
}

interface EmployeeManager {
  fun addEmployee(employee: Employee)
  fun getAllEmployees(): List<Employee>
  fun getEmployeeById(id: String): Employee?
  fun getEmployeesByDesignation(designation: Designation): List<Employee>
}