package Collections.HashMap;

import Collections.HashMap.extend.Employee;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaHashMapCloningExample {
    static void deepClone(){
        HashMap<Integer, Employee> employeeMap = new HashMap<>();

        employeeMap.put(1, new Employee(1, "Alex", LocalDate.of(1990, 01, 01)));
        employeeMap.put(2, new Employee(2, "Bob", LocalDate.of(1990, 02, 01)));

//Deep clone
        Gson gson = new Gson();
        String jsonString = gson.toJson(employeeMap);

        Type type = new TypeToken<HashMap<Integer, Employee>>(){}.getType();
        HashMap<Integer, Employee> clonedMap = gson.fromJson(jsonString, type);

        System.out.println(clonedMap);

//--------------------------------------

        System.out.println("\nChanges DO NOT reflect in other map \n");

//Change a value is clonedMap
        clonedMap.get(1).setFirstName("Charles");

//Verify content of both maps
        System.out.println(employeeMap);
        System.out.println(clonedMap);
    }
    static void shadowClone(){
        HashMap<Integer, Employee> employeeMap = new HashMap<>();

        employeeMap.put(1, new Employee(1, "Alex", LocalDate.of(1990, 01, 01)));
        employeeMap.put(2, new Employee(2, "Bob", LocalDate.of(1990, 02, 01)));

// Shallow clone
        Map<Integer, Employee> clonedMap = employeeMap.entrySet()
                .stream()
                //perform customization
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

// Same as employeeMap
        //Change a value is clonedMap
        clonedMap.get(1).setFirstName("Charles");

//Verify content of both maps---->both changed
        System.out.println(employeeMap);
        System.out.println(clonedMap);
    }
    public static void main(String[] args) {
        //deepClone();
        shadowClone();
    }
}
