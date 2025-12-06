package com.minijava.service;

import com.minijava.dto.ItemDTO;

public interface ItemAddService {

    /**
     * number를 제외한 ItemDTO의 필드값들을 입력받아 number는 프로그램 내에서 부여함
     * @param name
     * @param rank
     * @param quality
     * @param power
     * @return
     */
    int itemAdd(String name, String rank, String quality, int power);
}
