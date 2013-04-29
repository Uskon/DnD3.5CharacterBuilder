/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentManager;

import Components.CClass;
import Components.ClassFeat;
import Components.ClassProgress;
import Components.ClassRequirement.ClassAlignmentRequirement;
import Components.ClassRequirement.ClassAttributeRequirement;
import Components.ClassRequirement.ClassBABRequirement;
import Components.ClassRequirement.ClassCasterLevelRequirement;
import Components.ClassRequirement.ClassClassRequirement;
import Components.ClassRequirement.ClassDeityRequirement;
import Components.ClassRequirement.ClassFeatRequirement;
import Components.ClassRequirement.ClassLevelRequirement;
import Components.ClassRequirement.ClassRaceRequirement;
import Components.ClassRequirement.ClassSaveRequirement;
import Components.ClassRequirement.ClassSkillRequirement;
import Components.ClassRequirement.ClassSpellRequirement;
import Components.ClassSkill;
import Components.DDomain;
import Components.Deity;
import Components.DeityDomain;
import Components.DomainFeat;
import Components.Feat;
import Components.FeatRequirements.FeatAlignmentRequirement;
import Components.FeatRequirements.FeatAttributeRequirement;
import Components.FeatRequirements.FeatBABRequirement;
import Components.FeatRequirements.FeatCasterLevelRequirement;
import Components.FeatRequirements.FeatClassRequirement;
import Components.FeatRequirements.FeatDeityRequirement;
import Components.FeatRequirements.FeatFeatRequirement;
import Components.FeatRequirements.FeatLevelRequirement;
import Components.FeatRequirements.FeatRaceRequirement;
import Components.FeatRequirements.FeatSaveRequirement;
import Components.FeatRequirements.FeatSkillRequirement;
import Components.FeatRequirements.FeatSpellRequirement;
import Components.Race;
import Components.RacialFeat;
import Components.RuleSet;
import Components.Skill;
import Components.descriptions.ClassDescription;
import Components.descriptions.FeatDescription;
import Components.descriptions.RaceDescription;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Tietokannan lisäys- ja hakukyselyitä, sekä poistoja tekevä yleisluokka.
 *
 */
public class EM {

    private EntityManagerFactory emf = null;
    private EntityManager em = null;

    public EM() {
        emf = Persistence.createEntityManagerFactory("DnDCharBuilderPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<RuleSet> getRuleSets() {
        em = getEntityManager();
        return em.createQuery("SELECT r FROM RuleSet r ORDER BY r.name, r.fullname").getResultList();
    }

    public RuleSet getRuleSetByName(String rsetname) {
        em = getEntityManager();
        return (RuleSet) em.createQuery("SELECT r FROM RuleSet r WHERE r.name = '" + rsetname + "'").getSingleResult();
    }

    public List<CClass> getClassesByRuleSet(String rsetname) {
        em = getEntityManager();
        return em.createQuery("SELECT c FROM CClass c WHERE c.ruleSet.name = '" + rsetname + "' ORDER BY c.name").getResultList();
    }

    public List<Feat> getFeatsByRuleSet(String rsetname) {
        em = getEntityManager();
        return em.createQuery("SELECT f FROM Feat f WHERE f.ruleSet.name = '" + rsetname + "' ORDER BY f.name").getResultList();
    }

    public List<Race> getRacesByRuleSet(String rsetname) {
        em = getEntityManager();
        return em.createQuery("SELECT r FROM Race r WHERE r.ruleSet.name = '" + rsetname + "' ORDER BY r.name").getResultList();
    }

    public List<Skill> getSkillsByRuleSet(String rsetname) {
        em = getEntityManager();
        return em.createQuery("SELECT s FROM Skill s WHERE s.ruleSet.name = '" + rsetname + "' ORDER BY s.name").getResultList();
    }

    public List<Deity> getDeitiesByRuleSet(String rsetname) {
        em = getEntityManager();
        return em.createQuery("SELECT d FROM Deity d WHERE d.ruleSet.name = '" + rsetname + "' ORDER BY d.name").getResultList();
    }

    public List<DDomain> getDomainsByRuleSet(String rsetname) {
        em = getEntityManager();
        return em.createQuery("SELECT d FROM DDomain d WHERE d.ruleSet.name = '" + rsetname + "' ORDER BY d.name").getResultList();
    }

    public List<CClass> getClasses() {
        em = getEntityManager();
        return em.createQuery("SELECT c FROM CClass c ORDER BY c.name, c.ruleSet.name").getResultList();
    }

    public List<CClass> getClassesByName(String classname) {
        em = getEntityManager();
        return em.createQuery("SELECT c FROM CClass c WHERE c.name = '" + classname + "'").getResultList();
    }
    
    public List<CClass> searchClassesByName(String classname) {
        em = getEntityManager();
        return em.createQuery("SELECT c FROM CClass c WHERE UPPER(c.name) LIKE UPPER('%" + classname + "%') ORDER BY c.name, c.ruleSet.name").getResultList();
    }

    public CClass getClassByID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return (CClass) em.createQuery("SELECT c FROM CClass c WHERE c.id = " + realId).getSingleResult();
    }

    public List<Skill> getSkills() {
        em = getEntityManager();
        return em.createQuery("SELECT s FROM Skill s ORDER BY s.name, s.ruleSet.name").getResultList();
    }
    

    public Skill getSkillByID(String skillid) {
        em = getEntityManager();
        long realId = convertID(skillid);
        return (Skill) em.createQuery("SELECT s FROM Skill s WHERE s.id = " + realId).getSingleResult();
    }

    public List<Skill> getSkillsByName(String skillname) {
        em = getEntityManager();
        return em.createQuery("SELECT s FROM Skill s WHERE s.name = '" + skillname + "'").getResultList();
    }
    
    public List<Skill> searchSkillsByName(String skillname) {
        em = getEntityManager();
        return em.createQuery("SELECT s FROM Skill s WHERE UPPER(s.name) LIKE UPPER('%" + skillname + "%') ORDER BY s.name, s.ruleSet.name").getResultList();
    }

    public List<ClassSkill> getClassSkills() {
        em = getEntityManager();
        return em.createQuery("SELECT cs FROM ClassSkill cs").getResultList();
    }

    public List<ClassSkill> getClassSkillsByClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return em.createQuery("SELECT cs FROM ClassSkill cs WHERE cs.cclass.id = " + realId + " ORDER BY cs.cclass.name, cs.skill.name").getResultList();
    }

    public List<ClassSkill> getClassSkillsBySkillID(String skillid) {
        em = getEntityManager();
        long realId = convertID(skillid);
        return em.createQuery("SELECT cs FROM ClassSkill cs WHERE cs.skill.id = " + realId + " ORDER BY cs.skill.name, cs.cclass.name").getResultList();
    }

    public List<Skill> getUnsetClassSkillsByClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return em.createQuery("SELECT s FROM Skill s WHERE s.id NOT IN (SELECT cs.skill.id FROM ClassSkill cs WHERE cs.cclass.id = " + realId + ") ORDER BY s.name").getResultList();
    }

    public List<Feat> getFeats() {
        em = getEntityManager();
        return em.createQuery("SELECT f FROM Feat f ORDER BY f.name, f.ruleSet.name").getResultList();
    }

    public Feat getFeatByID(String featid) {
        em = getEntityManager();
        long realId = convertID(featid);
        return (Feat) em.createQuery("SELECT f FROM Feat f WHERE f.id = " + realId).getSingleResult();
    }

    public List<Feat> getFeatsByName(String featname) {
        em = getEntityManager();
        return em.createQuery("SELECT f FROM Feat f where f.name = '" + featname + "' ORDER BY f.name, f.ruleSet.name").getResultList();
    }
    
    public List<Feat> searchFeatsByName(String featname) {
        em = getEntityManager();
        return em.createQuery("SELECT f FROM Feat f where UPPER(f.name) LIKE UPPER('%" + featname + "%')").getResultList();
    }

    public List<ClassFeat> getClassFeats() {
        em = getEntityManager();
        return em.createQuery("SELECT cf FROM ClassFeat cf ORDER BY cf.cclass.name, cf.cclass.ruleSet.name, cf.feat.name, cf.feat.ruleSet.name").getResultList();
    }

    public List<ClassFeat> getClassFeatsByClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return em.createQuery("SELECT cf FROM ClassFeat cf WHERE cf.cclass.id = " + realId + " ORDER BY cf.cclass.name, cf.cclass.ruleSet.name, cf.feat.name, cf.feat.ruleSet.name").getResultList();
    }

    public List<Feat> getUnsetClassFeatsByClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return em.createQuery("SELECT f FROM Feat f WHERE f.id NOT IN (SELECT cf.feat.id FROM ClassFeat cf WHERE cf.cclass.id = " + realId + ")").getResultList();
    }

    public List<ClassFeat> getClassFeatsByFeatID(String featid) {
        em = getEntityManager();
        long realId = convertID(featid);
        return em.createQuery("SELECT cf FROM ClassFeat cf WHERE cf.feat.id = " + realId + " ORDER BY cf.feat.name, cf.feat.ruleSet.name, cf.cclass.name, cf.cclass.ruleSet.name").getResultList();
    }

    public List<Race> getRaces() {
        em = getEntityManager();
        return em.createQuery("SELECT r FROM Race r ORDER BY r.name, r.ruleSet.name").getResultList();
    }

    public Race getRaceByID(String raceid) {
        em = getEntityManager();
        long realId = convertID(raceid);
        return (Race) em.createQuery("SELECT r FROM Race r WHERE r.id = " + realId).getSingleResult();
    }

    public List<Race> getRacesByName(String racename) {
        em = getEntityManager();
        return em.createQuery("SELECT r FROM Race r WHERE r.name = '" + racename + "'").getResultList();
    }
    
    public List<Race> searchRacesByName(String racename) {
        em = getEntityManager();
        return em.createQuery("SELECT r FROM Race r WHERE UPPER(r.name) LIKE UPPER('%" + racename + "%') ORDER BY r.name, r.ruleSet.name").getResultList();
    }

    public List<RaceDescription> getRaceDescriptions() {
        em = getEntityManager();
        return em.createQuery("SELECT rd FROM RaceDescription rd").getResultList();
    }

    public RaceDescription getRaceDescriptionByRaceID(String raceid) {
        em = getEntityManager();
        long realId = convertID(raceid);
        return (RaceDescription) em.createQuery("SELECT rd FROM RaceDescription rd WHERE rd.race.id = " + realId).getSingleResult();
    }
    
    public List<RacialFeat> getRacialFeats() {
        em = getEntityManager();
        return em.createQuery("SELECT rf FROM RacialFeat rf ORDER BY rf.race.name, rf.race.ruleSet.name, rf.feat.name, rf.feat.ruleSet.name").getResultList();
    }
    
    public List<RacialFeat> getRacialFeatsByRaceID(String raceid) {
        em = getEntityManager();
        long realId = convertID(raceid);
        return em.createQuery("SELECT rf FROM RacialFeat rf WHERE rf.race.id = " + realId + " ORDER BY rf.race.name, rf.race.ruleSet.name, rf.feat.name, rf.feat.ruleSet.name").getResultList();
    }
    
    public List<RacialFeat> getRacialFeatsByFeatID(String featid) {
        em = getEntityManager();
        long realId = convertID(featid);
        return em.createQuery("SELECT rf FROM RacialFeat rf WHERE rf.feat.id = " + realId).getResultList();
    }
    
    public List<Feat> getUnsetRacialFeatsByRaceID(String raceid) {
        em = getEntityManager();
        long realId = convertID(raceid);
        return em.createQuery("SELECT f FROM Feat f WHERE f.id NOT IN (SELECT rf.feat.id FROM RacialFeat rf WHERE rf.race.id = " + realId + ") ORDER BY f.name, f.ruleSet.name").getResultList();
    }

    public List<Deity> getDeities() {
        em = getEntityManager();
        return em.createQuery("SELECT d FROM Deity d ORDER BY d.name, d.ruleSet.name").getResultList();
    }
    
    public List<Deity> getDeitiesByName(String deityname) {
        em = getEntityManager();
        return em.createQuery("SELECT d FROM Deity d WHERE d.name = '" + deityname + "'").getResultList();
    }
    
    public List<Deity> searchDeitiesByName(String deityname) {
        em = getEntityManager();
        return em.createQuery("SELECT d FROM Deity d WHERE UPPER(d.name) LIKE UPPER('%" + deityname + "%') ORDER BY d.name, d.ruleSet.name").getResultList();
    }

    public Deity getDeityByID(String deityid) {
        em = getEntityManager();
        long realId = convertID(deityid);
        return (Deity) em.createQuery("SELECT d FROM Deity d WHERE d.id = " + realId).getSingleResult();
    }

    public List<DeityDomain> getDeityDomains() {
        em = getEntityManager();
        return em.createQuery("SELECT dd FROM DeityDomain dd ORDER BY dd.deity.name, dd.deity.ruleSet.name, dd.domain.name, dd.domain.ruleSet.name").getResultList();
    }

    public List<DeityDomain> getDeityDomainsByDeityID(String deityid) {
        em = getEntityManager();
        long realId = convertID(deityid);
        return em.createQuery("SELECT dd FROM DeityDomain dd WHERE dd.deity.id = " + realId + " ORDER BY dd.deity.name, dd.deity.ruleSet.name, dd.domain.name, dd.domain.ruleSet.name").getResultList();
    }
    
    public List<DeityDomain> getDeityDomainsByDomainID(String domainid) {
        em = getEntityManager();
        long realId = convertID(domainid);
        return em.createQuery("SELECT dd FROM DeityDomain dd WHERE dd.domain.id = " + realId + " ORDER BY dd.domain.name, dd.domain.ruleSet.name, dd.deity.name, dd.deity.ruleSet.name").getResultList();
    }

    public List<DDomain> getUnsetDeityDomainsByDeityID(String deityid) {
        em = getEntityManager();
        long realId = convertID(deityid);
        return em.createQuery("SELECT d FROM DDomain d WHERE d.id NOT IN (SELECT dd.domain.id FROM DeityDomain dd WHERE dd.deity.id = " + realId + ") ORDER BY d.name, d.ruleSet.name").getResultList();
    }

    public List<DDomain> getDomains() {
        em = getEntityManager();
        return em.createQuery("SELECT d FROM DDomain d ORDER BY d.name, d.ruleSet.name").getResultList();
    }

    public DDomain getDomainByID(String domainid) {
        em = getEntityManager();
        long realId = convertID(domainid);
        return (DDomain) em.createQuery("SELECT d FROM DDomain d WHERE d.id = " + realId).getSingleResult();
    }

    public List<DDomain> getDomainsByName(String domainname) {
        em = getEntityManager();
        return em.createQuery("SELECT d FROM DDomain d WHERE d.name = '" + domainname + "'").getResultList();
    }
    
    public List<DDomain> searchDomainsByName(String domainname) {
        em = getEntityManager();
        return em.createQuery("SELECT d FROM DDomain d WHERE UPPER(d.name) LIKE UPPER('%" + domainname + "%') ORDER BY d.name, d.ruleSet.name").getResultList();
    }

    public List<DomainFeat> getDomainFeats() {
        em = getEntityManager();
        return em.createQuery("SELECT df FROM DomainFeat df ORDER BY df.domain.name, df.domain.ruleSet.name, df.feat.name, df.feat.ruleSet.name").getResultList();
    }

    public List<DomainFeat> getDomainFeatsByDomainID(String domainid) {
        em = getEntityManager();
        long realId = convertID(domainid);
        return em.createQuery("SELECT df FROM DomainFeat df WHERE df.domain.id = " + realId + " ORDER BY df.domain.name, df.domain.ruleSet.name, df.feat.name, df.feat.ruleSet.name").getResultList();
    }

    public List<DomainFeat> getDomainFeatsByFeatID(String featid) {
        em = getEntityManager();
        long realId = convertID(featid);
        return em.createQuery("SELECT df FROM DomainFeat df WHERE df.feat.id = " + realId).getResultList();
    }

    public List<DomainFeat> getUnsetDomainFeatsByDomainID(String domainid) {
        em = getEntityManager();
        long realId = convertID(domainid);
        return em.createQuery("SELECT f FROM Feat f WHERE f.id NOT IN (SELECT df.feat.id FROM DomainFeat df WHERE df.domain.id = " + realId + ")").getResultList();
    }

    public List<ClassDescription> getClassDescriptions() {
        em = getEntityManager();
        return em.createQuery("SELECT cd FROM ClassDescription cd ORDER BY cd.cclass.name, cd.cclass.ruleSet.name").getResultList();
    }

    public ClassDescription getClassDescriptionByClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return (ClassDescription) em.createQuery("SELECT cd FROM ClassDescription cd WHERE cd.cclass.id = " + realId).getSingleResult();
    }

    public List<FeatDescription> getFeatDescriptions() {
        em = getEntityManager();
        return em.createQuery("SELECT fd FROM FeatDescription fd ORDER BY fd.feat.name, fd.feat.ruleSet.name").getResultList();
    }

    public FeatDescription getFeatDescriptionByFeatID(String featid) {
        em = getEntityManager();
        long realId = convertID(featid);
        return (FeatDescription) em.createQuery("SELECT fd FROM FeatDescription fd WHERE fd.feat.id = " + realId).getSingleResult();
    }

    public List<ClassProgress> getClassProgressByClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return em.createQuery("SELECT cp FROM ClassProgress cp WHERE cp.cclass.id = " + realId + " ORDER BY cp.lvl").getResultList();
    }

    public List<ClassClassRequirement> getClassClassRequirementsByClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return em.createQuery("SELECT ccr FROM ClassClassRequirement ccr WHERE ccr.cclass.id = " + realId + " ORDER BY ccr.cclass.name, ccr.cclass.ruleSet.name, ccr.requiredClass.name, ccr.requiredClass.ruleSet.name, ccr.requiredLvl").getResultList();
    }

    public List<ClassClassRequirement> getClassClassRequirementsByRequiredClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return em.createQuery("SELECT ccr FROM ClassClassRequirement ccr WHERE ccr.requiredClass.id = " + realId + " ORDER BY ccr.requiredClass.name, ccr.requiredClass.ruleSet.name, ccr.cclass.name, ccr.cclass.ruleSet.name, ccr.requiredLvl").getResultList();
    }

    public List<ClassFeatRequirement> getClassFeatRequirementsByClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return em.createQuery("SELECT cfr FROM ClassFeatRequirement cfr WHERE cfr.cclass.id = " + realId + " ORDER BY cfr.cclass.name, cfr.cclass.ruleSet.name, cfr.requiredFeat.name, cfr.requiredFeat.ruleSet.name").getResultList();
    }

    public List<ClassFeatRequirement> getClassFeatRequirementsByFeatID(String featid) {
        em = getEntityManager();
        long realId = convertID(featid);
        return em.createQuery("SELECT cfr FROM ClassFeatRequirement cfr WHERE cfr.requiredFeat.id = " + realId + " ORDER BY cfr.requiredFeat.name, cfr.requiredFeat.ruleSet.name, cfr.cclass.name, cfr.cclass.ruleSet.name").getResultList();
    }

    public List<ClassSkillRequirement> getClassSkillRequirementsByClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return em.createQuery("SELECT csr FROM ClassSkillRequirement csr WHERE csr.cclass.id = " + realId + " ORDER BY csr.cclass.name, csr.cclass.ruleSet.name, csr.skill.name, csr.skill.ruleSet.name, csr.rank").getResultList();
    }

    public List<ClassSkillRequirement> getClassSkillRequirementsBySkillID(String skillid) {
        em = getEntityManager();
        long realId = convertID(skillid);
        return em.createQuery("SELECT csr FROM ClassSkillRequirement csr WHERE csr.skill.id = " + realId + " ORDER BY csr.skill.name, csr.skill.ruleSet.name, csr.cclass.name, csr.cclass.ruleSet.name, csr.rank").getResultList();
    }

    public ClassBABRequirement getClassBABRequirementByClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return (ClassBABRequirement) em.createQuery("SELECT bab FROM ClassBABRequirement bab WHERE bab.cclass.id = " + realId).getSingleResult();
    }

    public List<ClassCasterLevelRequirement> getClassCasterLevelRequirementsByClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return em.createQuery("SELECT cclr FROM ClassCasterLevelRequirement cclr WHERE cclr.cclass.id = " + realId + " ORDER BY cclr.cclass.name, cclr.cclass.ruleSet.name, cclr.requiredClass.name, cclr.requiredClass.ruleSet.name, cclr.casterLvl").getResultList();
    }

    public List<ClassCasterLevelRequirement> getClassCasterLevelRequirementsByRequiredClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return em.createQuery("SELECT cclr FROM ClassCasterLevelRequirement cclr WHERE cclr.requiredClass.id = " + realId + " ORDER BY cclr.requiredClass.name, cclr.requiredClass.ruleSet.name, cclr.cclass.name, cclr.cclass.ruleSet.name, cclr.casterLvl").getResultList();
    }

    public List<ClassSpellRequirement> getClassSpellRequirementsByClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return em.createQuery("SELECT csr FROM ClassSpellRequirement csr WHERE csr.cclass.id = " + realId + " ORDER BY csr.cclass.name, csr.cclass.ruleSet.name, csr.requiredClass.name, csr.requiredClass.ruleSet.name, csr.spellLvl").getResultList();
    }

    public List<ClassSpellRequirement> getClassSpellRequirementsByRequiredClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return em.createQuery("SELECT csr FROM ClassSpellRequirement csr WHERE csr.requiredClass.id = " + realId + " ORDER BY csr.requiredClass.name, csr.requiredClass.ruleSet.name, csr.cclass.name, csr.cclass.ruleSet.name, csr.spellLvl").getResultList();
    }

    public List<ClassAttributeRequirement> getClassAttributeRequirementsByClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return em.createQuery("SELECT car FROM ClassAttributeRequirement car WHERE car.cclass.id = " + realId + " ORDER BY car.cclass.name, car.cclass.ruleSet.name, car.STR, car.DEX, car.CON, car.INTG, car.WIS, car.CHA").getResultList();
    }

    public List<ClassSaveRequirement> getClassSaveRequirementsByClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return em.createQuery("SELECT csr FROM ClassSaveRequirement csr WHERE csr.cclass.id = " + realId + " ORDER BY csr.cclass.name, csr.cclass.ruleSet.name, csr.fortSave, csr.reflSave, csr.willSave").getResultList();
    }

    public List<ClassAlignmentRequirement> getClassAlignmentRequirementsByClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return em.createQuery("SELECT car FROM ClassAlignmentRequirement car WHERE car.cclass.id = " + realId + " ORDER BY car.cclass.name, car.cclass.ruleSet.name, car.alignment").getResultList();
    }

    public ClassLevelRequirement getClassLevelRequirementByClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return (ClassLevelRequirement) em.createQuery("SELECT clr FROM ClassLevelRequirement clr WHERE clr.cclass.id = " + realId).getSingleResult();
    }

    public List<ClassDeityRequirement> getClassDeityRequirementsByClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return em.createQuery("SELECT cdr FROM ClassDeityRequirement cdr WHERE cdr.cclass.id = " + realId + " ORDER BY cdr.cclass.name, cdr.cclass.ruleSet.name, cdr.deity.name, cdr.deity.ruleSet.name").getResultList();
    }

    public List<ClassDeityRequirement> getClassDeityRequirementsByDeityID(String deityid) {
        em = getEntityManager();
        long realId = convertID(deityid);
        return em.createQuery("SELECT cdr FROM ClassDeityRequirement cdr WHERE cdr.deity.id = " + realId + " ORDER BY cdr.deity.name, cdr.deity.ruleSet.name, cdr.cclass.name, cdr.cclass.ruleSet.name").getResultList();
    }

    public List<ClassRaceRequirement> getClassRaceRequirementsByClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return em.createQuery("SELECT crr FROM ClassRaceRequirement crr WHERE crr.cclass.id = " + realId + " ORDER BY crr.cclass.name, crr.cclass.ruleSet.name, crr.race.name, crr.race.ruleSet.name").getResultList();
    }

    public List<ClassRaceRequirement> getClassRaceRequirementsByRaceID(String raceid) {
        em = getEntityManager();
        long realId = convertID(raceid);
        return em.createQuery("SELECT crr FROM ClassRaceRequirement crr WHERE crr.race.id = " + realId + " ORDER BY crr.race.name, crr.race.ruleSet.name, crr.cclass.name, crr.cclass.ruleSet.name").getResultList();
    }

    public List<FeatClassRequirement> getFeatClassRequirementsByFeatID(String featid) {
        em = getEntityManager();
        long realId = convertID(featid);
        return em.createQuery("SELECT fcr FROM FeatClassRequirement fcr WHERE fcr.feat.id = " + realId + " ORDER BY fcr.feat.name, fcr.feat.ruleSet.name, fcr.cclass.name, fcr.cclass.ruleSet.name, fcr.requiredLvl").getResultList();
    }

    public List<FeatClassRequirement> getFeatClassRequirementsByClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return em.createQuery("SELECT fcr FROM FeatClassRequirement fcr WHERE fcr.cclass.id = " + realId + " ORDER BY fcr.cclass.name, fcr.cclass.ruleSet.name, fcr.feat.name, fcr.feat.ruleSet.name, fcr.requiredLvl").getResultList();
    }

    public List<FeatFeatRequirement> getFeatFeatRequirementsByFeatID(String featid) {
        em = getEntityManager();
        long realId = convertID(featid);
        return em.createQuery("SELECT ffr FROM FeatFeatRequirement ffr WHERE ffr.feat.id = " + realId + " ORDER BY ffr.feat.name, ffr.feat.ruleSet.name, ffr.requiredFeat.name, ffr.requiredFeat.ruleSet.name").getResultList();
    }

    public List<FeatFeatRequirement> getFeatFeatRequirementsByRequiredFeatID(String featid) {
        em = getEntityManager();
        long realId = convertID(featid);
        return em.createQuery("SELECT ffr FROM FeatFeatRequirement ffr WHERE ffr.requiredFeat.id = " + realId + " ORDER BY ffr.requiredFeat.name, ffr.requiredFeat.ruleSet.name, ffr.feat.name, ffr.feat.ruleSet.name").getResultList();
    }

    public List<FeatSkillRequirement> getFeatSkillRequirementsByFeatID(String featid) {
        em = getEntityManager();
        long realId = convertID(featid);
        return em.createQuery("SELECT fsr FROM FeatSkillRequirement fsr WHERE fsr.feat.id = " + realId + " ORDER BY fsr.feat.name, fsr.feat.ruleSet.name, fsr.skill.name, fsr.skill.ruleSet.name, fsr.rank").getResultList();
    }

    public List<FeatSkillRequirement> getFeatSkillRequirementsBySkillID(String skillid) {
        em = getEntityManager();
        long realId = convertID(skillid);
        return em.createQuery("SELECT fsr FROM FeatSkillRequirement fsr WHERE fsr.skill.id = " + realId + " ORDER BY fsr.skill.name, fsr.skill.ruleSet.name, fsr.feat.name, fsr.feat.ruleSet.name, fsr.rank").getResultList();
    }

    public FeatBABRequirement getFeatBABRequirementByFeatID(String featid) {
        em = getEntityManager();
        long realId = convertID(featid);
        return (FeatBABRequirement) em.createQuery("SELECT fbr FROM FeatBABRequirement fbr WHERE fbr.feat.id = " + realId).getSingleResult();
    }

    public List<FeatCasterLevelRequirement> getFeatCasterLevelRequirementsByFeatID(String featid) {
        em = getEntityManager();
        long realId = convertID(featid);
        return em.createQuery("SELECT fclr FROM FeatCasterLevelRequirement fclr WHERE fclr.feat.id = " + realId + " ORDER BY fclr.feat.name, fclr.feat.ruleSet.name, fclr.cclass.name, fclr.cclass.ruleSet.name, fclr.casterLvl").getResultList();
    }

    public List<FeatCasterLevelRequirement> getFeatCasterLevelRequirementsByClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return em.createQuery("SELECT fclr FROM FeatCasterLevelRequirement fclr WHERE fclr.cclass.id = " + realId + " ORDER BY fclr.cclass.name, fclr.cclass.ruleSet.name, fclr.feat.name, fclr.feat.ruleSet.name, fclr.casterLvl").getResultList();
    }

    public List<FeatSpellRequirement> getFeatSpellRequirementsByFeatID(String featid) {
        em = getEntityManager();
        long realId = convertID(featid);
        return em.createQuery("SELECT fsr FROM FeatSpellRequirement fsr WHERE fsr.feat.id = " + realId + " ORDER BY fsr.feat.name, fsr.feat.ruleSet.name, fsr.cclass.name, fsr.cclass.ruleSet.name, fsr.spellLvl").getResultList();
    }

    public List<FeatSpellRequirement> getFeatSpellRequirementsByClassID(String classid) {
        em = getEntityManager();
        long realId = convertID(classid);
        return em.createQuery("SELECT fsr FROM FeatSpellRequirement fsr WHERE fsr.cclass.id = " + realId + " ORDER BY fsr.cclass.name, fsr.cclass.ruleSet.name, fsr.feat.name, fsr.feat.ruleSet.name, fsr.spellLvl").getResultList();
    }

    public List<FeatAttributeRequirement> getFeatAttributeRequirementsByFeatID(String featid) {
        em = getEntityManager();
        long realId = convertID(featid);
        return em.createQuery("SELECT far FROM FeatAttributeRequirement far WHERE far.feat.id = " + realId + " ORDER BY far.feat.name, far.feat.ruleSet.name, far.STR, far.DEX, far.CON, far.INTG, far.WIS, far.CHA").getResultList();
    }

    public List<FeatSaveRequirement> getFeatSaveRequirementsByFeatID(String featid) {
        em = getEntityManager();
        long realId = convertID(featid);
        return em.createQuery("SELECT fsr FROM FeatSaveRequirement fsr WHERE fsr.feat.id = " + realId + " ORDER BY fsr.feat.name, fsr.feat.ruleSet.name, fsr.fortSave, fsr.reflSave, fsr.willSave").getResultList();
    }

    public FeatLevelRequirement getFeatLevelRequirementByFeatID(String featid) {
        em = getEntityManager();
        long realId = convertID(featid);
        return (FeatLevelRequirement) em.createQuery("SELECT flr FROM FeatLevelRequirement flr WHERE flr.feat.id = " + realId).getSingleResult();
    }

    public List<FeatAlignmentRequirement> getFeatAlignmentRequirementsByFeatID(String featid) {
        em = getEntityManager();
        long realId = convertID(featid);
        return em.createQuery("SELECT far FROM FeatAlignmentRequirement far WHERE far.feat.id = " + realId + " ORDER BY far.feat.name, far.feat.ruleSet.name, far.alignment").getResultList();
    }

    public List<FeatDeityRequirement> getFeatDeityRequirementsByFeatID(String featid) {
        em = getEntityManager();
        long realId = convertID(featid);
        return em.createQuery("SELECT fdr FROM FeatDeityRequirement fdr WHERE fdr.feat.id = " + realId + " ORDER BY fdr.feat.name, fdr.feat.ruleSet.name, fdr.deity.name, fdr.deity.ruleSet.name").getResultList();
    }

    public List<FeatDeityRequirement> getFeatDeityRequirementsByDeityID(String deityid) {
        em = getEntityManager();
        long realId = convertID(deityid);
        return em.createQuery("SELECT fdr FROM FeatDeityRequirement fdr WHERE fdr.deity.id = " + realId + " ORDER BY fdr.deity.name, fdr.deity.ruleSet.name, fdr.feat.name, fdr.feat.ruleSet.name").getResultList();
    }

    public List<FeatRaceRequirement> getFeatRaceRequirementsByFeatID(String featid) {
        em = getEntityManager();
        long realId = convertID(featid);
        return em.createQuery("SELECT frr FROM FeatRaceRequirement frr WHERE frr.feat.id = " + realId + " ORDER BY frr.feat.name, frr.feat.ruleSet.name, frr.race.name, frr.race.ruleSet.name").getResultList();
    }

    public List<FeatRaceRequirement> getFeatRaceRequirementsByRaceID(String raceid) {
        em = getEntityManager();
        long realId = convertID(raceid);
        return em.createQuery("SELECT frr FROM FeatRaceRequirement frr WHERE frr.race.id = " + realId + " ORDER BY frr.race.name, frr.race.ruleSet.name, frr.feat.name, frr.feat.ruleSet.name").getResultList();
    }

    /**
     * Lisää annetun olion tietokantaan, jos se on oikeaa tyyppiä.
     * 
     */
    public void addToDatabase(Object object) {
        if (object.getClass().getName().matches("Components(.*)") && !object.getClass().getName().equals("Components.Alignment")) {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        }
    }
    
    /**
     * Poistaa annetun objectin ja id:n perusteella rivin objectin taulusta.
     * @param object poistettava olio
     * @param id poistettava id
     */
    public void removeFromDatabase(Object object, long id) {
        em.getTransaction().begin();
        if (object.getClass().getName().matches("Components(.*)") && !object.getClass().getName().equals("Components.Alignment")) {
            em.remove(em.find(object.getClass(), id));
        }
        em.getTransaction().commit();
    }

    /**
     * Poistaa RuleSetin tietokannasta.
     * @param rset
     * @param name 
     */
    public void removeRuleSetFromDatabase(RuleSet rset, String name) {
        em.getTransaction().begin();
        em.remove(em.find(rset.getClass(), name));
        em.getTransaction().commit();
    }

    /**
     * Muuttaa String-muotoisen ID:n longiksi.
     * @param id
     * @return 
     */
    private long convertID(String id) {
        return (long) Integer.parseInt(id);
    }
}
