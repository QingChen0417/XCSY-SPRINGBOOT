package com.zzxy.common.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Node implements Serializable {
	/**重写序列化
	 * */
	private static final long serialVersionUID = -4174695295312548723L;
	private int id;//菜单id
	private String name;//菜单名
	private int parentId;//父菜单id
}
