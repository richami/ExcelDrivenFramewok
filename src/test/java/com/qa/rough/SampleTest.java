package com.qa.rough;

import java.io.IOException;

import com.qa.datadriven.DataDriven;

public class SampleTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<2;j++)
			{
				String v=DataDriven.fetachDatafromExcel("Sheet1",i,j);
				System.out.print(v+"\t");
			}
			System.out.println();
		}
	}

}
