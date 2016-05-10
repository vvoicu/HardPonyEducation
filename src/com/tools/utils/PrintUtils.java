package com.tools.utils;

import java.util.List;

import com.tools.data.model.PackageItemModel;
import com.tools.data.model.ResourceItemModel;

public class PrintUtils {

	public static void printPackageItemModelList(List<PackageItemModel> resultList) {
		for (PackageItemModel dashboardItemModel : resultList) {
			printpackageItemModel(dashboardItemModel);
		}
	}
	
	public static void printpackageItemModel(PackageItemModel dashboardItemModel){
		System.out.println("--------------");
		System.out.println("name: " + dashboardItemModel.getName());
		System.out.println("category: " + dashboardItemModel.getCategory());
		System.out.println("redme: " + dashboardItemModel.getReadme());
		System.out.println("version: " + dashboardItemModel.getVersion());
		System.out.println("build: " + dashboardItemModel.getBuild());
		System.out.println("description: " + dashboardItemModel.getDescription());
	}

	public static void printResourceItemList(List<ResourceItemModel> resourceItemModelList) {
		for (ResourceItemModel resourceItemModel : resourceItemModelList) {
			printResourceItemModel(resourceItemModel);
		}
	}
	
	public static void printResourceItemModel(ResourceItemModel resourceItemModel){
		System.out.println("--------------");
		System.out.println("Name: " + resourceItemModel.getName());
		System.out.println("Extension: " + resourceItemModel.getExtension());
		System.out.println("Path: " + resourceItemModel.getPath());
		System.out.println("CMDB Version: " + resourceItemModel.getUcmdbVersion());
		System.out.println("Updated: " + resourceItemModel.getUpdated());
		System.out.println("Is Factory: " + resourceItemModel.getIsFactory());
		System.out.println("Package Name: " + resourceItemModel.getPackageName());
	}
}
