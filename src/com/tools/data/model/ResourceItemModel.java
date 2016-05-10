package com.tools.data.model;

public class ResourceItemModel {

	private String name;
	private String extension;
	private String path;
	private String ucmdbVersion;
	private String updated;
	private String isFactory;
	private String packageName;

	public ResourceItemModel() {
		this.name = "";
		this.extension = "";
		this.path = "";
		this.ucmdbVersion = "";
		this.updated = "";
		this.isFactory = "";
		this.packageName = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUcmdbVersion() {
		return ucmdbVersion;
	}

	public void setUcmdbVersion(String ucmdbVersion) {
		this.ucmdbVersion = ucmdbVersion;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getIsFactory() {
		return isFactory;
	}

	public void setIsFactory(String isFactory) {
		this.isFactory = isFactory;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

}
