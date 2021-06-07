package br.com.desafiospring.desafiospring.service.user.order;

import br.com.desafiospring.desafiospring.dto.user.FollowDto;
import br.com.desafiospring.desafiospring.exception.order.InvalidOrderException;

import java.util.Arrays;
import java.util.Comparator;

public enum Order {
    NAME_ASC("name_asc", new NameAscComparator()),
    NAME_DESC("name_desc", new NameDescComparator());


    private String name;
    private final Comparator<FollowDto> comparator;
    private static final String ORDER_IS_NOT_VALID = "Order [%s] is not valid";


    Order(String name, Comparator<FollowDto> comparator) {
        this.name = name;
        this.comparator = comparator;
    }

    public static Order getOrderByName(String name){
        return Arrays.stream(Order.values())
                .filter(order -> order.getName().equals(name))
                .findFirst()
                .orElseThrow(()-> new InvalidOrderException(String.format(ORDER_IS_NOT_VALID, name)));
    }

    public String getName() {
        return name;
    }

    public Comparator<FollowDto> getComparator(){
        return comparator;
    }
}
