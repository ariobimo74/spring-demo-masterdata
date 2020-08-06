package com.codevergence.demo.masterdata.model.entity;

import com.codevergence.demo.masterdata.model.dto.EmployeeDto;

import javax.persistence.*;

@SqlResultSetMapping(name = "employeeMapping", classes = {@ConstructorResult(targetClass = EmployeeDto.class, columns = {
        @ColumnResult(name = "id", type = Long.class),
        @ColumnResult(name = "npk", type = String.class),
        @ColumnResult(name = "name", type = String.class),
        @ColumnResult(name = "officeEmail", type = String.class),
        @ColumnResult(name = "typeId", type = Long.class),
        @ColumnResult(name = "typeName", type = String.class),
        @ColumnResult(name = "placementId", type = Long.class),
        @ColumnResult(name = "placementName", type = String.class)
})})

@NamedNativeQuery(name = "Employee.getAllEmployee",
query = "SELECT employee.id, employee.npk, employee.name, employee.office_email AS officeEmail, employee_type.id AS typeId, employee_type.name AS typeName, placement.id AS placementId, placement.name AS placementName \n" +
        "FROM employee AS employee\n" +
        "LEFT JOIN employee_type AS employee_type\n" +
        "ON employee.employee_type_id = employee_type.id\n" +
        "LEFT JOIN placement AS placement\n" +
        "ON employee.placement_id = placement.id\n" +
        "WHERE employee.is_delete = 0\n" +
        "AND employee_type.is_delete = 0\n" +
        "AND placement.is_delete = 0", resultSetMapping = "employeeMapping")

@NamedNativeQuery(name = "Employee.getEmployee",
query = "SELECT employee.id, employee.npk, employee.name, employee.office_email AS officeEmail, employee_type.id AS typeId, employee_type.name AS typeName, placement.id AS placementId, placement.name AS placementName \n" +
        "FROM employee AS employee\n" +
        "LEFT JOIN employee_type AS employee_type\n" +
        "ON employee.employee_type_id = employee_type.id\n" +
        "LEFT JOIN placement AS placement\n" +
        "ON employee.placement_id = placement.id\n" +
        "WHERE employee.is_delete = 0\n" +
        "AND employee_type.is_delete = 0\n" +
        "AND placement.is_delete = 0\n" +
        "AND employee.id =:employeeById ", resultSetMapping = "employeeMapping")

@NamedNativeQuery(name = "Employee.getAllEmployeeByTypeId",
query = "SELECT employee.id, employee.npk, employee.name, employee.office_email AS officeEmail, employee_type.id AS typeId, employee_type.name AS typeName, placement.id AS placementId, placement.name AS placementName\n" +
        "FROM employee AS employee\n" +
        "LEFT JOIN employee_type AS employee_type\n" +
        "ON employee.employee_type_id = employee_type.id\n" +
        "LEFT JOIN placement AS placement\n" +
        "ON employee.placement_id = placement.id\n" +
        "WHERE employee.is_delete = 0\n" +
        "AND employee_type.is_delete = 0\n" +
        "AND placement.is_delete = 0\n" +
        "AND employee_type.id =:theTypeId ", resultSetMapping = "employeeMapping")

@NamedNativeQuery(name = "Employee.getAllEmployeeByPlacementId",
query = "SELECT employee.id, employee.npk, employee.name, employee.office_email AS officeEmail, employee_type.id AS typeId, employee_type.name AS typeName, placement.id AS placementId, placement.name AS placementName\n" +
        "FROM employee AS employee\n" +
        "LEFT JOIN employee_type AS employee_type\n" +
        "ON employee.employee_type_id = employee_type.id\n" +
        "LEFT JOIN placement AS placement\n" +
        "ON employee.placement_id = placement.id\n" +
        "WHERE employee.is_delete = 0\n" +
        "AND employee_type.is_delete = 0\n" +
        "AND placement.is_delete = 0\n" +
        "AND placement.id =:thePlacementId ", resultSetMapping = "employeeMapping")

@NamedNativeQuery(name = "Employee.getAllEmployeeSearch",
query = "SELECT employee.id, employee.npk, employee.name, employee.office_email AS officeEmail, employee_type.id AS typeId, employee_type.name AS typeName, placement.id AS placementId, placement.name AS placementName\n" +
        "FROM employee AS employee\n" +
        "LEFT JOIN employee_type AS employee_type\n" +
        "ON employee.employee_type_id = employee_type.id\n" +
        "LEFT JOIN placement AS placement\n" +
        "ON employee.placement_id = placement.id\n" +
        "WHERE employee.is_delete = 0\n" +
        "AND employee_type.is_delete = 0\n" +
        "AND placement.is_delete = 0\n" +
        "AND employee_type.id = :theTypeId\n" +
        "AND placement.id = :thePlacementId", resultSetMapping = "employeeMapping")

@NamedNativeQuery(name = "Employee.getAllEmployeeAdvancedSearch",
query = "SELECT employee.id, employee.npk, employee.name, employee.office_email AS officeEmail, employee_type.id AS typeId, employee_type.name AS typeName, placement.id AS placementId, placement.name AS placementName\n" +
        "FROM employee AS employee\n" +
        "LEFT JOIN employee_type AS employee_type\n" +
        "ON employee.employee_type_id = employee_type.id\n" +
        "LEFT JOIN placement AS placement\n" +
        "ON employee.placement_id = placement.id\n" +
        "WHERE employee.is_delete = 0\n" +
        "AND employee_type.is_delete = 0\n" +
        "AND placement.is_delete = 0\n" +
        "AND employee.npk LIKE LOWER(concat('%',:theNpk,'%'))\n" +
        "AND employee.name LIKE LOWER(CONCAT('%',:theName,'%'))\n", resultSetMapping = "employeeMapping")

@NamedNativeQuery(name = "Employee.getAllEmployeePaginateAsc",
query = "SELECT employee.id, employee.npk, employee.name, employee.office_email AS officeEmail, employee_type.id AS typeId, employee_type.name AS typeName, placement.id AS placementId, placement.name AS placementName\n" +
        "FROM employee AS employee\n" +
        "LEFT JOIN employee_type AS employee_type\n" +
        "ON employee.employee_type_id = employee_type.id\n" +
        "LEFT JOIN placement AS placement\n" +
        "ON employee.placement_id = placement.id\n" +
        "WHERE employee.is_delete = 0\n" +
        "AND employee_type.is_delete = 0\n" +
        "AND placement.is_delete = 0\n" +
        "ORDER BY name ASC\n" +
        "OFFSET :offset ROWS\n" +
        "FETCH NEXT :fetch ROWS ONLY", resultSetMapping = "employeeMapping")

@NamedNativeQuery(name = "Employee.getAllEmployeePaginateDesc",
query = "SELECT employee.id, employee.npk, employee.name, employee.office_email AS officeEmail, employee_type.id AS typeId, employee_type.name AS typeName, placement.id AS placementId, placement.name AS placementName\n" +
        "FROM employee AS employee\n" +
        "LEFT JOIN employee_type AS employee_type\n" +
        "ON employee.employee_type_id = employee_type.id\n" +
        "LEFT JOIN placement AS placement\n" +
        "ON employee.placement_id = placement.id\n" +
        "WHERE employee.is_delete = 0\n" +
        "AND employee_type.is_delete = 0\n" +
        "AND placement.is_delete = 0\n" +
        "ORDER BY name DESC\n" +
        "OFFSET :offset ROWS\n" +
        "FETCH NEXT :fetch ROWS ONLY", resultSetMapping = "employeeMapping")

@NamedNativeQuery(name = "Employee.getAllEmployeePagingRowAsc",
query = "SELECT employee.id, employee.npk, employee.name, employee.office_email AS officeEmail, employee_type.id AS typeId, employee_type.name AS typeName, placement.id AS placementId, placement.name AS placementName\n" +
        "FROM employee AS employee\n" +
        "LEFT JOIN employee_type AS employee_type\n" +
        "ON employee.employee_type_id = employee_type.id\n" +
        "LEFT JOIN placement AS placement\n" +
        "ON employee.placement_id = placement.id\n" +
        "WHERE employee.is_delete = 0\n" +
        "AND employee_type.is_delete = 0\n" +
        "AND placement.is_delete = 0\n" +
        "ORDER BY name ASC\n" +
        "OFFSET :offset ROWS\n" +
        "FETCH NEXT :fetch ROWS ONLY", resultSetMapping = "employeeMapping")

@Entity
@Table(name = "employee")
public class Employee extends Common
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "npk", nullable = false)
    private String npk;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "office_email", nullable = false, unique = true)
    private String officeEmail;

    @ManyToOne
    @JoinColumn(name = "employeeTypeId", referencedColumnName = "id")
    private EmployeeType employeeType;

    @ManyToOne
    @JoinColumn(name = "placementId", referencedColumnName = "id")
    private Placement placement;

    public Employee() {
    }

    public Employee(long id, String npk, String name, String officeEmail) {
        this.id = id;
        this.npk = npk;
        this.name = name;
        this.officeEmail = officeEmail;
    }

    public Employee(long id, String npk, String name, String officeEmail, EmployeeType employeeType) {
        this.id = id;
        this.npk = npk;
        this.name = name;
        this.officeEmail = officeEmail;
        this.employeeType = employeeType;
    }

    public Employee(long id, String npk, String name, String officeEmail, Placement placement) {
        this.id = id;
        this.npk = npk;
        this.name = name;
        this.officeEmail = officeEmail;
        this.placement = placement;
    }

    public Employee(long id, String npk, String name, String officeEmail, EmployeeType employeeType, Placement placement) {
        this.id = id;
        this.npk = npk;
        this.name = name;
        this.officeEmail = officeEmail;
        this.employeeType = employeeType;
        this.placement = placement;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNpk() {
        return npk;
    }

    public void setNpk(String npk) {
        this.npk = npk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficeEmail() {
        return officeEmail;
    }

    public void setOfficeEmail(String officeEmail) {
        this.officeEmail = officeEmail;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public Placement getPlacement() {
        return placement;
    }

    public void setPlacement(Placement placement) {
        this.placement = placement;
    }
}
