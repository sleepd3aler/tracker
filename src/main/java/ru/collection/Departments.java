package ru.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();
        for (String department : departments) {
            String[] subDepartments = department.split("/");
            StringJoiner departmentJoiner = new StringJoiner("/");
            for (String subDepartment : subDepartments) {
                departmentJoiner.add(subDepartment);
                temp.add(departmentJoiner.toString());
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> departments) {
        departments.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> departments) {
        departments.sort(new DepartmentsDescComparator());
    }
}
