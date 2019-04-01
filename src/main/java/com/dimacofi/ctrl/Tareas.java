/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimacofi.ctrl;

import com.dimacofi.DAO.HibernateUtil;
import com.dimacofi.DAO.NomUsr;
import com.dimacofi.DAO.Users;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author nvelasquez
 */
public class Tareas {

    public Tareas() {
    }
   
    public String login(String user, String pass) throws JsonProcessingException {

        String Json = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        ObjectMapper objectMapper = new ObjectMapper();

        Users usr = (Users) session.createCriteria(Users.class)
                .add(Restrictions.eq("userName", user))
                .add(Restrictions.eq("password", pass))
                .setMaxResults(1)
                .uniqueResult();

        NomUsr nom = null;
        if (usr != null) {
            nom = (NomUsr) session.createCriteria(NomUsr.class)
                    .add(Restrictions.eq("idUser", usr.getIdUser()))
                    .setMaxResults(1)
                    .uniqueResult();
        }

        Json = objectMapper.writeValueAsString(nom);

        return Json;

    }

    
    
}
