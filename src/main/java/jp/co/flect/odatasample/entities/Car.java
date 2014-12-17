package jp.co.flect.odatasample.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import java.util.Date;

import lombok.Data;

@Entity
@Data
public class Car {

	@Id
	private Integer car_id;

	private String car_name;

	@JoinColumn(name = "maker_id")
	@ManyToOne(fetch=FetchType.LAZY)
	private Maker maker;

	private Integer display_Order;

	private Boolean del_Flg;

	private Date insert_date;

	private Date update_date;
}
