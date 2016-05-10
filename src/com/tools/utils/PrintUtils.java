package com.tools.utils;

import java.util.List;

import com.tools.data.model.PackageItemModel;

public class PrintUtils {

	public static void printDashboardItemModelList(List<PackageItemModel> resultList) {
		for (PackageItemModel dashboardItemModel : resultList) {
			printDashboardItemModel(dashboardItemModel);
		}
	}
	
	public static void printDashboardItemModel(PackageItemModel dashboardItemModel){
		System.out.println("--------------");
		System.out.println("name: " + dashboardItemModel.getName());
		System.out.println("category: " + dashboardItemModel.getCategory());
		System.out.println("redme: " + dashboardItemModel.getReadme());
		System.out.println("version: " + dashboardItemModel.getVersion());
		System.out.println("build: " + dashboardItemModel.getBuild());
		System.out.println("description: " + dashboardItemModel.getDescription());
	}
}
