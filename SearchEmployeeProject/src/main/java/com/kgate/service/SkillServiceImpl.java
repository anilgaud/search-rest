package com.kgate.service;

import com.kgate.dao.SkillDao;
import com.kgate.model.Skill;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillDao skillDao;

    @Override
    public void addSkill(Skill skill) {
        skillDao.addSkill(skill);
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillDao.getAllSkill();
    }

    @Override
    public void deleteSkill(Integer skill_id) {
        skillDao.deleteSkill(skill_id);
    }

    @Override
    public Skill getSkill(int skill_id) {
        return skillDao.getSkill(skill_id);
    }

    @Override
    public Skill updateSkill(Skill skill) {
        return skillDao.updateSkill(skill);
    }

    public void setSkill(SkillDao skillDao) {
		this.skillDao = skillDao;
	}

    @Override
    public Skill getSkillByName(String skillName) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   return skillDao.getSkillByName(skillName);
    
    }
}
