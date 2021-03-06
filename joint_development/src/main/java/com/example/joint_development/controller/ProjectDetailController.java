package com.example.joint_development.controller;

import com.example.joint_development.domain.Belongs;
import com.example.joint_development.service.BelongsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/projectDetail")
@CrossOrigin
public class ProjectDetailController {
    
    @Autowired
    private BelongsService belongsService;

    /** upsert処理
     *  参加申請orステータス更新 */
    @PostMapping("/upsert")
    public void upsert(@RequestBody Belongs belongs){
        belongsService.updateStatus(belongs);
    }
    
}
