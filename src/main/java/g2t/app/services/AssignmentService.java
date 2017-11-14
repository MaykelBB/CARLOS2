package g2t.app.services;

import g2t.app.domain.Assignment;
import g2t.app.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {
    private AssignmentRepository assignmentRepository;

    @Autowired
    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public Iterable<Assignment> listAssignments(){ return assignmentRepository.findAll(); }

    public Assignment getAssignment(long id){ return assignmentRepository.findOne(id); }

    public Assignment saveAssignment(Assignment assignment){ return assignmentRepository.save(assignment); }

    public List<Assignment> getActiveAssignments(){ return assignmentRepository.findByActive(true); }
}
