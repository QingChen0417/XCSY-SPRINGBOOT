package com.zzxy.common.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Cnode implements Serializable {
	/**重写序列化
	 * */
	private static final long serialVersionUID = -4174695295312548723L;
	private int id;//分类id
	private String name;//分类名
	private int parentId;//分类单id
}
