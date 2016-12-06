package com.xlx.healthfood.data;

public class FoodInfo {
	private String name;		//����
	private String dietName;		//��ʳʳ��
	private int resourceId;		//ͼƬid
	private String foodInfo;	//���
	
	private String eName;	//��ʳʳ������
	private String eInfo;	//��ʳԭ��
	public FoodInfo(String name, String dietName, int resourceId,
			String foodInfo, String eName, String eInfo) {
		super();
		this.name = name;
		this.dietName = dietName;
		this.resourceId = resourceId;
		this.foodInfo = foodInfo;
		this.eName = eName;
		this.eInfo = eInfo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDietName() {
		return dietName;
	}
	public void setDietName(String dietName) {
		this.dietName = dietName;
	}
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public String getFoodInfo() {
		return foodInfo;
	}
	public void setFoodInfo(String foodInfo) {
		this.foodInfo = foodInfo;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteInfo() {
		return eInfo;
	}
	public void seteInfo(String eInfo) {
		this.eInfo = eInfo;
	}
	
	
}
