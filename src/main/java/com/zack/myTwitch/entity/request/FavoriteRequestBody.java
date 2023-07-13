package com.zack.myTwitch.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zack.myTwitch.entity.db.Item;

public class FavoriteRequestBody {
    @JsonProperty("favorite")
    private Item favoriteItem;

    public Item getFavoriteItem() {
        return favoriteItem;
    }

}
