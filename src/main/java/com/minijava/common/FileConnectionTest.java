package com.minijava.common;

import com.minijava.dto.ItemDTO;

import java.io.*;

public class FileConnectionTest {
    public static void main(String[] args) {
        deleteTest();
        writeTest();
        readTest();
        deleteTest();
    }

    private static void deleteTest() {
        File file = new File(FilePathConstants.INVENTORY_TEST_FILE_PATH);
        if (file.delete()) {
            System.out.println("파일 삭제 성공");
        } else {
            System.out.println("파일 삭제 실패");
        }
    }

    private static void writeTest() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FilePathConstants.INVENTORY_TEST_FILE_PATH))) {
            ItemDTO[] itemDTOS = {
                    new ItemDTO(1, "정현호", "레전더리", "최고", 560000),
                    new ItemDTO(2, "정현규", "레전더리", "최고", 560001),
                    new ItemDTO(3, "정현수", "레전더리", "최고", 560002)
            };
            oos.writeObject(itemDTOS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readTest() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FilePathConstants.INVENTORY_TEST_FILE_PATH))) {
            ItemDTO[] itemDTOS = (ItemDTO[])ois.readObject();
            for (ItemDTO itemDTO : itemDTOS) {
                System.out.println(itemDTO);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
