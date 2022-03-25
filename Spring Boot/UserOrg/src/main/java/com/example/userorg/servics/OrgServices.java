package com.example.userorg.servics;

import com.example.userorg.model.Orgenization;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrgServices {
    Orgenization saveOrg(Orgenization org);

    List<Orgenization> getAllOrg();

    Orgenization getOneOrg(long id);

    Orgenization updateOrgenization(long id, Orgenization org);

    void deleteOrgenization(long id);
}
