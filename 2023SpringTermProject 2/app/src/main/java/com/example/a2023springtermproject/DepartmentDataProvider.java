package com.example.a2023springtermproject;

import java.util.HashMap;
import java.util.Map;

public class DepartmentDataProvider {
    private static final Map<String, String> departmentInfoMap;

    static {
        departmentInfoMap = new HashMap<>();
        departmentInfoMap.put("CIS", "Computer Information Systems Department:\n" + "Professor Ching-Song Don Wei, Chair Person\n" + "Fiterman Hall Room F - 930A\n" + "(212) 220 - 1476\n" + "cis@bmcc.cuny.edu\n" + "Fiterman Hall");
        departmentInfoMap.put("BUS", "Business Management Department:\n" + "Mahatapa Palit, Chair Person\n" + "Fiterman Hall Room F - 730A\n" + "(212) 220 - 8205\n" + "bec@bmcc.cuny.edu\n" + "Fiterman Hall");
        departmentInfoMap.put("MAT", "Mathematics Department:\n" + "Fred Peskoff, Chair Person\n" + "199 Chambers Street, Room N - 599N\n" + "(212) 220 - 1335\n" + "ascruz@bmcc.cuny.edu\n" + "Main Building");
        departmentInfoMap.put("NUR", "Nursing Department:\n" + "Judy Eng, Chair Person\n" + "199 Chambers Street, Room S - 730\n" + "(212) 220 - 8230\n" + "nursing@bmcc.cuny.edu\n" + "Main Building");
    }


    public static String getDepartmentInfo(String departmentCode) {
        return departmentInfoMap.get(departmentCode);
    }
}
