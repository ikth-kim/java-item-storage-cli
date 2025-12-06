package com.minijava.service.impl;

import com.minijava.dto.ItemDTO;
import com.minijava.repository.ItemRepository;
import com.minijava.repository.ItemRepositoryInterface;
import com.minijava.service.ItemAddService;

public class ItemAddServiceImpl implements ItemAddService {
    final ItemRepositoryInterface itemRepository;

    ItemAddServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public int itemAdd(String name, String rank, String quality, int power) {
        int newItemNumber = itemRepository.getLastItemNumber() + 1;
        itemRepository.save(new ItemDTO(newItemNumber, name, rank, quality, power));
        return newItemNumber;
    }
}
