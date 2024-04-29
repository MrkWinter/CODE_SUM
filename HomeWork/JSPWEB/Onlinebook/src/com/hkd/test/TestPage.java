package com.hkd.test;

import java.util.ArrayList;

import org.junit.Test;

public class TestPage {
	@Test
	public void testCount()
	{
		ArrayList<ArrayList> clist=new ArrayList<ArrayList>();
		for(int i=1;i<=21;i+=5)
		{
			ArrayList<Integer> tlist=new ArrayList<Integer>();
			for(int j=i;j<=i+4;j++)
			{
				if(j<=21)
				tlist.add(j);
			}
			clist.add(tlist);
		}
		for(int m=0;m<clist.get(4).size();m++)
		{
			System.out.println(clist.get(4).get(m));
		}
		
		
		
	}

}
