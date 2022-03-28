package com.example.userorg.controller;

import com.example.userorg.model.Orgenization;
import com.example.userorg.servics.OrgServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/org")
public class OrgController {

    @Autowired
    OrgServices orgServices;

    @PostMapping("/addOrg")
    public Orgenization addOrganization(@Valid @RequestBody Orgenization org) {
        return orgServices.saveOrg(org);
    }

    @GetMapping("/getOrgs")
    public List<Orgenization> getAllOrg(){
        return orgServices.getAllOrg();
    }
    @GetMapping("/{id}")
    public Orgenization getOneOrg(@PathVariable long id){
        return orgServices.getOneOrg(id);
    }
    @PutMapping("/{id}")
    public Orgenization updateOrgenization(@PathVariable long id,@Valid @RequestBody Orgenization org){
        return orgServices.updateOrgenization(id,org);
    }

    @DeleteMapping("/{id}")
    public String deleteOrgenization(@PathVariable long id){
        orgServices.deleteOrgenization(id);
        return "Deleted Data";
    }
}
