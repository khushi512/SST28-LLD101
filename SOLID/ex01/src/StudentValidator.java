package SOLID.ex01.src;

import java.util.*;

public class StudentValidator {
    private static final Set<String> ALLOWED = Set.of("CSE", "AI", "SWE");

    public List<String> validate(StudentData d) {

        List<String> errors = new ArrayList<>();

        if (d.name.isBlank()) errors.add("name is required");
        if (d.email.isBlank() || !d.email.contains("@"))
            errors.add("email is invalid");
        if (d.phone.isBlank() ||
                !d.phone.chars().allMatch(Character::isDigit))
            errors.add("phone is invalid");
        if (!ALLOWED.contains(d.program))
            errors.add("program is invalid");

        return errors;
    }
} 
