package com.kgate.service;

import java.util.List;

import com.kgate.model.Skill;

public interface SkillService {

    public void addSkill(Skill skill);

    public List<Skill> getAllSkills();

    public void deleteSkill(Integer skill_id);

    public Skill getSkill(int skill_id);
    
    public Skill getSkillByName(String skillName);

    public Skill updateSkill(Skill skill);
}
