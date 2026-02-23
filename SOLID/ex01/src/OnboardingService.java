package SOLID.ex01.src;

import java.util.List;

public class OnboardingService {

    private final StudentRepository db;
    private final StudentParser parser = new StudentParser();
    private final StudentValidator validator = new StudentValidator();
    private final StudentPrinter printer = new StudentPrinter();

    public OnboardingService(StudentRepository db) {
        this.db = db;
    }

    public void registerFromRawInput(String raw) {

        printer.printInput(raw);

        StudentData data = parser.parse(raw);

        List<String> errors = validator.validate(data);
        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = nextStudentId(db.count());

        StudentRecord rec = new StudentRecord( id, data.name, data.email, data.phone, data.program);

        db.save(rec);

        printer.printSuccess(rec, db.count());
    }

    private String nextStudentId(int currentCount) {
        int next = currentCount + 1;
        return String.format("SST-2026-%04d", next);
    }
}