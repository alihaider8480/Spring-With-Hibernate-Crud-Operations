package com.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.pojo.StudentPojo;
import com.spring.service.StudentService;

@Controller
public class RequestController 
{
	@Autowired
	StudentService studentservice; 
	
    @PostMapping("/Insert")
    public String insertstudentinfo(@ModelAttribute("insert_attribute") @Valid StudentPojo obj ,Model model,BindingResult bind1)
    {
    	if(bind1.hasErrors())
    	{
    		model.addAttribute("cheack1","Error");
    		return "Error";
    	}
    	model.addAttribute("cheack1",studentservice.insertstudentdata(obj));
    	return "index1";
    }
    
    @PostMapping("/Update")
    public String updatetudentinfo(@ModelAttribute("update_attribute") @Valid StudentPojo obj ,Model model,BindingResult bind1)
    {
    	if(bind1.hasErrors())
    	{
    		model.addAttribute("cheack1","Error");
    		return "Error";
    	}
    	model.addAttribute("cheack1",studentservice.updatestudentdata(obj));
    	return "updatepage";
    }
    
    @GetMapping("/Delete/{get_delete_id}")
    public String deletetudentinfo(@PathVariable("get_delete_id") int found_delete_id,Model model)
    {
    	model.addAttribute("cheack5",studentservice.deletestudentdata(found_delete_id));
    	return "redirect:/GetAllStudentRecord";
    }
    
    @PostMapping("/GetSingleStudentRecord")
    public String getsinglestundentlist(@ModelAttribute("getsingle_attribute") @Valid StudentPojo obj ,Model model,BindingResult bind1)
    {
    	if(bind1.hasErrors())
    	{
    		model.addAttribute("cheack1","Error");
    		return "Error";
    	}
    	StudentPojo studentpojo_obj_final = studentservice.show_single_record(obj.getId());
    	model.addAttribute("single_List",studentpojo_obj_final);
    	return "index1";
    }
    
    @GetMapping("/GetSingleRecordForUpdate/{getid}")
    public String GetSingleStundentListforUpdate(@PathVariable("getid") int foundid,Model model)
    {	
    	StudentPojo studentpojo_obj_final = studentservice.show_single_record(foundid);
    	model.addAttribute("update_list",studentpojo_obj_final);
    	return "updatepage";
    }
    
    
    @GetMapping("/GetAllStudentRecord")
    public String getallstundentlist(Model model)
    {
    	List<StudentPojo> studentpojo_obj_finals = studentservice.show_all_record();
    	model.addAttribute("all_List",studentpojo_obj_finals);
    	return "show_records";
    }    
} 