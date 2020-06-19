package addvertisment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import addvertisment.dto.GradeDTO;
import addvertisment.model.Addvertisment;
import addvertisment.model.Grade;
import addvertisment.repository.AddvertismentRepository;
import addvertisment.repository.GradeRepository;
@Service
public class GradeService {
    
    @Autowired
    private GradeRepository gradeRepository;
    
    @Autowired
    private AddvertismentRepository addvertismentRepository;
    
	public void updateComment(GradeDTO gradeDTO) {
		// TODO Auto-generated method stub

		
	}

	public String createComment(GradeDTO gradeDTO) {
		// TODO Auto-generated method stub
		Addvertisment add = addvertismentRepository.findById(gradeDTO.getAdd_id()).get();
		for (Grade grade : add.getGrades()) {
			if(grade.getUser_id().equals(gradeDTO.getUser_id())) {
				grade.setNumber(gradeDTO.getNumber());
				gradeRepository.save(grade);
				addvertismentRepository.save(add);
				return "updated";
			}
		}
		Grade grade = new Grade();
		grade.setUser_id(gradeDTO.getUser_id());
		grade.setAddvertisment(add);
		grade.setNumber(gradeDTO.getNumber());
		add.getGrades().add(grade);
		gradeRepository.save(grade);
		addvertismentRepository.save(add);
		return "created";
	}

	public List<GradeDTO> getAllGradesFromAdd(Long id) {
		// TODO Auto-generated method stub
		List<GradeDTO> grades = new ArrayList<GradeDTO>();
		for (Grade grade : gradeRepository.findAll()) {
			if(grade.getAddvertisment().getId().equals(id)) {
				grades.add(new GradeDTO(grade));
			}
		}
		return grades;
	}
}
