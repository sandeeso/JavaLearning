package soni.sandeep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import soni.sandeep.dao.HumanManagerImpl;
import soni.sandeep.entity.People;

import java.sql.SQLException;


@RestController
@RequestMapping("/")
public class EnquiryController {

    @Autowired
    HumanManagerImpl humanManager;

    @RequestMapping("peoples")
    public People findAll(@RequestParam Integer id) throws SQLException {


        return humanManager.finding(id);
    }

    @GetMapping("abc")
    public String find() throws SQLException {
         humanManager.save();
         return "OK";
    }

    @RequestMapping ("name")
    public String name () throws SQLException {
        humanManager.savePersist();
        return "OK";
    }

}
