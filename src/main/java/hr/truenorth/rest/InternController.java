package hr.truenorth.rest;

import hr.truenorth.dto.InternDto;
import hr.truenorth.model.Intern;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Path("/interns")
public class InternController {

    @POST
    @Transactional
    public void createIntern(InternDto internDto) {
        Intern.add(internDto.getUsername(), internDto.getPassword(), "intern",
                internDto.getFirstName(), internDto.getLastName(),
                internDto.getUniversity(), internDto.getStudyYear(),
                LocalDate.parse(internDto.getDateOfBirth(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

}
