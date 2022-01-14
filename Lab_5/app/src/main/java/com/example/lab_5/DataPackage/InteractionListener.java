package com.example.lab_5.DataPackage;

import java.util.List;

public interface InteractionListener {
    void onDeleteItem(ItemData i);
    List<ItemData> getItems();
}
