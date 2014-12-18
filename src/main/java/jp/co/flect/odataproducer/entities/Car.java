package jp.co.flect.odataproducer.entities;

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

	private Integer maker_id;

	private Integer display_order;

	private Boolean del_flg;

	private Date insert_date;

	private Date update_date;
}
