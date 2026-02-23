package SOLID.ex01.src;

import java.util.List;

public class TextTable {

    public static String render(List<StudentRecord> rows) {

        StringBuilder sb = new StringBuilder();
        sb.append("| ID             | NAME | PROGRAM |\n");

        for (StudentRecord r : rows) {
            sb.append(String.format(
                    "| %-14s | %-4s | %-7s |\n",
                    r.getId(),
                    r.getName(),
                    r.getProgram()
            ));
        }

        return sb.toString();
    }
}
