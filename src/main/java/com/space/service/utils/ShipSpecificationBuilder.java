package com.space.service.utils;

import com.space.model.ShipEntity;
import com.space.model.ShipType;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class ShipSpecificationBuilder {

    // https://www.w3schools.com/sql/sql_like.asp
    public static Specification<ShipEntity> stringSpec(String attribute, String value) {
        return (root, query, criteriaBuilder) ->
                value == null ? null : criteriaBuilder.like(root.get(attribute), "%" + value + "%");
    }


    public static Specification<ShipEntity> shipTypeSpec(ShipType shipType) {
        return (root, query, criteriaBuilder) ->
                shipType == null ? null : criteriaBuilder.equal(root.get("shipType"), shipType);
    }

    public static Specification<ShipEntity> prodDateSpec(Long milis, boolean isAfter) {
        if (milis == null)
            return null;

        Date date = new Date(milis);
        return ((root, query, criteriaBuilder) ->
                isAfter ? criteriaBuilder.greaterThanOrEqualTo(root.get("prodDate"), date) :
                        criteriaBuilder.lessThanOrEqualTo(root.get("prodDate"), date)
        );
    }

    public static Specification<ShipEntity> doubleSpec(String attribute, Double number, boolean isGreater) {
        if (number == null)
            return null;

        return ((root, query, criteriaBuilder) ->
                isGreater ? criteriaBuilder.greaterThanOrEqualTo(root.get(attribute), number) :
                        criteriaBuilder.lessThanOrEqualTo(root.get(attribute), number)
        );
    }

    public static Specification<ShipEntity> intSpec(String attribute, Integer number, boolean isGreater) {
        if (number == null)
            return null;

        return ((root, query, criteriaBuilder) ->
                isGreater ? criteriaBuilder.greaterThanOrEqualTo(root.get(attribute), number) :
                        criteriaBuilder.lessThanOrEqualTo(root.get(attribute), number)
        );
    }

    public static Specification<ShipEntity> isUsedSpec(Boolean value) {
        if (value == null)
            return null;

        return (root, query, criteriaBuilder) ->
                value ? criteriaBuilder.isTrue(root.get("isUsed")) : criteriaBuilder.isFalse(root.get("isUsed"));
    }

}
