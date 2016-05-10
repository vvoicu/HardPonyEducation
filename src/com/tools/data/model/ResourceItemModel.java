package com.tools.data.model;

public class ResourceItemModel {

	private String name;
	private String extension;
	private String path;
	private String uCMDBVersion;
	private String updated;
	private String iSFactory;
	private String packageName;

	public ResourceItemModel() {
		this.name = "";
		this.extension = "";
		this.path = "";
		this.uCMDBVersion = "";
		this.updated = "";
		this.iSFactory = "";
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

	public String getCMDBVersion() {
		return uCMDBVersion;
	}

	public void setuCMDBVersion(String uCMDBVersion) {
		this.uCMDBVersion = uCMDBVersion;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getISFactory() {
		return iSFactory;
	}

	public void setiSFactory(String iSFactory) {
		this.iSFactory = iSFactory;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

}
