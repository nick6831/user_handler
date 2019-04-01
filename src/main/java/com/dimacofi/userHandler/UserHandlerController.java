/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimacofi.userHandler;

import com.dimacofi.ctrl.Tareas;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nvelasquez
 */
@RequestMapping(value = "/")
@RestController
@ResponseBody
public class UserHandlerController {
  
    
     @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> login(@RequestParam("user") String user, @RequestParam("pass") String pass) throws JsonProcessingException {

        
        Tareas p = new Tareas();
        String json = p.login(user, pass);
        if (!json.equals("null")) {
            return ResponseEntity.ok(json);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay");
        }
    }

   
    
}
