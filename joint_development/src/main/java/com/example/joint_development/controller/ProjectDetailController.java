package com.example.joint_development.controller;

import com.example.joint_development.domain.Belongs;
import com.example.joint_development.service.BelongsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/projectDetail")
@CrossOrigin
public class ProjectDetailController {
    
    @Autowired
    private BelongsService belongsService;

    /** 参加申請 データ登録 */
    @PostMapping("/join")
    public void joinProject(int userId,int projectId){
        belongsService.joinProject(userId, projectId);
    }

    /** ステータス確認 */
    @GetMapping("/getStatus")
    public String confirmStatus(int userId,int projectId){
        return belongsService.confirmStatus(userId, projectId);
    }

    /** ステータス更新 */
    @PostMapping("/updateStatus")
    public void updateStatus(Belongs belongs){
        belongsService.updateStatus(belongs);
    }
}