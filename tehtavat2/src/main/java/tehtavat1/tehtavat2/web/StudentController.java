package tehtavat1.tehtavat2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import domain.Student;

@Controller
public class StudentController {

    public static List<Student> students = new ArrayList();

    static {
        students.add(new Student("Aku", "Ankka"));
        students.add(new Student("Iines", "Ankka"));
        students.add(new Student("Hannu", "Hanhi"));
    }

    @GetMapping("/students")
    public String showStudents(Model model){
        model.addAttribute("opiskelijat", students);
        return "students";
    }


}
