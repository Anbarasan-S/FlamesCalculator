package com.Action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class Flames extends ActionSupport
{
	private String name,crush_name;
	
	public String getName() {
		return name;
	}

	public String getCrush_name() {
		return crush_name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCrush_name(String crush_name) {
		this.crush_name = crush_name;
	}
	
	private String calculate()
	{
		List<Character>Flames=new LinkedList<>(Arrays.asList('F','L','A','M','E','S'));
		String Name=name.toLowerCase(),Crush_Name=crush_name.toLowerCase();
		for(char ch:Name.toCharArray())
		{
			if(Crush_Name.indexOf(ch)!=-1)
			{
				Crush_Name=Crush_Name.replaceFirst(Character.toString(ch),"");
				Name=Name.replaceFirst(Character.toString(ch),"");
			}
		}
		 int length=Crush_Name.length()+Name.length();
			if(length==0)
			{
	            return "Friends";
	        }
			int ptr=0;
			while(Flames.size()>1)
			{
	            int val=(ptr+(length-1))%Flames.size();
	            Flames.remove(val);
	            ptr=val%Flames.size();
			}
			
	       char res=Flames.get(0);
	       Map<Character,String>res_map=new HashMap<Character,String>() {{
	    	   put('F',"Friend");
	    	   put('L',"Love");
	    	   put('A',"Affection");
	    	   put('M',"Marriage");
	    	   put('E',"Enemy");
	    	   put('S',"Sister");
	       }};
	       return res_map.get(res);
	}
	
	public String execute()
	{
		
		addActionMessage(calculate());
		return "success";
	}
}
