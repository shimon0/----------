package com.example.joint_development.repository;

import com.example.joint_development.domain.RecruitLang;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecruitLangMapper {
    
    /** エンジニア募集人数　登録 */
    public void recruitLangCount(RecruitLang recruitLang);
}
