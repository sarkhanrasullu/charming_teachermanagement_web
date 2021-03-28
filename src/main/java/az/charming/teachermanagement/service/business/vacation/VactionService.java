package az.charming.teachermanagement.service.business.vacation;

import az.charming.teachermanagement.dto.StudentDto;
import az.charming.teachermanagement.service.functional.StudentService;
import org.springframework.stereotype.Service;

@Service
public class VactionService {

    private StudentService studentService;

    public void submitVacation(VacationSubmitDto vacationSubmitDto){
        studentService.save(new StudentDto().setName(vacationSubmitDto.getSubmitter()));
    }
}
