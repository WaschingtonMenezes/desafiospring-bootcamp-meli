package com.desafiospringboot.Utils;

import java.util.Comparator;
import java.util.List;

import com.desafiospringboot.Entities.User;
import com.desafiospringboot.Enum.OrderEnum;

public class SortByName {

	public static void sort(List<? extends User> users, OrderEnum orderEnum) {
		Comparator<User> comparator;

		if (orderEnum.equals(OrderEnum.ASC)) {
			comparator = Comparator.comparing(User::getName);
		} else {
			comparator = Comparator.comparing(User::getName).reversed();
		}
		
		users.sort(comparator);
	}
}
