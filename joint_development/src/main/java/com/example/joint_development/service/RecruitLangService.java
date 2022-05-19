package com.example.joint_development.service;

import com.example.joint_development.domain.RecruitLang;
import com.example.joint_development.repository.RecruitLangMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RecruitLangService {
    
    @Autowired
    private RecruitLangMapper recruitLangMapper;

    /** エンジニア募集人数　登録 */
    public void recruitLangCount(RecruitLang recruitLang){
        recruitLangMapper.recruitLangCount(recruitLang);
    }
}
