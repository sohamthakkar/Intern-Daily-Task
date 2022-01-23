package task.streamApi.StreamExample;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TextServices {
    public static List<Emplyee> eveluateTextUser(){
        return Datbase.getEmployeeDetail().stream().filter(t -> t.getSalary() > 60000).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(eveluateTextUser());
    }
}
