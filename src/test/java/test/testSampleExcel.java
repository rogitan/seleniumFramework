package test;

import java.io.IOException;
import java.util.ArrayList;

import data.dataReaderExcel;

public class testSampleExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		dataReaderExcel d = new dataReaderExcel();
		ArrayList<String> data =d.getData("Add Profil");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		

	}

}
