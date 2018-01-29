package com.test;

import java.io.File;

public class TestSearchFile {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 递归显示C盘下所有文件夹及其中文件
		File root = new File("/Users/qiang/Documents/salesforceWorkspace");
		showAllFiles(root);
	}

	static void showAllFiles(File dir) throws Exception {
		File[] fs = dir.listFiles();
		for (int i = 0; i < fs.length; i++) {
			//System.out.println(fs[i].getAbsolutePath());
			if (fs[i].isDirectory()) {
				try {
					showAllFiles(fs[i]);
				} catch (Exception e) {
				}
			} else {
				if (fs[i].getName().equals(".manifest")) {
					System.out.println(fs[i].getName());
					//fs[i].delete();
				}
			}
		}
	}
}
