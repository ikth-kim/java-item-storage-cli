package com.minijava.repository;

import com.minijava.common.FilePathConstants;
import com.minijava.dto.ItemDTO;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ItemFileIORepository implements ItemRepositoryInterface{

    private List<ItemDTO> itemDTOList;

    public ItemFileIORepository() {
        this.itemDTOList = load(); // 생성자를 통해 기존 파일에 저장되어 있던 데이터들을 List<ItemDTO>형태로 items에 넣음
    }

    /**
     * 실행 시, 정해진 파일경로에서 ItemDTO 객체들을 리스트로 불러온다
     * @return 파일에 저장된 ItemDTO 객체 리스트
     */
    private List<ItemDTO> load() {
        File file = new File(FilePathConstants.INVENTORY_FILE_PATH);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<ItemDTO>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    @Override
    public void addItem(ItemDTO item) {

    }

    @Override
    public ItemDTO findById(Integer id) {
        return null;
    }

    @Override
    public ItemDTO findByName(String name) {
        return null;
    }

    @Override
    public List<ItemDTO> findByKeyword(String keyword) {
        return List.of();
    }

    @Override
    public List<ItemDTO> findAll() {
        return List.of();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Integer getLastItemNumber() {
        return 0;
    }
}
