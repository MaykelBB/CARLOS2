package g2t.app.services;

import g2t.app.domain.Section;

import g2t.app.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {

    private SectionRepository sectionRepository;

    @Autowired
    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public Iterable<Section> listSections(){ return sectionRepository.findAll(); }

    public Section getSection(long id){ return sectionRepository.findOne(id); }

    public Section saveSection(Section section){ return sectionRepository.save(section); }

    public List<Section> getActiveSections(){
        return sectionRepository.findByActive(true);
    }
}
