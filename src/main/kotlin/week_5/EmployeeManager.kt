package week_5

class MyEmployeeManager : EmployeeManager {
  private val employees: MutableMap<String, Employee> = mutableMapOf()
}

interface EmployeeManager {

}