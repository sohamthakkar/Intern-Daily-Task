package com.example.userorg.servicesImp;

import com.example.userorg.customException.ResourceNotFound;
import com.example.userorg.dao.OrgDao;
import com.example.userorg.model.Orgenization;
import com.example.userorg.servics.OrgServices;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrgServicesImp implements OrgServices {

    @Autowired
    OrgDao orgDao;

    @Override
    public Orgenization saveOrg(Orgenization org) {
        return orgDao.save(org);
    }

    @Override
    public List<Orgenization> getAllOrg() {
        return orgDao.findAll();
    }

    @Override
    public Orgenization getOneOrg(long id) {
        return orgDao.findById(id).orElseThrow(() -> new ResourceNotFound("Organization Id: "+id+" is not found"));
    }

    @Override
    public Orgenization updateOrgenization(long id, Orgenization org) {
        Orgenization orgs = orgDao.findById(id).orElseThrow(() -> new ResourceNotFound("Organization Id: "+id+" is not found"));
        org.setOrgId(id);
        return orgDao.save(org);
    }

    @Override
    public void deleteOrgenization(long id) {
        Orgenization orgs = orgDao.findById(id).orElseThrow(() -> new ResourceNotFound("Organization Id: "+id+" is not found"));
        orgDao.delete(orgs);
    }
}
