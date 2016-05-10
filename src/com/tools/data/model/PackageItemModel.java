package com.tools.data.model;


/**
 * Model describes items found on the site Dashboard - Package list tab. Constructor of the model will initialize all fields as empty strings.
 * Fields described in the model should correspond to all posible available columns of the list.
 * @author vvoicu
 *
 */
public class PackageItemModel {

	private String name;
	private String category;
	private String readme;
	private String version;
	private String build;
	private String description;
	
	public PackageItemModel(){
		this.name = "";
		this.category = "";
		this.readme = "";
		this.version = "";
		this.build = "";
		this.description = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getReadme() {
		return readme;
	}

	public void setReadme(String readme) {
		this.readme = readme;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
