package ru.collection;
//
import java.util.Arrays;
import java.util.List;

class DepartmentsTest1 {
    public static void main(String[] args) {
        List<String> deps = Arrays.asList("K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K2",
                "K2/SK1",
                "K1/SK2",
                "K1",
                "K2/SK1/SSK2",
                "K2/SK1/SSK1");
        List<String> depsRes = Departments.fillGaps(deps);
        depsRes.sort(new DepartmentsDescComparator());
        System.out.println(depsRes);

    }

}