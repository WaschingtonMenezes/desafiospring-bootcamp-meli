package com.desafiospringboot.Utils;

import com.desafiospringboot.Entities.Post;
import com.desafiospringboot.Enum.OrderEnum;

import java.util.Comparator;
import java.util.List;

public class SortByDate {
    public static void sort(List<Post> posts, OrderEnum order) {
        Comparator<Post> comparator;

        if (order.equals(OrderEnum.ASC))
            comparator = Comparator.comparing(Post::getDate);
        else
            comparator = Comparator.comparing(Post::getDate).reversed();

        posts.sort(comparator);
    }
}
