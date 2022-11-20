package com.spring.boilerplate.api.model.entity;

import com.spring.boilerplate.api.model.base.BaseUser;
import com.spring.boilerplate.api.model.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
@Entity
@Table(name = "customer")
@EntityListeners(AuditingEntityListener.class)
public class Customer extends BaseUser {
    private static final Logger LOGGER = LoggerFactory.getLogger(Customer.class);

    @Id
    @GenericGenerator(name = "customer_generator", strategy = "increment")
    @GeneratedValue(generator = "customer_generator")
    private Long id;


    public static Customer fromDto(CustomerDto dto) {
        Customer converted = new Customer();
        BeanUtils.copyProperties(dto, converted);
        return converted;

    }
}
